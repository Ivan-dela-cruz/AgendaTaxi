package co.desofsi.taxiapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

import co.desofsi.taxiapp.*;
import co.desofsi.taxiapp.models.Avatar;

public class ProximityActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;

    private Sensor sensor;

    private ImageView imageView;
    private TextView textView, txt_press;
    private LottieAnimationView lottieAnimationView;

    int contador = 0;

    private ArrayList<Avatar> lista_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        textView = (TextView) findViewById(R.id.textView);
        txt_press = (TextView) findViewById(R.id.txt_presss);
        imageView = (ImageView) findViewById(R.id.imageView);

        lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        fullAvatars();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float valor = event.values[0];
        textView.setText(String.valueOf(valor));



        if (valor > 0) {

            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
            lottieAnimationView.setVisibility(View.VISIBLE);
            txt_press.setVisibility(View.VISIBLE);

            //textView.setText(String.valueOf(valor));
        } else {

            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
            lottieAnimationView.setVisibility(View.GONE);
            txt_press.setVisibility(View.GONE);

            Avatar avatar = lista_avatar.get(contador);
            imageView.setImageResource(avatar.getId_avatar());
            textView.setText(avatar.getNombre() + "\n"+avatar.getDescripcion());
            if(contador == (lista_avatar.size()-1)){
                contador =-1;
            }
            contador++;
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public void fullAvatars() {
        lista_avatar = new ArrayList<Avatar>();

        lista_avatar.add(new Avatar(1, R.drawable.avatar1, "Juan", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(2, R.drawable.avatar2, "Mario", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(3, R.drawable.avatar3, "Bob", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(4, R.drawable.avatar4, "Oscar", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(5, R.drawable.avatar5, "Matias", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(6, R.drawable.avatar6, "Luis", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(7, R.drawable.avatar7, "Mario", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(8, R.drawable.avatar8, "Jairo", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(9, R.drawable.avatar9, "Goten", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(10, R.drawable.avatar10, "Edwin", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(11, R.drawable.avatar11, "Angel", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(12, R.drawable.avatar12, "Eliot", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(13, R.drawable.avatar13, "Philip", "Divertido y graciosos"));
        lista_avatar.add(new Avatar(14, R.drawable.avatar14, "Dominic", "Divertido y graciosos"));
    }
}
