package com.example.feez.media_video_intent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playVideo();
    }//main


    private void playVideo(){
        String url = "http://www.developerthai.com/android/big_bunny.3gp";
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri,"video/3gpp");

        PackageManager packMan = getPackageManager();
        if(intent.resolveActivity(packMan) != null){
            startActivity(intent);
        }else{
            Toast.makeText(getBaseContext(),"No video to play",Toast.LENGTH_LONG).show();
        }

    }
}//scope
