package com.example.wennlab.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;


public class videoview extends AppCompatActivity implements MediaController.MediaPlayerControl{
    private VideoView vidView;
    private MediaController vidControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);
        vidControl = new MediaController(this);
        vidView = (VideoView) findViewById(R.id.videoView);
        vidView.setMediaController(vidControl);

        //if (Environment.getExternalStorageState().equals(
              //  Environment.MEDIA_MOUNTED)){
           // File file = Environment.getExternalStorageDirectory();
           // File videoFile = new File(file,"videoplayback.mp4");
           // Uri uri = Uri.fromFile(videoFile);
          //  vidView.setVideoURI(uri);
        //}

        vidView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback));
    }

    @Override
    public void start() {
        vidView.start();
    }

    @Override
    public void pause() {
        if(vidView.isPlaying()){
            vidView.pause();
        }
    }

    @Override
    public int getDuration() {
        return vidView.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return vidView.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        vidView.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return vidView.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return vidView.canPause();
    }

    @Override
    public boolean canSeekBackward() {
        return vidView.canSeekBackward();
    }

    @Override
    public boolean canSeekForward() {
        return vidView.canSeekForward();
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
