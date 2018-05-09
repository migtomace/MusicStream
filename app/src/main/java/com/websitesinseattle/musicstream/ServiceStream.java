package com.websitesinseattle.musicstream;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class ServiceStream extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //let it continue until stopped
        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
        return START_STICKY; //leave the service in the started state
    }

    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();
    }
}
