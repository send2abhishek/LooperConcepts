package com.example.looperconcepts.Services;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;


import com.example.looperconcepts.MainActivity;

public class MyResultReceiver extends ResultReceiver {

    private Handler handler;
    private Context context;

    public MyResultReceiver(Handler handler) {
        super(handler);
        this.handler=handler;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);

        if(resultCode== MainActivity.RESULT_OK && resultData!=null){


            Message msg=Message.obtain();
            msg.setData(resultData);

            handler.sendMessage(msg);

        }
    }
}
