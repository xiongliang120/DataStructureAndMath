package com.example.javadatastructandmath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityManager.RunningTaskInfo
//        ActivityManager.RunningAppProcessInfo
        Looper.getMainLooper().setMessageLogging();
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button1);
        applyPermission();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OOMTestActivity.class);
                startActivity(intent);

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File heapDumpFile = new File("/mnt/sdcard/xiongliang.hprof");
                    System.gc();
                    System.gc();
                    Debug.dumpHprofData(heapDumpFile.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

//        testAnr();
//        testMath();
//        testList();
    }

    /**
     * 测试ANR
     */
    private void testAnr(){
        try {
            for (int i=0; i< 1000;i++){
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void applyPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        } else {
            //TODO
        }
    }


    private void testMath() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = sum(array, 0);
        Log.i("msg", "递归相加的结果是=" + result);
    }

    private int sum(int[] array, int position) {
        if (position == array.length) {
            return 0;
        }

        int result = array[position] + sum(array, ++position);
        return result;
    }

    private void testList() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.get(0);

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            Log.i("msg", "iterator 遍历集合=" + it.next());
        }
    }


}
