package com.example.looperconcepts.Handlers;

import android.os.Looper;
import android.util.Log;

import com.example.looperconcepts.MainActivity;
import com.example.looperconcepts.Services.MyService;

public class MyThread extends Thread  {

    public DdldHandler handler;


    @Override
    public void run() {
        Looper.prepare();
        handler=new DdldHandler();
        Looper.loop();
        Log.i(MainActivity.TAG,"All downloaded - ");
    }



}
