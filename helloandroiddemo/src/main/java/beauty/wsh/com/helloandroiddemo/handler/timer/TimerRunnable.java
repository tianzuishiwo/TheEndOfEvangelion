package beauty.wsh.com.helloandroiddemo.handler.timer;

import beauty.wsh.com.helloandroiddemo.HelloHelper;
import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class TimerRunnable implements Runnable{
    private int i = 1;
    @Override
    public void run() {
        XLog.w("TimerRunnable里的任务执行次数："+i++);

        HelloHelper.getInstance().getTimerHandler().postDelayed(this,2000L);
    }
}
