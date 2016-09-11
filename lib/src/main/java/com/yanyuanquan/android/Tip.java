package com.yanyuanquan.android;

import android.app.Activity;
import android.app.Fragment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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
    String TAG = "Tip";
    private static Tip instance;
    private LinearLayout view;
    private TextView title;
    private FrameLayout container;

    private boolean isShowing = false;

    private Runnable runnable;
    private Handler handler = new Handler(Looper.getMainLooper());

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

    public void showTiP(android.support.v4.app.Fragment fragment, String message, View.OnClickListener listener) {
        showTip(fragment.getActivity(), message, listener);
    }

    public void showTiP(Fragment fragment, String message, View.OnClickListener listener) {
        showTip(fragment.getActivity(), message, listener);
    }

    public void showTip(Activity activity, String message, View.OnClickListener listener) {
        handler.removeCallbacks(runnable);
        if (!isShowing) {
            container = (FrameLayout) activity.findViewById(android.R.id.content);
            view = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.toptoast, container, false);
            title = (TextView) view.findViewById(R.id.title);

            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
            lp.topMargin = 50;
            view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // handler对象要一致，否则失效
                    handler.removeCallbacks(runnable);
                    remove();
                }
            });
            container.addView(view);
            view.bringToFront();
        }
        title.setText(message);
        isShowing = true;
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {

                remove();
            }
        }, 2000);
    }

    public void remove() {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        isShowing = false;
    }

    public View getContentView() {
        return view;
    }

    private void L(String msg) {
        Log.e(TAG, msg);
    }


    public class Builder {
        int marginTop = 0;
        int backgroundColor = R.color._ccc;
        int imageResurce = R.drawable.tip_close_drawable;
        int textSize = 15;
        int textColor = R.color._fff;
        int inAnim =R.anim.tip_in_default;
        int outAnim = R.anim.tip_out_default;




    }


}
