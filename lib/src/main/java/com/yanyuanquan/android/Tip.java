package com.yanyuanquan.android;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yanyuanquan.android.lib.R;

/**
 * Created by guider on 16/9/8.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public class Tip {

    private static Tip instance;
    private LinearLayout view;
    private TextView title;
    private FrameLayout container;

    private boolean isShowing = false;
    private Tip() {

    }


    public static Tip getInstance() {
        if (instance == null) {
            synchronized (Tip.class) {
                if (instance == null) {
                    instance = new Tip();
                }
            }
        }
        return instance;
    }

    private Runnable runnable;

    public void showTip(Activity activity, String message, View.OnClickListener listener) {
        container = (FrameLayout) activity.findViewById(android.R.id.content);
        view = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.toptoast, container, false);
        title = (TextView) view.findViewById(R.id.title);

        new Handler(Looper.getMainLooper()).removeCallbacks(runnable);
        title.setText(message);
        if (!isShowing) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
            lp.topMargin = 50;
            view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove();
                }
            });
            container.addView(view);
            view.bringToFront();
        }
        isShowing = true;
        view.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                remove();
            }
        }, 2000);


    }

    public void remove() {
        if (activity != null && view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        isShowing = false;
    }

    public View getContentView() {
        return view;
    }

    private void L(String msg) {
        Log.e("zjw", msg);
    }


}
