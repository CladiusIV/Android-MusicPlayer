package com.example.cladius.musicplayer_01;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.btnPlay);
        pause = (Button) findViewById(R.id.btnPause);
        stop = (Button) findViewById(R.id.btnStop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnPlay:
                if (mediaPlayer==null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nameless_song);
                    mediaPlayer.start();
                } else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPosition);
                    mediaPlayer.start();
                }
                break;
            case R.id.btnPause:
                if (mediaPlayer!=null){
                    mediaPlayer.pause();
                    pauseCurrentPosition=mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.btnStop:
                if (mediaPlayer!=null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;
        }
    }
}
