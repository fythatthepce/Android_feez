package com.example.feez.dialog_and_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {//scope

    //noti ID
    private final int ID = 555;
    private NotificationManager mNotifMan;
    //END noti ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {//main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Dialog();
                showNoti();
            }
        });//end button
    }//end main

    private void Dialog(){
        //array string
        final String[] items = {"menu1","menu2","menu3"};

        //AlertDialog function
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Select Menu")
                //use array string : setItems
                .setItems(items,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Toast.makeText(getBaseContext(),items[which],Toast.LENGTH_SHORT).show();
                        //Operation HERE
                        if(items[which] == items[0]){
                            //Toast.makeText(getBaseContext(),"Success !!!",Toast.LENGTH_SHORT).show();

                            //link page and send data
                            Intent i = new Intent(getApplicationContext(),main2.class);
                            //send data to main2
                            i.putExtra("data1",items[0].toString());
                            startActivity(i);
                        }else if(items[which] == "menu2"){
                            Toast.makeText(getBaseContext(),"Success2 !!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                })//End setItems

                //Negative button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })//End Negative button

        .show();
    }

    //Notification function
    private void showNoti(){
    //private void showNoti(View view){


        //link by intent

        /*intent url
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        */

        //link page and send data
        Intent i = new Intent(getApplicationContext(),main2.class);

        //create pendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getBaseContext(),123,i,PendingIntent.FLAG_CANCEL_CURRENT
        );



        Notification.InboxStyle s1 = new Notification.InboxStyle()
                .setBigContentTitle("ระบบแจ้งเตือน")
                .addLine("แจ้งเตือน ครั้งที่ 1")
                .addLine("แจ้งเตือน ครั้งที่ 2")
                .setSummaryText("ข้อมูลเพิ่มเติม : 191");




        Notification.Builder builder = new Notification.Builder(getBaseContext());
        builder
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setStyle(s1)
                //.setContentTitle("ทดสอบ")
                //.setContentText("ลองแตะ")
                .setAutoCancel(true)

                //enable pendingIntent
                .setContentIntent(pendingIntent).build();

        //sound
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            builder.setSound(uri);

        //vibrate
            long[] vibrate = {500};
            builder.setVibrate(vibrate);


        //map id
        Notification notification = builder.build();
        mNotifMan = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mNotifMan.notify(ID,notification);
    }


}//end scope
