package com.android.practica1_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Question3 extends AppCompatActivity {

    int puntuacion;
    RadioButton q3_1,q3_2,q3_3,q3_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        this.puntuacion=0;
        this.puntuacion=(int)getIntent().getExtras().getInt("PUNTUACION");
        q3_1= (RadioButton) findViewById(R.id.radioButtonq3_1);
        q3_2= (RadioButton) findViewById(R.id.radioButtonq3_2);
        q3_3= (RadioButton) findViewById(R.id.radioButtonq3_3);
        q3_4= (RadioButton) findViewById(R.id.radioButtonq3_4);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"No puedes volver atrás",Toast.LENGTH_SHORT).show();
    }

    public void Corregir(View view) {
        if (q3_1.isChecked()) {
            Toast.makeText(this,"CORRECTO :) +3 puntos",Toast.LENGTH_SHORT).show();
            this.puntuacion=this.puntuacion+3;
            Intent seguir = new Intent(this, Question4.class);
            seguir.putExtra("PUNTUACION", this.puntuacion);
            startActivity(seguir);
        }else if(q3_2.isChecked() || q3_3.isChecked() || q3_4.isChecked()){
            Toast.makeText(this, "Incorrecto :( -2 puntos", Toast.LENGTH_SHORT).show();
            this.puntuacion = this.puntuacion - 2;
            Intent intermedio = new Intent(this, ErrorIntermedio.class);
            intermedio.putExtra("PUNTUACION", this.puntuacion);
            intermedio.putExtra("PREGUNTA", 3);
            startActivity(intermedio);
        }else{
            Toast.makeText(this, "Marque una respuesta antes", Toast.LENGTH_SHORT).show();
        }
    }
}