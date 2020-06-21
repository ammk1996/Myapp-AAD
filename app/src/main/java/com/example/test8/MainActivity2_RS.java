package com.example.test8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        reff = FirebaseDatabase.getInstance().getReference().child("Table");
        table = new Table();
        btn_RS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int CA1 = Integer.parseInt(etCN.getText().toString());
            Long ph1 = Long.parseLong(etPh.getText().toString());
            table.setName(etCName.getText().toString().trim());
            table.setCA(CA1);
            table.setPh(ph1);
            table.setDOR(etDOR.getText().toString().trim());
            reff.push().setValue(table);
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
            }


        });
    }


}