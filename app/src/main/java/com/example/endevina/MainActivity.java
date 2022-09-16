package com.example.endevina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText texto = findViewById(R.id.entrada);
        final Button button = findViewById(R.id.button);
        int numero=(int) (Math.random()*100);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button


                if(Integer.parseInt(texto.getText().toString())>numero){
                    Toast.makeText(MainActivity.this, "EL NUMERO ES MAS PEQUEÑO!", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(texto.getText().toString())<numero){
                    Toast.makeText(MainActivity.this, "EL NUMERO ES MAS GRANDE!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "HAS ACERTADO", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}