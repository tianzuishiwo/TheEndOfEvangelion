package beauty.wsh.com.helloandroiddemo.handler.sub;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/17.
 */
public class SubHandlerThread extends Thread {

    private Handler mSubHandler;

    @Override
    public void run() {
        XLog.e("SubHandlerThread---thread: " + this.currentThread().getName());
        Looper.prepare();//创建消息轮询器
        openHandler();
//        Looper.loop();//开启轮询器
        XLog.w("mSubHandler = "+mSubHandler);
        SubHelper.getmInstance().setHandler(mSubHandler);
        while (true){
            SystemClock.sleep(5000L);
            XLog.e("SubHandlerThread,线程活着...");
        }
    }

    private void openHandler() {
        //子线程handler
        mSubHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                XLog.e("---handleMessage--- msg.what = "+msg.what);
                switch (msg.what) {
                    case 0:
                        //TODO
                        String data = (String) msg.obj;
                        XLog.w("data : "+data);
                        break;
                    case 1:
                        break;
                    case 3:
                        break;
                }
            }
        };
//        Looper looper = mSubHandler.getLooper();
//        looper.quit();
    }
    
}
