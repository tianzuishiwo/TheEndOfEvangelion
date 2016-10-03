package beauty.wsh.com.helloandroiddemo.handler.handlerthread;


import android.os.Handler;
import android.os.HandlerThread;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class HandlerHelper {
    private static HandlerHelper mInstance = new HandlerHelper();
    private HandlerHelper() {
    }
    public static HandlerHelper getmInstance(){
        return mInstance;
    }
    
    public void start(){
        // 开启线程，给线程命名
        HandlerThread sub_thread = new HandlerThread("sub_thread");
        sub_thread.start();

        // 传入Looper
        Handler handler = new Handler(sub_thread.getLooper());
        
        // 终止Looper
        sub_thread.quit();
    }
}
