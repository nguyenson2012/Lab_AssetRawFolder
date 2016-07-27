package com.example.asus.lab_assetrawfolder;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Asus on 7/27/2016.
 */
public class MediaPlayerActivity extends Activity implements View.OnClickListener{
    MediaPlayer mediaPlayer;
    Button buttonPlay,buttonStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_media_layout);
        setupView();
        mediaPlayer=MediaPlayer.create(this,R.raw.crazier);
    }

    private void setupView() {
        buttonPlay=(Button)findViewById(R.id.buttonPlay);
        buttonStop=(Button)findViewById(R.id.buttonStop);
        buttonPlay.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id= view.getId();
        switch (id){
            case R.id.buttonPlay:
                mediaPlayer.start();
                break;
            case R.id.buttonStop:
                mediaPlayer.stop();
                break;
        }
    }
}
