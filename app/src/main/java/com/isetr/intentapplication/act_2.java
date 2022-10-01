package com.isetr.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class act_2 extends AppCompatActivity {
    TextView v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
         v1=findViewById(R.id.view1);
        Bundle extra=getIntent().getExtras();
         String log =extra.getString("log");
         v1.setText(log);
    }
}