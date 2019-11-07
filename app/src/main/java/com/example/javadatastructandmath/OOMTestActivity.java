package com.example.javadatastructandmath;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.tools.perflib.captures.DataBuffer;
import com.android.tools.perflib.captures.MemoryMappedFileBuffer;
import com.squareup.haha.perflib.ClassObj;
import com.squareup.haha.perflib.Snapshot;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class OOMTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oom);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HahaTest();
            }
        });
        OOMTest();
    }


    private void OOMTest(){
        // 1. 该线程为成员内部类，其包含MainActivity实例
        new MyThread().start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                // 2. 延时5分钟
                TimeUnit.MINUTES.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 测试Haha库
     */
    private void HahaTest(){
        try{
            File heapDumpFile = new File("/mnt/sdcard/xiongliang.hprof");
            //分析数据
            DataBuffer buffer = new MemoryMappedFileBuffer(heapDumpFile);
            Snapshot snapshot = Snapshot.createSnapshot(buffer);
            ClassObj someClass = snapshot.findClass("com.example.javadatastructandmath.OOMTestActivity");
            Log.i("msg","打印数据="+someClass);
        }catch (Exception e){
            e.printStackTrace();
        }

//        listener.onProgressUpdate(READING_HEAP_DUMP_FILE);
//        HprofBuffer buffer = new MemoryMappedFileBuffer(heapDumpFile);
//        HprofParser parser = new HprofParser(buffer);
//        listener.onProgressUpdate(PARSING_HEAP_DUMP);
//        Snapshot snapshot = parser.parse();
//        listener.onProgressUpdate(DEDUPLICATING_GC_ROOTS);
//        deduplicateGcRoots(snapshot);
//        listener.onProgressUpdate(FINDING_LEAKING_REF);
//        Instance leakingRef = findLeakingReference(referenceKey, snapshot);

    }
}
