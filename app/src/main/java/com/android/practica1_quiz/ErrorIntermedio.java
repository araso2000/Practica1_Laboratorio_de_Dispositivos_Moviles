package com.android.practica1_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ErrorIntermedio extends AppCompatActivity {

    int puntuacion;
    int pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_intermedio);
        this.puntuacion=0;
        this.pregunta=0;
        this.puntuacion=(int)getIntent().getExtras().getInt("PUNTUACION");
        this.pregunta=(int)getIntent().getExtras().getInt("PREGUNTA");
        TextView txt = findViewById(R.id.textViewError2);
        txt.setText("Puntuación acumulada: " + this.puntuacion);
    }

    public void Seguir(View view){
        Intent intent;

        if(this.pregunta==1){
            intent=new Intent(this,Question2.class);
        }else if(this.pregunta==2){
            intent=new Intent(this,Question3.class);
        }else if(this.pregunta==3){
            intent=new Intent(this,Question4.class);
        }else if(this.pregunta==4){
            intent=new Intent(this,Question5.class);
        }else{
            intent=new Intent(this,PuntuacionFinal.class);
        }

        intent.putExtra("PUNTUACION",this.puntuacion);
        startActivity(intent);
    }

    public void Reintentar(View view){
        Intent intent = new Intent(this,Bienvenida.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        Toast.makeText(this,"No puedes volver atrás",Toast.LENGTH_SHORT).show();
    }
}