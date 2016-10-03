package beauty.wsh.com.helloandroiddemo.handler.timer;

import android.view.View;

import beauty.wsh.com.helloandroiddemo.HelloHelper;
import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class CloseListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {

        XLog.e("---CloseListener---");
        // 移除消息
//        HelloHelper.getInstance().getTimerHandler().removeMessages(0);

        if ( HelloHelper
                .getInstance()
                .getTimerHandler()==null)return;
        // 移除消息
        HelloHelper
                .getInstance()
                .getTimerHandler()
                .removeCallbacks(HelloHelper.getInstance().getTimerRunnable());
    }
}
