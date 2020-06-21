package com.example.test8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2_O_2 extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__o_2);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);

        s1=getIntent().getExtras().getString("Order");
        s2=getIntent().getExtras().getString("TN");
        s3=getIntent().getExtras().getString("SN");

        tv1.setText("Dear customer ");
        tv2.setText("We've received your order request. Your order is "+s1+ ".");
        tv3.setText("Your table number is "+ s2 + " ");
        tv4.setText("If your serial number is matched, the order will be confirmed.");
    }
}