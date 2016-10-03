package beauty.wsh.com.growdemo.adb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import beauty.wsh.com.growdemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/15.
 */
public class ADBBroadcast extends BroadcastReceiver{
    private int count = 0;
    @Override
    public void onReceive(Context context, Intent intent) {
        XLog.e("---ADBBroadcast---onReceive---");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count<60){
                    count++;
                    SystemClock.sleep(2000L);
                    XLog.e("ADBBroadcast... "+count);
                }
            }
        }).start();
    }
}
