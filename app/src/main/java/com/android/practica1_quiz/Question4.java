package com.android.practica1_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Question4 extends AppCompatActivity {

    int puntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        this.puntuacion=0;
        this.puntuacion=(int)getIntent().getExtras().getInt("PUNTUACION");
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"No puedes volver atrás",Toast.LENGTH_SHORT).show();
    }

    public void correcto(View view){
        Toast.makeText(this,"CORRECTO :) +3 puntos",Toast.LENGTH_SHORT).show();
        this.puntuacion=this.puntuacion+3;
        Intent seguir = new Intent(this, Question5.class);
        seguir.putExtra("PUNTUACION", this.puntuacion);
        startActivity(seguir);
    }

    public void incorrecto(View view){
        Toast.makeText(this, "Incorrecto :( -2 puntos", Toast.LENGTH_SHORT).show();
        this.puntuacion = this.puntuacion - 2;
        Intent intermedio = new Intent(this, ErrorIntermedio.class);
        intermedio.putExtra("PUNTUACION", this.puntuacion);
        intermedio.putExtra("PREGUNTA", 4);
        startActivity(intermedio);
    }
}