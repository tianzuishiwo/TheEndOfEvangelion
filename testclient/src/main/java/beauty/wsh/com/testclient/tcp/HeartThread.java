package beauty.wsh.com.testclient.tcp;

import android.os.SystemClock;

import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class HeartThread extends Thread{
    private final String data = "heart";
    public HeartThread() {
        //开启判断线程
        new HeartCheckThread().start();
    }

    @Override
    public void run() {
        //开启心跳
        while (TcpClient.enableHeart){
            //每隔10秒，发送一次
            TcpClient.getmInstance().sendData(data);
            SystemClock.sleep(10000L);
            XLog.d("心跳...");
        }
    }
}
