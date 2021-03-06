package com.example.test8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2_O extends AppCompatActivity {
    private EditText etO1,etO2,etO3;
    private Button btn_O;
    DatabaseReference reffO;
    TableO tableO;
    long maxid=0;
    String s1;
    String s2;
    String s3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__o);
        etO1 = (EditText)findViewById(R.id.et_O1);
        etO2 = (EditText)findViewById(R.id.et_O2);
        etO3= (EditText)findViewById(R.id.et_O3);
        btn_O= (Button) findViewById(R.id.btn_O);
        reffO = FirebaseDatabase.getInstance().getReference().child("Order List");
        reffO.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid = (snapshot.getChildrenCount());
                }
                else{

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        tableO = new TableO();

        btn_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etO1.getText().toString().trim()) ||
                        TextUtils.isEmpty(etO2.getText().toString().trim()) ||
                        TextUtils.isEmpty(etO3.getText().toString().trim())){
                    Toast.makeText(MainActivity2_O.this, "Please enter all the information!",Toast.LENGTH_LONG).show();
                }
                else{
                    int tableNum = Integer.parseInt(etO2.getText().toString());
                    int serialNum = Integer.parseInt(etO3.getText().toString());
                    tableO.setOrder(etO1.getText().toString().trim());
                    tableO.setTableNumber(tableNum);
                    tableO.setSerialNumber(serialNum);
                    reffO.child(String.valueOf(maxid+1)).setValue(tableO);



                    Toast.makeText(MainActivity2_O.this,"Sent Order!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity2_O.this,MainActivity2_O_2.class);
                    s1=etO1.getText().toString();
                    s2=etO2.getText().toString();
                    s3=etO3.getText().toString();

                    intent.putExtra("Order",s1);
                    intent.putExtra("TN",s2);
                    intent.putExtra("SN",s3);

                    startActivity(intent);
                    finish();
                }

            }
        });

    }
}