package beauty.wsh.com.helloandroiddemo.handler.timer;

import android.view.View;

import beauty.wsh.com.helloandroiddemo.HelloHelper;
import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class OpenListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        XLog.e("---OpenListener---");
        // 发送消息
//        HelloHelper
//                .getInstance()
//                .getTimerHandler()
//                .sendEmptyMessage(0);
       
        if ( HelloHelper
                .getInstance()
                .getTimerHandler()==null)return;
        // 发送任务
          HelloHelper
                  .getInstance()
                  .getTimerHandler()
                  .post(HelloHelper.getInstance().getTimerRunnable());
    }
}
