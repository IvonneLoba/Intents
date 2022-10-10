package com.example.a5intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        setContentView(R.layout.activity_inicio);
        findViewById(R.id.btnCompartir).setOnClickListener(this);
        findViewById(R.id.btnMapa).setOnClickListener(this);
        findViewById(R.id.btnWeb).setOnClickListener(this);
        findViewById(R.id.btnCorreo).setOnClickListener(this);
        findViewById(R.id.btnLlamar).setOnClickListener(this);

        TextView txt = findViewById(R.id.txtNombre);

        Bundle extras=getIntent().getExtras();
        String name = extras.getString("nombre");
        txt.setText(name);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnCompartir:
                Intent intent1 = new Intent(Intent.ACTION_SEND);

                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_SUBJECT, "Prueba");
                intent1.putExtra(Intent.EXTRA_TEXT, "Hola!!!!");

                this.startActivity(Intent.createChooser(intent1, "Compartir"));
                break;
            case R.id.btnMapa:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=utt"));
                startActivity(intent2);
                break;
            case R.id.btnWeb:
                Intent intent3 = new Intent(Intent.ACTION_VIEW);
                intent3.setData(Uri.parse("https://www.google.es/"));
                startActivity(intent3);

                break;
            case R.id.btnCorreo:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"ivncrdz@gmail.com"});
                startActivity(Intent.createChooser(emailIntent, "Enviar mail"));
                break;
            case R.id.btnLlamar:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 8712593226"));
                startActivity(callIntent);
        }
    }
}