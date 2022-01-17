package com.android.practica1_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Question1 extends AppCompatActivity {

    int puntuacion;
    RadioButton q1_1,q1_2,q1_3,q1_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        this.puntuacion=0;
        this.puntuacion=(int)getIntent().getExtras().getInt("PUNTUACION");
        q1_1= (RadioButton) findViewById(R.id.radioButtonq1_1);
        q1_2= (RadioButton) findViewById(R.id.radioButtonq1_2);
        q1_3= (RadioButton) findViewById(R.id.radioButtonq1_3);
        q1_4= (RadioButton) findViewById(R.id.radioButtonq1_4);
    }

    public void Corregir(View view) {
        if (q1_2.isChecked()) {
            Toast.makeText(this,"CORRECTO :) +3 puntos",Toast.LENGTH_SHORT).show();
            this.puntuacion=this.puntuacion+3;
            Intent seguir = new Intent(this, Question2.class);
            seguir.putExtra("PUNTUACION", this.puntuacion);
            startActivity(seguir);
        }else if(q1_1.isChecked() || q1_3.isChecked() || q1_4.isChecked()){
            Toast.makeText(this, "Incorrecto :( -2 puntos", Toast.LENGTH_SHORT).show();
            this.puntuacion = this.puntuacion - 2;
            Intent intermedio = new Intent(this, ErrorIntermedio.class);
            intermedio.putExtra("PUNTUACION", this.puntuacion);
            intermedio.putExtra("PREGUNTA", 1);
            startActivity(intermedio);
        }else{
            Toast.makeText(this, "Marque una respuesta antes", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"No puedes volver atrás",Toast.LENGTH_SHORT).show();
    }
}