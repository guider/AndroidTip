package com.yanyuanquan.android.progresshub;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yanyuanquan.android.Tip;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    Handler handler = new Handler(Looper.getMainLooper());
    private Runnable r ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = (Button) findViewById(R.id.show);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tip.getInstance().showTip(MainActivity.this,"这是一条消息", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.e("zjw", "关闭 ");
                    }
                });
                Log.e("zjw","  message   ++++++ ");
//            handler.postDelayed(r = new Runnable() {
//                @Override
//                public void run() {
//                    Log.e("zjw","  message  ");
//                }
//            },3000);

            }


        });
        findViewById(R.id.hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tip.getInstance().showTip(MainActivity.this,"又来一条消息", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
//                handler.removeCallbacks(r);

            }


        });
    }
}
