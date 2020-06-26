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

public class MainActivity2_RS extends AppCompatActivity {
    private EditText etCN,etCName,etPh,etDOR;
    private Button btn_RS;
    DatabaseReference reff;
    Table table;
    long maxid=0;
    String st1;
    String st2;
    String st3;
    String st4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__r_s);
        etCN = (EditText)findViewById(R.id.etCN);
        etCName = (EditText)findViewById(R.id.etCName);
        etPh= (EditText)findViewById(R.id.etPh);
        etDOR= (EditText)findViewById(R.id.et_DOR);
        btn_RS = (Button)findViewById(R.id.btn_RS);
        reff = FirebaseDatabase.getInstance().getReference().child("Table Reservation List");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid = (snapshot.getChildrenCount());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        table = new Table();

        btn_RS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etCName.getText().toString().trim()) ||
                        TextUtils.isEmpty(etCN.getText().toString().trim()) ||
                        TextUtils.isEmpty(etDOR.getText().toString().trim()) ||
                        TextUtils.isEmpty(etPh.getText().toString().trim())){
                    Toast.makeText(MainActivity2_RS.this, "Please enter all the information!",Toast.LENGTH_LONG).show();
                }
                else{
                    int CA1 = Integer.parseInt(etCN.getText().toString());
                    int ph1 = Integer.parseInt(etPh.getText().toString());
                    table.setCustomer_Name(etCName.getText().toString().trim());
                    table.setCustomer_Amount(CA1);
                    table.setPhone(ph1);
                    table.setDate_and_Time(etDOR.getText().toString().trim());

                    reff.child(String.valueOf(maxid+1)).setValue(table);
                    Toast.makeText(MainActivity2_RS.this,"Sent table reservation!",Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity2_RS.this,MainActivity2_RS_2.class);
                    st1=etCName.getText().toString();
                    st2=etCN.getText().toString();
                    st3=etPh.getText().toString();
                    st4=etDOR.getText().toString();
                    intent.putExtra("Name",st1);
                    intent.putExtra("CNumber",st2);
                    intent.putExtra("Phone",st3);
                    intent.putExtra("DOR",st4);
                    startActivity(intent);
                    finish();
                    }}


        });
    }


}