package com.example.feez.feedroid2;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //init element variable
    private CheckBox mCheckbox;
    private CheckBox mCheckbox2;

    private Button mBotton;
    private Switch mSwitch;

    private RadioButton mRadio;
    private RadioButton mRadio2;

    public String msg;
    public String msg2;


    public int counter;


    //snackbar
    private FloatingActionButton mFloatButton;
    @Override



    //main
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //wait input assign
        //checkbox
        mCheckbox = (CheckBox)findViewById(R.id.checkBox);
        mCheckbox2 = (CheckBox)findViewById(R.id.checkBox2);
        //button
        mBotton = (Button)findViewById(R.id.button);
        //switch
        mSwitch = (Switch)findViewById(R.id.switch1);
        //Radio
        mRadio = (RadioButton)findViewById(R.id.radioButton1);
        mRadio2 = (RadioButton)findViewById(R.id.radioButton2);

        //snackbar
        mFloatButton =(FloatingActionButton)findViewById(R.id.fab);


        //call function 1
        setInitCheck();
        //mRadio.setChecked(false);

        //switch wait for action
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //String msg = "คุณ ";
                if(mSwitch.isChecked()){
                    setInitEnable();

                    //clear string
                    reset();


                    //radio1 action
                   mRadio.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           if (mRadio.isChecked()) {
                               msg = "คุณผู้ชาย : ";
                           }
                       }
                   });

                    //radio2 action
                    mRadio2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(mRadio2.isChecked()){
                                msg = "คุณผู้หญิง : ";
                            }

                        }
                    });

                    //checkbox1 action
                    mCheckbox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(mCheckbox.isChecked()) {
                                msg2 += "สั่งสเต็ก ";
                            }else{

                                //clear string
                                reset();
                                mCheckbox.setChecked(false);
                                mCheckbox2.setChecked(false);
                            }
                        }
                    });

                    mCheckbox2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(mCheckbox2.isChecked()) {
                                msg2  += "สั่งไก่ทอด ";
                            }else{

                                //clear string
                                reset();
                                mCheckbox.setChecked(false);
                                mCheckbox2.setChecked(false);
                            }
                        }
                    });





                    //button action
                    mBotton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            // Code here executes on main thread after user presses button

                            //call function 2
                            //Toast.makeText(getBaseContext(),"Hello World",Toast.LENGTH_LONG).show();
                            //clickBt(v);

                            //call function 3
                            clickBt2(v);
                        }
                    });//end button action

                }else{
                    setInitCheck();
                }

            }
        });
    }//END : main

    //clear string function
    public void reset()
    {
        msg2 = "";
        counter = 20;
    }


    //fuction 1 init button,checkbox,switch
    private void setInitCheck(){
        //mCheckbox.setChecked(false);
        //mCheckbox2.setChecked(true);

        //init Disable
        mCheckbox.setEnabled(false);
        mCheckbox2.setEnabled(false);
        mRadio.setEnabled(false);
        mRadio2.setEnabled(false);
        mBotton.setEnabled(false);

        mSwitch.setChecked(false);
        //mRadio.setChecked(false);
    }

    private void setInitEnable(){
        //mCheckbox.setChecked(false);
        //mCheckbox2.setChecked(true);

        //init Disable
        mCheckbox.setEnabled(true);
        mCheckbox2.setEnabled(true);
        mRadio.setEnabled(true);
        mRadio2.setEnabled(true);
        mBotton.setEnabled(true);

        //mSwitch.setChecked(false);
        //mRadio.setChecked(false);
    }


    //function 2
    private  void clickBt(View v){
        Toast.makeText(getBaseContext(),"Hello World Test func Toast",Toast.LENGTH_SHORT).show();
    }

    //function 3 snackbar show text
    private  void clickBt2(View v){
         //final Snackbar snackbar = Snackbar.make(mFloatButton,"Hello test Snackbar",Snackbar.LENGTH_SHORT);
         //snackbar.show();

        //wait button setAction interrupt
        final Snackbar snackbar = Snackbar.make(mFloatButton,msg+msg2,Snackbar.LENGTH_SHORT);
        //Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();

        //view : container of snackbar
        View view = snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);

        //Change to TextView mode : can edit text
        TextView snackbarText = (TextView)view;
        snackbarText.setTextColor(Color.rgb(222, 237, 220));
        snackbarText.setTextSize(20);
        //snackbar.show();
        //end edit text

        //init button action in snackbar
        snackbar.setAction("close",new View.OnClickListener(){
            @Override
            //snackbar button action
            public void onClick(View v){
                //return to init
                //setInitCheck();

                //ซ่อน snackbar
                snackbar.dismiss();
            }
        });
        //setting button action in snackbar:color,size

        View view_action  = snackbar.getView().findViewById(android.support.design.R.id.snackbar_action);
        TextView snackbarText_action = (TextView)view_action;
        snackbarText_action.setTextColor(Color.RED);
        snackbarText_action.setTextSize(20);
        snackbar.show();

    }//END function 3


}// END MainActivity

