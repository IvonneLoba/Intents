package com.example.a5intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String nombre = "Ivonne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtnombre = findViewById(R.id.txtNombre);
        txtnombre.setText(nombre);


        setContentView(R.layout.activity_main);

        new CountDownTimer(6000, 1000){

            TextView txt = findViewById(R.id.txtConteo);

            @Override
            public void onTick(long l) {

                txt.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                intent.putExtra("nombre", nombre);

                startActivity(intent);
            }

        }.start();


    }
}