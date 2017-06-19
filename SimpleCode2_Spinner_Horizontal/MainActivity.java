package com.example.feez.feedroid3;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity { //Scope

    private CheckBox ck1;
    private CheckBox ck2;

    private ProgressBar pg1;

    //progress dialog spinner
    private ProgressDialog pgd1;

    //progress dialog horizontal
    private ProgressDialog pgd2;




    @Override
    protected void onCreate(Bundle savedInstanceState) { //main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle("FEEz App");
        toolbar.setSubtitle("Test");
        toolbar.setTitleTextColor(Color.RED);
        toolbar.setBackgroundColor(Color.YELLOW);



        //init
        ck1 = (CheckBox)findViewById(R.id.checkBox);
        ck2 = (CheckBox)findViewById(R.id.checkBox2);

        pg1 = (ProgressBar)findViewById(R.id.progressBar);


        //Progress Dialog spinner
        pgd1 = new ProgressDialog(this);

        //Progress Dialog horizon
        pgd2 = new ProgressDialog(this);





        setInitCheck();
        ck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ck1.isChecked()) {
                    //progress bar
                    pg1.setProgress(50);


                    //Progress Dialog spinner
                    pgd1.setMessage("Loading...");
                    pgd1.setTitle("Test ProgressDialog Spinner");
                    pgd1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    pgd1.show();
                    pgd1.setCancelable(false);  //set not cancle

                    //timer
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            pgd1.dismiss();   //close progress dialog spiner
                        }
                    }).start();//END timer
                }
                else{
                    pg1.setProgress(0);
                }
            }
        });//end checkbox1

        ck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ck2.isChecked()){
                    pg1.setProgress(100);
                    //Progress Dialog Horizontal
                    //handle to update time
                    final Handler handle = new Handler() {
                        public void handleMessage(Message msg) {
                            super.handleMessage(msg);
                            pgd2.incrementProgressBy(3); // Incremented By Value 2
                        }
                    };

                    pgd2.setMessage("Loading...");
                    pgd2.setTitle("Test ProgressDialog Spinner");
                    pgd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    pgd2.show();
                    pgd1.setCancelable(false);  //set not cancle

                    //timer
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (pgd2.getProgress() <= pgd2.getMax()) { //loop check progress
                                    Thread.sleep(50);
                                    handle.sendMessage(handle.obtainMessage());
                                    if (pgd2.getProgress() == pgd2.getMax()) {
                                        pgd2.dismiss(); //close progress dialog horizontal
                                    }
                                } //end loop
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();  //end timer

                }else{
                    pg1.setProgress(0);
                }//end if - else of checkbox2
            }
        });//end checkbox2




    }//End main

    private void setInitCheck() {
        ck1.setChecked(false);
        ck2.setChecked(false);
        pg1.setProgress(0);
        //pg2.setProgress(0);
    }

}//Scope


