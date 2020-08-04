package com.example.hp.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnStartAnotherActivity;
    Button second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartAnotherActivity = (Button) findViewById(R.id.btnStartAnotherActivity);

        btnStartAnotherActivity.setOnClickListener(this);
        second=(Button)findViewById(R.id.button);
        second.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        //calling an activity using <intent-filter> action name
        Intent inent = new Intent("com.example.hp.secondapp.ANOTHER_ACTIVITY");
        inent.putExtra("Name","Chicago");
        sendOrderedBroadcast(inent, null);
        //startActivity(inent);

//        Intent intent=new Intent("com.example.hp.secondapp.ANOTHER_ACTIVITY");
//        //intent.se
//        startActivity(intent);
    }

    public void startIndiana(View view)
    {

        Intent intent=new Intent("com.example.hp.secondapp.ANOTHER_ACTIVITY");
        intent.putExtra("Name","Indiana");
        //intent.se
        //startActivity(intent);
        sendOrderedBroadcast(intent,null);
    }

}