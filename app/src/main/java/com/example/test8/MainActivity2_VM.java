package com.example.test8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity2_VM extends AppCompatActivity {
    private TextView tv1,tv2,tv3,tv4;
    private Button btnRM;
    DatabaseReference refvm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__v_m);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        btnRM=(Button)findViewById(R.id.btnRM);
        btnRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                refvm= FirebaseDatabase.getInstance().getReference().child("Update Menu List").child("2");
                refvm.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String itemname1=dataSnapshot.child("item1").getValue().toString();
                        String itemname2 = dataSnapshot.child("item2").getValue().toString();
                        String itemname3=dataSnapshot.child("item3").getValue().toString();
                        String itemname4= dataSnapshot.child("item4").getValue().toString();
                        tv1.setText(itemname1);
                        tv2.setText(itemname2);
                        tv3.setText(itemname3);
                        tv4.setText(itemname4);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}