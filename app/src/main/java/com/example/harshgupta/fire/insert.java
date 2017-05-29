package com.example.harshgupta.fire;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Harsh Gupta on 5/29/2017.
 */

public class insert extends AppCompatActivity {
//    @Override
private FirebaseDatabase mFirebaseDatabase;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        final EditText nam,ph;
        Button inse;
         final DatabaseReference mReference;

        Firebase.setAndroidContext(this);

        mReference=mFirebaseDatabase.getReference().child("data");
        //final Firebase ref = new Firebase(url.FIREBASE_URL);
        nam=(EditText)findViewById(R.id.name);
        ph=(EditText)findViewById(R.id.phone);
        inse=(Button)findViewById(R.id.enter);

        inse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object


                //Getting values to store
                String name = nam.getText().toString().trim();
                String phone = ph.getText().toString().trim();
                fire p=new fire();
                p.setName(name);
                p.setPhone(phone);
                mReference.push().setValue(p);
            }
        });

    }}