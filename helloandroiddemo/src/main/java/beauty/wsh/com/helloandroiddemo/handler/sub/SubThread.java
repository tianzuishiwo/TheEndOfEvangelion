package beauty.wsh.com.helloandroiddemo.handler.sub;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/17.
 */
public class SubThread extends Thread{
    private int i = 0;
    @Override
    public void run() {
        XLog.e("SubThread---thread: "+this.currentThread().getName());
        Handler handler = SubHelper.getmInstance().getHandler();
        XLog.w("handler = "+handler);
        while (true){
            if (handler!=null){
            Message msg = handler.obtainMessage();
            msg.what = 0;
            msg.obj = "这是SubThead发送的消息: "+i++;
//            msg.sendToTarget();
                handler.sendMessage(msg);
            SystemClock.sleep(2000L);
            XLog.e("SubThead睡两秒...");
            }else {
                XLog.e("handler=null,保持线程活着...");
                SystemClock.sleep(2000L);
            }
        }
    }
}
