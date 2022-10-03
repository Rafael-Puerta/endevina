package com.example.endevina;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {
    String data="";
    static ArrayList<Record> records = new ArrayList<Record>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();

        MainActivity.rankin.forEach((n) -> data+=(n.getUser()+":"+n.getScore()+"\n"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        final TextView ranking = findViewById(R.id.records);
        ranking.setText(data);
    }

}
