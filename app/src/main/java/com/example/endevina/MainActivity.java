package com.example.endevina;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText texto = findViewById(R.id.entrada);
        final Button button = findViewById(R.id.button);
        final TextView historial = findViewById(R.id.histo);
        final TextView intentos = findViewById(R.id.intent);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        MainActivity.numero=(int) (Math.random()*100);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(Integer.parseInt(texto.getText().toString())>numero){
                    historial.append("Introduciste: " + texto.getText().toString() + " EL NUMERO ES MAS PEQUEÑO!\n");
                    intentos.setText(String.valueOf(Integer.parseInt(intentos.getText().toString())+1));
                    texto.setText("");
                }
                else if(Integer.parseInt(texto.getText().toString())<numero){
                    historial.append("Introduciste: " + texto.getText().toString() + " EL NUMERO ES MAS GRANDE!\n");
                    intentos.setText(String.valueOf(Integer.parseInt(intentos.getText().toString())+1));
                    texto.setText("");
                }
                else{
                    historial.append("EL NUMERO ES CORRECTOOOOOOOOOOOO!\n");
                    builder.setTitle("GANADOR");
                    builder.setMessage("HAS ACERTADO EL NUMERO");
                    builder.setPositiveButton("OK",null);
                    builder.create();
                    builder.show();
                    texto.setText("");
                    intentos.setText("0");
                    historial.setText("Historial: ");
                    MainActivity.numero=(int) (Math.random()*100);
                }


            }

        });
    }
}