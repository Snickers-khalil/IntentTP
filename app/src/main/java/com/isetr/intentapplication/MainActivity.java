package com.isetr.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        e1=findViewById(R.id.edit1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = e1.getText().toString();
                if (e1.equals(""))
                    Toast.makeText(MainActivity.this, "champs Vide", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(MainActivity.this, act_2.class);
                    i.putExtra("log",log);
                    startActivity(i);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
                Date udate;
                try {
                    udate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-12-31");
                } catch (ParseException e) {
                    udate = new Date();
                }
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, udate.getTime());
                //intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, DateTime);
                intent.putExtra(CalendarContract.Events.ALL_DAY, false);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Descripttion");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
                startActivity(Intent.createChooser(intent, "Add to calendar"));
            }
        });

    }
}