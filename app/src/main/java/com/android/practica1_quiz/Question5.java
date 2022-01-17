package com.android.practica1_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Question5 extends AppCompatActivity {

    int puntuacion;
    RadioButton q5_1,q5_2,q5_3,q5_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        this.puntuacion=0;
        this.puntuacion=(int)getIntent().getExtras().getInt("PUNTUACION");
        q5_1= (RadioButton) findViewById(R.id.radioButtonq5_1);
        q5_2= (RadioButton) findViewById(R.id.radioButtonq5_2);
        q5_3= (RadioButton) findViewById(R.id.radioButtonq5_3);
        q5_4= (RadioButton) findViewById(R.id.radioButtonq5_4);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"No puedes volver atrás",Toast.LENGTH_SHORT).show();
    }

    public void Corregir(View view) {
        if (q5_1.isChecked()) {
            Toast.makeText(this,"CORRECTO :) +3 puntos",Toast.LENGTH_SHORT).show();
            this.puntuacion=this.puntuacion+3;
            Intent seguir = new Intent(this, PuntuacionFinal.class);
            seguir.putExtra("PUNTUACION", this.puntuacion);
            startActivity(seguir);
        }else if(q5_2.isChecked() || q5_3.isChecked() || q5_4.isChecked()){
            Toast.makeText(this, "Incorrecto :( -2 puntos", Toast.LENGTH_SHORT).show();
            this.puntuacion = this.puntuacion - 2;
            Intent intermedio = new Intent(this, ErrorIntermedio.class);
            intermedio.putExtra("PUNTUACION", this.puntuacion);
            intermedio.putExtra("PREGUNTA", 5);
            startActivity(intermedio);
        }else{
            Toast.makeText(this, "Marque una respuesta antes", Toast.LENGTH_SHORT).show();
        }
    }
}