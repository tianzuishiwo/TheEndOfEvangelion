package beauty.wsh.com.helloandroiddemo.handler.sub;

import android.os.Handler;
import android.os.SystemClock;

import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/17.
 */
public class SubHelper {
    private static SubHelper mInstance = new SubHelper();
    private Handler mHandler;

    private SubHelper() {
    }
    public static SubHelper getmInstance(){
        return mInstance;
    } 
    
    public void start(){
        openThread();
    }

    private void openThread() {
        XLog.e("---openThread---");
        new SubHandlerThread().start();
        SystemClock.sleep(1000L);
        new SubThread().start();
    }

    public void setHandler(Handler handler) {
//        XLog.e("---setHandler---");
        mHandler = handler;
    }
    
    public Handler getHandler(){
        return mHandler;
    }
}
