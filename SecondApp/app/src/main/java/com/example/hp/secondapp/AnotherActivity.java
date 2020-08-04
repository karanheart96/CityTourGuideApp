package com.example.hp.secondapp;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import layout.ChicagoViewerActivity;
import layout.IndianaPolisViewerActivity;

public class AnotherActivity extends BroadcastReceiver {


    String city = "";


//        // Begin the transaction
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//    // Replace the contents of the container with the new fragment
//        ft.replace(R.id.frameId, new DropdownFragment());
//    // or ft.add(R.id.your_placeholder, new FooFragment());
//    // Complete the changes added above
//        ft.commit();


    public void onReceive(Context context, Intent intent) {
        //receiving and choosing appropriate activity
        Bundle extras = intent.getExtras();
        if (extras != null) {
            city = extras.getString("Name");

        }
        if (city.equalsIgnoreCase("Chicago")) {
            Intent chicago = new Intent(context, ChicagoViewerActivity.class);
            chicago.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //chicago.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(chicago);
        } else {
            Intent indiana = new Intent(context, IndianaPolisViewerActivity.class);
            indiana.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //chicago.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(indiana);
        }


    }
}
