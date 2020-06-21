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
    private TextView itemname1,price1,itemname2,price2;
    private Button btnRM;
    DatabaseReference reff;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__v_m);
        TextView itemname1=(TextView)findViewById(R.id.itemname1);
        TextView itemname2=(TextView)findViewById(R.id.itemname2);
        TextView price1=(TextView)findViewById(R.id.price1);
        TextView price2=(TextView)findViewById(R.id.price2);
        btnRM=(Button)findViewById(R.id.btnRM);
        btnRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff= FirebaseDatabase.getInstance().getReference().child("Table").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String itemname1=dataSnapshot.child("itemname1").getValue().toString();
                        String price1 = dataSnapshot.child("price1").getValue().toString();
                        String itemname2=dataSnapshot.child("itemname2").getValue().toString();
                        String price2= dataSnapshot.child("price2").getValue().toString();



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}