package com.example.harshgupta.fire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //@Override
    Button in,de,up,sh;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in=(Button)findViewById(R.id.insert);
        de=(Button)findViewById(R.id.delete);
        up=(Button)findViewById(R.id.update);
        sh=(Button)findViewById(R.id.show);
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this,insert.class);
                startActivity(a);
            }
        });
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b= new Intent(MainActivity.this,delete.class);
                startActivity(b);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c=new Intent(MainActivity.this,update.class);
                startActivity(c);
            }
        });
        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(MainActivity.this,show.class);
                startActivity(k);
            }
        });
    }
}
