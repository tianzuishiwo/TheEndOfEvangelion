package beauty.wsh.com.growdemo.adb;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import beauty.wsh.com.growdemo.R;
import beauty.wsh.com.growdemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/15.
 */
public class ADBActivity extends AppCompatActivity {
    private int count = 0;
  /*  @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        XLog.e("---ADBActivity---onCreate---");
        setContentView(R.layout.activity_adb);
        XLog.e("---ADBActivity---onCreate---");
        init();
    }*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adb);
        XLog.e("---ADBActivity---onCreate---");
        init();
    }
    
    private void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count<60){
                    count++;
                    SystemClock.sleep(2000L);
                    XLog.e("ADBActivity... "+count);
                }
                //关闭ADBActivty
                XLog.w("关闭ADBActivty");
                finish();
            }
        }).start();
    }
}
