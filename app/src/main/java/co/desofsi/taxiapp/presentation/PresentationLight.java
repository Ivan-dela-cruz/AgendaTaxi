package co.desofsi.taxiapp.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.desofsi.taxiapp.*;
import co.desofsi.taxiapp.activities.LuminosidadActivity;

public class PresentationLight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_light);
        Button button = (Button) findViewById(R.id.button_li);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PresentationLight.this, LuminosidadActivity.class);
                startActivity(intent);
            }
        });
    }
}
