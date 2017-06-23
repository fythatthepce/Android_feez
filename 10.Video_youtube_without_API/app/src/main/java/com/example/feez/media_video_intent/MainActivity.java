package com.example.feez.media_video_intent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URL;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    //https://www.youtube.com/watch?v=WM_0NrlF1lg
   //private VideoView mVideoView;

    //RECLYCLE VIEW FIELD
    RecyclerView recyclerView;

    //VECTOR FOR VIDEO FIELD
    Vector<YoutubeVideo> youtubeVideos = new Vector<YoutubeVideo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //playVideo();

        recyclerView = (RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //LOAD VIDEO LIST

        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WM_0NrlF1lg\" frameborder=\"0\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }//main


    /*
    private void playVideo(){
        mVideoView = (VideoView)findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.big_bunny;

        mVideoView.setVideoPath(path);
        MediaController mController = new MediaController(this);
        mVideoView.setMediaController(mController);
        mController.show();
        mVideoView.start();
    }//END playvideo*/



}//scope
