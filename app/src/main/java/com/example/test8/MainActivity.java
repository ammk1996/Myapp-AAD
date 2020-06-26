package com.example.test8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.btn_RS);
        button2 = (Button)findViewById(R.id.btn_VM);
        button3 = (Button)findViewById(R.id.btn_O);
        button4 = (Button)findViewById(R.id.btn_UM);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRS();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVM();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openO();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUM();
            }
        });
    }
    public void openRS(){
        Intent intent1 = new Intent(this,MainActivity2_RS.class);
        startActivity(intent1);
    }
    public void openVM(){
        Intent intent2 = new Intent(this,MainActivity2_VM.class);
        startActivity(intent2);
    }
    public void openO(){
        Intent intent3 = new Intent(this,MainActivity2_O.class);
        startActivity(intent3);
    }
    public void openUM(){
        Intent intent4 = new Intent(this,MainActivity2_UM.class);
        startActivity(intent4);
    }
}