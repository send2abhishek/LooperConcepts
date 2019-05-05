package com.example.looperconcepts.Handlers;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.util.Log;

import com.example.looperconcepts.MainActivity;
import com.example.looperconcepts.Services.MyService;

public class DdldHandler extends Handler {

    private MyService service;
    private ResultReceiver resultReceiver;


    @Override
    public void handleMessage(Message msg) {


        SongDownload(msg.obj.toString());
        service.stopSelf(msg.arg1);
        Bundle bundle=new Bundle();
        bundle.putString("MYRESULT",msg.obj.toString());
        resultReceiver.send(MainActivity.RESULT_OK,bundle);

    }


    private void SongDownload(String music){

        try {
            Thread.sleep(4000);
            Log.i(MainActivity.TAG,"Song is getting download - "+music);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setService(MyService service) {
        this.service = service;
    }

    public void setResultReceiver(ResultReceiver resultReceiver) {
        this.resultReceiver = resultReceiver;
    }
}
