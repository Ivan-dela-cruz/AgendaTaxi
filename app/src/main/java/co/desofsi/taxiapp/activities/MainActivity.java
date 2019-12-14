package co.desofsi.taxiapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import co.desofsi.taxiapp.R;
import co.desofsi.taxiapp.helpers.SQLiteHelper;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///****************   EJECUCION SQLITE   *****************

        sqLiteHelper = new SQLiteHelper(this, "taxi.sqlite", null, 1);
        SQLiteDatabase database = sqLiteHelper.getWritableDatabase();
        database.close();




        ///*************** contactos
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_cat_ingresos);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewContactActivity.class);
                startActivity(intent);
            }
        });



        ///*************** TAXIs
        final LinearLayout linearLayoutGastos = (LinearLayout) findViewById(R.id.layout_cat_gasto);
        linearLayoutGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewContactActivity.class);
                startActivity(intent);
            }
        });

///*************** Nuevo CONTACTOS
        final LinearLayout linearLayoutRegistroIngreso = (LinearLayout) findViewById(R.id.layout_ingresos);
        linearLayoutRegistroIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewContactActivity.class);
                startActivity(intent);
            }
        });



        ///*************** AÑADIR TAXIS
        final LinearLayout linearLayoutRegistroGastos = (LinearLayout) findViewById(R.id.layout_gastos);
        linearLayoutRegistroGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewContactActivity.class);
                startActivity(intent);
            }
        });






    }
}
