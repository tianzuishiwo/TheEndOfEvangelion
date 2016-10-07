package beauty.wsh.com.testclient.tcp;

import android.os.SystemClock;

import java.util.Calendar;

import beauty.wsh.com.testclient.udp.UDPClient;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class HeartCheckThread extends Thread {
    public HeartCheckThread() {
    }

    public static void setLastTime(Calendar lastTime) {
        mLastTime = lastTime;
    }

    private static Calendar mLastTime;
    private Calendar mCurrentTime;
    private long second = 1000;

    @Override
    public void run() {
        mLastTime = Calendar.getInstance();//防止空指针
        while (TcpClient.enableCheckHeart){
            mCurrentTime = Calendar.getInstance();
            mCurrentTime.getTimeInMillis();
            if (mCurrentTime.getTimeInMillis()-mLastTime.getTimeInMillis()>30*second){
                XLog.w("心跳超时，重新建立连接。");
                //TODO 
                TcpClient.getmInstance().finishTcpClient();
                UDPClient.getmInstance().closeUDPClient();
                SystemClock.sleep(2500L);
                XLog.e(" 重新建立连接...");
//                TcpClient.getmInstance().startLinkServer();
                UDPClient.getmInstance().startUDPBroad();
            }else {
                XLog.d("check normal , sleep ......");
                SystemClock.sleep(20000L);
            }
        }
    }
}
