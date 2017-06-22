package com.example.feez.dialog_and_notification;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class main2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //receive data1
        Intent _inboundIndex = getIntent();
        String _string1 = _inboundIndex.getStringExtra("data1");
        Toast.makeText(getApplicationContext(),"Show : " + _string1,Toast.LENGTH_SHORT).show();
        //end receive data1

        //button2 back
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //link page to main
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });//end button2 back


        //button3 menu
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Dialog();
            }
        });//end button3
    }//main

    private void Dialog(){
        //array string
        final String[] items = {"a","b","c"};

        //array init
        final String[] checkItem = {items[0]};

        //AlertDialog function
        new AlertDialog.Builder(main2.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Select Menu page2")
                //use array string : setItems
                //.setItems(items,new DialogInterface.OnClickListener(){
                .setSingleChoiceItems(items,0,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        checkItem[0] = items[which];

                    }
                })//End setItems

                //Negative button
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(checkItem[0] == "a"){
                            Toast.makeText(getBaseContext(),items[1],Toast.LENGTH_SHORT).show();
                        }
                    }
                })//End Negative button

                .show();
    }

}//scope
