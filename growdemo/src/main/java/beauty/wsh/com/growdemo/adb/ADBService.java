package beauty.wsh.com.growdemo.adb;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import beauty.wsh.com.growdemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/15.
 */
public class ADBService extends Service{
    private int count = 0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        XLog.e("---ADBService---onStartCommand---");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count<60){
                    count++;
                    SystemClock.sleep(2000L);
                    XLog.e("ADBService正在运行... "+count);
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
}
