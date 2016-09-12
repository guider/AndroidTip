import android.app.Application;

import com.yanyuanquan.android.Tip;
import com.yanyuanquan.android.progresshub.R;

/**
 * Created by guider on 16/9/12.
 * Email guider@yeah.net
 * github https://github.com/guider
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Tip.init(new Tip.Builder().setTextColor(R.color.colorAccent).setTextSize(20).setTextColor(R.color.colorPrimary));

    }
}
