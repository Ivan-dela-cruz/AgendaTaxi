package co.desofsi.taxiapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import androidx.core.app.ActivityCompat;
import co.desofsi.taxiapp.*;

public class AcelerometerActivity extends AppCompatActivity implements SensorEventListener {


    final int REQUEST_CODE_GALLERY = 999;

    private SensorManager sensorManager;

    private Sensor sensor;
    private TextView textView;

    LineChart chart;

    ArrayList<Entry> values1;
    boolean someCondition = true;
    int contador = 0;
    RefreshTask temporizador;

    private Button button;
     private String valor_sensor = "Acelerometer:  0 ; ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometer);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Acelerometer");
        init();
        temporizador.execute();
        //temporizador.cancel();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                someCondition = false;

            }
        });
    }


    public void init() {
        temporizador = new RefreshTask();
        chart = (LineChart) findViewById(R.id.chart_line_ingreso);

        values1 = new ArrayList<>();
        textView = (TextView) findViewById(R.id.txt_valores);
        button = (Button) findViewById(R.id.btn_stop_acelerometro);
    }


    public void initChart(int x, int y) {


        values1.add(new Entry(x, y));


        LineDataSet d1 = new LineDataSet(values1, "Ingresos  " + "describ" + " (Enero - Diciembre)");
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

        valor_sensor = "Acelerometer:  "+valor+" ; ";

        if (valor > 0) {
            //textView.setText("valor 0 : "+valor+"  valor 1: "+valor2);
            initChart(valor2, valor * 100);

        } else {


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    class RefreshTask extends AsyncTask {


        @Override
        protected void onProgressUpdate(Object... values) {

            contador++;
            String text = valor_sensor + "Timer: " +contador;
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
