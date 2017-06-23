package com.example.feez.media;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    private Button mButtonPlay, mButtonPause, mButtonStop;
    private int mCurrentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonPlay = (Button) findViewById(R.id.button_play);
        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_music();
                mButtonPlay.setEnabled(false);
            }
        });//play button


        mButtonStop= (Button) findViewById(R.id.button_stop);
        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                init();
            }
        });//stop button

        mButtonPause = (Button)findViewById(R.id.button_pause);
        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_music(v);
            }
        });




    }//main




    private void init(){
        mButtonPlay.setEnabled(true);
        mButtonStop.setEnabled(false);
        mButtonPause.setEnabled(false);

        mCurrentPosition = 0;
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }//end init


    private void play_music() {
        //define mPlayer to MediaPlayer
        mPlayer = MediaPlayer.create(getBaseContext(), R.raw.sapan);

        //go to current position
        mPlayer.seekTo(mCurrentPosition);

        //seek complete to action
        mPlayer.setOnSeekCompleteListener(
                new MediaPlayer.OnSeekCompleteListener() {

                    @Override
                    public void onSeekComplete(MediaPlayer mp) {
                        mPlayer.start();
                        mButtonStop.setEnabled(true);
                        mButtonPause.setEnabled(true);
                    }
                });
    }//END play_music();


    private void pause_music(View v){
        Button bt = (Button)v;
        if(mPlayer.isPlaying()){
            mPlayer.pause();
            mCurrentPosition = mPlayer.getCurrentPosition();
            bt.setText(">");
        }else {
            mPlayer.seekTo(mCurrentPosition + 600);
            bt.setText("||");
        }
    }//END stop_music();







}//scope
