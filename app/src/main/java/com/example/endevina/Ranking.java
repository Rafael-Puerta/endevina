package com.example.endevina;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        TableLayout tbl=(TableLayout) findViewById(R.id.tablecita);
        MainActivity.rankin.forEach((n) -> {
            //Creating new tablerows and textviews
            TableRow row=new TableRow(this);
            TextView txt1=new TextView(this);
            TextView txt2=new TextView(this);
            //setting the text
            txt1.setText(n.getUser());
            txt2.setText(n.getScore());
            //the textviews have to be added to the row created
            row.addView(txt1);
            row.addView(txt2);
            tbl.addView(row);
        });

        //setContentView(R.layout.activity_ranking);

    }

}
