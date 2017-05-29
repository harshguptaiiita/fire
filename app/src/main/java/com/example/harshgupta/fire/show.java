package com.example.harshgupta.fire;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Harsh Gupta on 5/30/2017.
 */

public class show extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        final TextView t1, t2;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference mReference;

        t1 = (TextView) findViewById(R.id.na);
        t2 = (TextView) findViewById(R.id.p);
        Firebase.setAndroidContext(this);

        mReference = mFirebaseDatabase.getReference().child("data");
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //Getting the data from snapshot
                    fire f = postSnapshot.getValue(fire.class);

                    //Adding it to a string
                    String string1 = "Name: " + f.getName() + "\n\n";

                    //Displaying it on textview
                    t1.setText(string1);
                    String string2 = "Phone: " + f.getPhone() + "\n\n";
                    t2.setText(string2);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed:");
            }
        }
        );
    }

    }

