package beauty.wsh.com.helloandroiddemo.handler.timer;

import android.os.Handler;
import android.os.Message;

import beauty.wsh.com.helloandroiddemo.HelloHelper;
import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class TimerHandler extends Handler{
    private int i = 0;
    @Override
    public void handleMessage(Message msg) {
        //TODO
        XLog.e("msg = "+msg.what+" 每隔两秒一次..."+i++);
//        this.postDelayed(HelloHelper.getInstance().getTimerRunnable(),2000L);
        this.post(HelloHelper.getInstance().getTimerRunnable());
        this.sendEmptyMessageDelayed(0,2000L);
    }
}
