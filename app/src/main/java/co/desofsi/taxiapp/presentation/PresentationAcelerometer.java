package co.desofsi.taxiapp.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.desofsi.taxiapp.*;
import co.desofsi.taxiapp.activities.AcelerometerActivity;

public class PresentationAcelerometer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_acelerometer);
        Button button = (Button) findViewById(R.id.button_ace);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PresentationAcelerometer.this, AcelerometerActivity.class);
                startActivity(intent);
            }
        });
    }
}
