package com.example.looperconcepts.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.util.Log;
import com.example.looperconcepts.Handlers.MyThread;
import com.example.looperconcepts.MainActivity;

public class MyService extends Service {

    public MyService() {

    }

    private MyThread thread;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(MainActivity.TAG,"onCreate Called");
        thread=new MyThread();
        thread.start();
        while (thread.handler==null){

        }

        thread.handler.setService(this);



    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {



        String song=intent.getStringExtra("MySONG");
        thread.handler.setResultReceiver((ResultReceiver) intent.getParcelableExtra(Intent.EXTRA_RESULT_RECEIVER));

        Log.i(MainActivity.TAG,"OnStartCommand Called for the Intent- "+ song+ " And have the startId as- "+ startId);

        Message message=Message.obtain();
        message.obj=song;
        message.arg1=startId;
        thread.handler.sendMessage(message);
        return START_REDELIVER_INTENT;
    }


    @Override
    public void onDestroy() {
        Log.i(MainActivity.TAG,"onDestroy Called");
        super.onDestroy();
    }
}


