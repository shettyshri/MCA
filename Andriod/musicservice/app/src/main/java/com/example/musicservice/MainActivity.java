package com.example.musicservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start,stop;
  //  MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.btnplay);
        stop = findViewById(R.id.btnstop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
}
     @Override
    public void onClick(View v) {
        if(v == start){
            startService(new Intent(this,MyMusicService.class));
        }
        else
        {
            stopService(new Intent(this,MyMusicService.class));
        }
      //  player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
      //  player.setLooping((true));
       // player.start();
    }
}