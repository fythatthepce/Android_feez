package com.example.feez.media_video_intent;

/**
 * Created by feez on 6/23/2017 AD.
 */

public class YoutubeVideo {
    String videoUrl;

    public  YoutubeVideo(){

    }

    public  YoutubeVideo(String videoUrl){
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
