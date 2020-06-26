package com.example.test8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.core.utilities.Utilities;

public class MainActivity2_UM_2 extends AppCompatActivity {
    private EditText eti1,eti2,eti3,eti4;
    private Button btn_UM2;
    DatabaseReference refUM;
    TableVM tableVM;
    long maxid= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__u_m_2);
        eti1 = (EditText)findViewById(R.id.etItem1);
        eti2 = (EditText)findViewById(R.id.etItem2);
        eti3 = (EditText)findViewById(R.id.etItem3);
        eti4 = (EditText)findViewById(R.id.etItem4);
        btn_UM2 = (Button)findViewById(R.id.btn_UM2);
        refUM = FirebaseDatabase.getInstance().getReference().child("Update Menu List");
        refUM.addValueEventListener(new ValueEventListener() {
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
        tableVM = new TableVM();
        btn_UM2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                    if (TextUtils.isEmpty(eti1.getText().toString().trim()) ||
                            TextUtils.isEmpty(eti2.getText().toString().trim()) ||
                            TextUtils.isEmpty(eti3.getText().toString().trim()) ||
                            TextUtils.isEmpty(eti4.getText().toString().trim())){
                        Toast.makeText(MainActivity2_UM_2.this, "Please enter all the information!",Toast.LENGTH_LONG).show();
                    }
                    else {
                        refUM.setValue(null);
                        tableVM.setItem1(eti1.getText().toString().trim());
                        tableVM.setItem2(eti2.getText().toString().trim());
                        tableVM.setItem3(eti3.getText().toString().trim());
                        tableVM.setItem4(eti4.getText().toString().trim());

                        refUM.child(String.valueOf(maxid + 1)).setValue(tableVM);


                        Toast.makeText(MainActivity2_UM_2.this, "Updated Menu!", Toast.LENGTH_LONG).show();
                    }

            }
        });

    }
}