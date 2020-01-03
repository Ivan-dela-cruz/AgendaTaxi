package co.desofsi.taxiapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import co.desofsi.taxiapp.R;
import co.desofsi.taxiapp.presentation.PresentationAcelerometer;
import co.desofsi.taxiapp.presentation.PresentationLight;
import co.desofsi.taxiapp.presentation.PresentationMagnetic;
import co.desofsi.taxiapp.presentation.PresentationProximity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ///*************** temperature
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_cat_temperature);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PresentationLight.class);
                startActivity(intent);
            }
        });



        ///*************** magnetic
        final LinearLayout linearLayoutManetic = (LinearLayout) findViewById(R.id.layout_magnetic);
        linearLayoutManetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PresentationMagnetic.class);
                startActivity(intent);
            }
        });

///*************** proximity
        final LinearLayout linearLayoutProximity = (LinearLayout) findViewById(R.id.layout_proximity);
        linearLayoutProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PresentationProximity.class);
                startActivity(intent);
            }
        });



        ///*************** acelerometro
        final LinearLayout linearLayoutRegistroGastos = (LinearLayout) findViewById(R.id.layout_acelerometer);
        linearLayoutRegistroGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PresentationAcelerometer.class);
                startActivity(intent);
            }
        });






    }
}
