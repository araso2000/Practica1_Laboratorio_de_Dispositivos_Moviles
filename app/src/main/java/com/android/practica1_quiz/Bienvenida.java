package com.android.practica1_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Bienvenida extends AppCompatActivity {

    int puntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida_layout);
        this.puntuacion=0;
    }

    public void Siguiente(View view) {
        Intent seguir = new Intent(this, Question1.class);
        seguir.putExtra("PUNTUACION", this.puntuacion);
        startActivity(seguir);
    }

    @Override
    public void onBackPressed() {
    }
}