package com.example.looperconcepts;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.looperconcepts.Services.MyResultReceiver;
import com.example.looperconcepts.Services.MyService;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MyTag";
    private String[] playList=new String[]{"Song1","Song2","Song3","Song4","Song5"};
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {

                Bundle bundle=msg.getData();

                Toast.makeText(MainActivity.this,""+bundle.getString("MYRESULT"),Toast.LENGTH_LONG).show();
            }
        };
    }

    public void StartServiceThread(View view) {


        MyResultReceiver resultReceiver=new MyResultReceiver(handler);

        for (String data:playList) {

            Intent intent=new Intent(this, MyService.class);
            intent.putExtra("MySONG",data);
            intent.putExtra(Intent.EXTRA_RESULT_RECEIVER,resultReceiver);
            startService(intent);
        }
    }

    public void StopServiceThread(View view) {


        Intent intent=new Intent(this, MyService.class);
        stopService(intent);
    }
}
