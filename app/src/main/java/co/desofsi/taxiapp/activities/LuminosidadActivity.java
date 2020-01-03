package co.desofsi.taxiapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import co.desofsi.taxiapp.R;

public class LuminosidadActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;

    private Sensor sensor;


    LineChart chart;

    ArrayList<Entry> values1;
    boolean someCondition = true;
    int contador = 0;
    RefreshTaskTemp temporizador;

    private ImageView imagen;
    private LineChart lineChart;
    private TextView textView;

    private Button button;

    private String valor_sensor = "(x) = 0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luminosidad);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Light Sensor");
        init();
        temporizador.execute();
        //temporizador.cancel();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                someCondition = false;

            }
        });
    }

    public void init() {
        temporizador = new RefreshTaskTemp();
        chart = (LineChart) findViewById(R.id.chart_line_temp);

        values1 = new ArrayList<>();
        button = (Button) findViewById(R.id.btn_stop_light);
        textView = (TextView) findViewById(R.id.txt_temp);
    }

    public void initChart(int x, int y) {


        values1.add(new Entry(x, y));


        LineDataSet d1 = new LineDataSet(values1, "Function  " + "status" + " (time - light)");
        d1.setLineWidth(2.5f);
        d1.setCircleRadius(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);

        LineData lineData = new LineData(d1);
        chart.setData(lineData);
        chart.invalidate(); // refre
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int valor = (int) event.values[0];
        int valor2 = contador;

        valor_sensor = "(x) = " + valor;
        // textView.setText("valor 0 : " + valor + "  valor 1: " + valor2);
        initChart(valor2, valor * 100);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    class RefreshTaskTemp extends AsyncTask {


        @Override
        protected void onProgressUpdate(Object... values) {

            contador++;
            String text = valor_sensor+ "  (y) = "+contador;
            textView.setText(text);

        }

        @Override
        protected Object doInBackground(Object... params) {
            while (someCondition) {
                try {
                    //sleep for 1s in background...
                    Thread.sleep(1000);
                    //and update textview in ui thread
                    publishProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }


            }
            return null;
        }
    }

}
