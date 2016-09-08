package com.yanyuanquan.android.progresshub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yanyuanquan.android.Tip;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tip.getInstance().showTip(MainActivity.this,"这是一条消息", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.e("zjw", "关闭 ");
                    }
                });
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
            }


        });
    }
}
