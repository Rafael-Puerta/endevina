package com.example.endevina;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static int numero;
    static final ArrayList<Record> rankin = new ArrayList<Record>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText texto = findViewById(R.id.entrada);
        final Button button = findViewById(R.id.button);
        final Button buttonRank = findViewById(R.id.toRanking);
        final TextView historial = findViewById(R.id.histo);
        final TextView intentos = findViewById(R.id.intent);
        final Toast toaster = Toast.makeText(this, "Si quieres guardar, escribe un nombre!", Toast.LENGTH_LONG);
        MainActivity.numero=(int) (Math.random()*100);

        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Ranking.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //falta condicional para valor nulo o mejor englobar try catch
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
                    String resultado=intentos.getText().toString();
                    historial.append("EL NUMERO ES CORRECTOOOOOOOOOOOO!\n");

                    final EditText input = new EditText(MainActivity.this);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setTitle("GANADOR");
                    builder.setMessage("HAS ACERTADO EL NUMERO \n Quieres guardar tus datos?\n Introduce usuario");

                    builder.setView(input);
                    builder.setPositiveButton("SI",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //cambiar a crear objeto record setear atributos y meter en array
                            if(input!=null && input.length()>0){
                                String nombrecito = input.getText().toString();
                                Record fin= new Record(nombrecito,Integer.valueOf(resultado));
                                rankin.add(fin);
                            }
                            else {
                                toaster.show();
                            }
                        }
                    })
                    ;
                    builder.setNegativeButton("NO",null);
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