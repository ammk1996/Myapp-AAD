package com.example.test8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2_RS_2 extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    String st1,st2,st3,st4;
    Button btn_RM1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__r_s_2);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        btn_RM1 = (Button)findViewById(R.id.btn_RM1);

        st1=getIntent().getExtras().getString("Name");
        st2=getIntent().getExtras().getString("CNumber");
        st3=getIntent().getExtras().getString("Phone");
        st4=getIntent().getExtras().getString("DOR");

        tv2.setText("Hello " + st1 + ", you've sent table reservation for "+st2+" customer(s) on the date of " + st4 + ".");
        tv3.setText("Your phone number is "+ st3 + " ");
        tv4.setText("Once confirmed, you will receive confirmation call from us.");
        btn_RM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
    private void openMP(){
        Intent intent = new Intent(this,MainActivity.class);
    }
}