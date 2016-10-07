package beauty.wsh.com.testclient;

import android.content.Context;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class InfoManager {
    private static String mIp = "";
    private static int mPort = 13004;//TCPServer 默认端口

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    private static Context mContext;

    public static int getmPort() {
        return mPort;
    }

    public static void setmPort(int mPort) {
        InfoManager.mPort = mPort;
    }

    public static String getmIp() {
        return mIp;
    }

    public static void setmIp(String mIp) {
        InfoManager.mIp = mIp;
    }

   
    
}
