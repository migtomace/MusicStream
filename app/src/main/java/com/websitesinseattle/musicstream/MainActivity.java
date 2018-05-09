package com.websitesinseattle.musicstream;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onClick methods for buttons

    //method to start service
    public void play(View view){
        startService(new Intent(getBaseContext(), ServiceStream.class));

        if (player == null) {
            player = MediaPlayer.create(this, R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
               stopPlayer();
                }
            });
        }
        player.start();

    }

    public void pause(View view) {
        if (player != null){
            player.pause();
        }
    }

    //method to stop service
    public void stop(View view){

        stopPlayer();

    }

    public void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
            Toast.makeText(this,"MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
        stopService(new Intent(getBaseContext(), ServiceStream.class));
    }
}
