package com.example.feez.simple_option_menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {//main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("");
        toolbar.setBackgroundColor(Color.rgb(0, 0, 0));
        toolbar.setTitleTextColor(Color.WHITE);   //@string/app_name
        toolbar.setSubtitle("Menu");
        toolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar); //show
        //end toolbar




    }//main


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){  //ref to menu setting
            menuSetting(item);
            return true;
        }else if(id == R.id.action_help){ //ref to menu help
            menuHelp(item);
            return true;
        }else if(id == R.id.action_search){ //ref to menu search
            menuSearch(item);
            return true;
        }else if(id == R.id.submenu_google){  //SUB MENU
            subGoogle(item);
            return true;
        }else if(id == R.id.submenu_youtube) {  //SUB MENU
            subYoutube(item);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //fuction menuSetting
    private void menuSetting(MenuItem item){
        Toast.makeText(getBaseContext(),"menuSetting",Toast.LENGTH_SHORT).show();
    }


    //fuction menuHelp
    private void menuHelp(MenuItem item){
        Toast.makeText(getBaseContext(),"menuHelp",Toast.LENGTH_SHORT).show();
    }

    //fuction menuSearch
    private void menuSearch(MenuItem item){
        //Toast.makeText(getBaseContext(),"menuSearch",Toast.LENGTH_SHORT).show();
    }

    //fuction subGoogle
    private void subGoogle(MenuItem item){
        Toast.makeText(getBaseContext(),"Google",Toast.LENGTH_SHORT).show();
    }

    //fuction subYoutube
    private void subYoutube(MenuItem item){
        Toast.makeText(getBaseContext(),"Search",Toast.LENGTH_SHORT).show();
    }






}//END SCCOPE


