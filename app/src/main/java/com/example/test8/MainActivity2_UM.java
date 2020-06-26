package com.example.test8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2_UM extends AppCompatActivity {
    private EditText etPW;
    private Button btn_AA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__u_m);
        etPW = (EditText)findViewById(R.id.etPW);
        btn_AA = (Button) findViewById(R.id.btn_AA);

        btn_AA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticate(etPW.getText().toString());

            }
        });
    }
    private void authenticate(String adminPassword){
        if (adminPassword.equals("Lucky7")){
            Intent intent = new Intent(MainActivity2_UM.this,MainActivity2_UM_2.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity2_UM.this,"Incorrect Password!",Toast.LENGTH_LONG).show();
        }
    }

}