package com.example.feez.media2;

import android.media.MediaPlayer;
//import android.media.session.MediaController;
import android.widget.MediaController;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;


public class MainActivity extends AppCompatActivity {
    MediaController mController;
    MediaPlayer mPlayer;
    int mBufferPercent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mController = new MediaController(this);
        mController.setAnchorView(findViewById(R.id.relative_layout));
    }//main


    @Override
    public void onResume(){
        super.onResume();
        mPlayer = MediaPlayer.create(this,R.raw.sapan);

        //link between mplayer and mcontroller
        mController.setMediaPlayer(mpControl);
        mController.setEnabled(true);
    }


    public void OnPause(){
        super.onPause();
        mPlayer.release();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        mController.show();
        return super.onTouchEvent(event);
    }


    private MediaController.MediaPlayerControl mpControl = new MediaController.MediaPlayerControl() {
        @Override
        public void start() {
            mPlayer.start();
        }

        @Override
        public void pause() {
            mPlayer.pause();
        }

        @Override
        public int getDuration() {
            return mPlayer.getDuration();
        }

        @Override
        public int getCurrentPosition() {
            return mPlayer.getCurrentPosition();
        }

        @Override
        public void seekTo(int pos) {
            mPlayer.seekTo(pos);
        }

        @Override
        public boolean isPlaying() {
            return mPlayer.isPlaying();
        }

        @Override
        public int getBufferPercentage() {
            return mBufferPercent;
        }

        @Override
        public boolean canPause() {
            return true;
        }

        @Override
        public boolean canSeekBackward() {
            return true;
        }

        @Override
        public boolean canSeekForward() {
            return true;
        }

        @Override
        public int getAudioSessionId() {
            return mPlayer.getAudioSessionId();
        }
    };
}//scope
