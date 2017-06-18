package com.example.feez.feedroid2;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //init element variable
    private CheckBox mCheckbox;
    private Button mBotton;
    private Switch mSwitch;
    private RadioButton mRadio;


    //snackbar
    private FloatingActionButton mFloatButton;
    @Override

    //main
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //wait input
        //checkbox
        mCheckbox = (CheckBox)findViewById(R.id.checkBox);
        //button
        mBotton = (Button)findViewById(R.id.button);
        //switch
        mSwitch = (Switch)findViewById(R.id.switch1);
        //Radio
        mRadio = (RadioButton)findViewById(R.id.radioButton);

        //snackbar
        mFloatButton =(FloatingActionButton)findViewById(R.id.fab);






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

        //call function 1
        setInitCheck();
        //mRadio.setChecked(false);

    }//protected void onCreate END : main


    //fuction 1 init button,checkbox,switch
    private void setInitCheck(){
        mCheckbox.setChecked(false);
        mSwitch.setChecked(false);
        mRadio.setChecked(false);
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
        final Snackbar snackbar = Snackbar.make(mFloatButton,"Hello test Snackbar",Snackbar.LENGTH_SHORT);

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
                setInitCheck();

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

