package com.android.practica1_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PuntuacionFinal extends AppCompatActivity {

    int puntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion_final);
        this.puntuacion=0;
        this.puntuacion=(int)getIntent().getExtras().getInt("PUNTUACION");
        TextView txt = findViewById(R.id.textViewFinal2);
        txt.setText("Puntuación final: " + this.puntuacion);
    }

    public void Rejugar(View view){
        Intent intent = new Intent(this,Bienvenida.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        Intent intent = new Intent(this,Bienvenida.class);
        startActivity(intent);
    }
}