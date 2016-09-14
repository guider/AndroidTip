package com.yanyuanquan.android.progresshub;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yanyuanquan.android.Tip;

/**
 * Created by guider on 16/9/12.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tip.getInstance().showTip(TestActivity.this,"这是一条消息test", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.e("zjw", "关闭 ");
                    }
                });
            }


        });
    }

    protected void onPase(){
        super.onDestroy();
        Tip.getInstance().onPase();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Tip.getInstance().onDestory();
    }
}
