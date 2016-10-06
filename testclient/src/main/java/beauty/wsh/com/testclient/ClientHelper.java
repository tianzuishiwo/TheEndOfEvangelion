package beauty.wsh.com.testclient;

import android.content.Context;
import android.os.SystemClock;

import beauty.wsh.com.testclient.udp.UDPClient;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class ClientHelper {
    private static ClientHelper mInstance = new ClientHelper();
    private UDPClient mUdpClient;

    private ClientHelper() {
    }
    public static ClientHelper getmInstance(){
        return mInstance;
    }
    private Context mContext;
    
    public ClientHelper init(Context context){
        mContext = context;
        return mInstance;
    }
    
    public void start(){// 入口方法
        mUdpClient = UDPClient.getmInstance();
        mUdpClient.startUDPBroad();
        SystemClock.sleep(2000L);
//        mUdpClient.sendUDPData("request");
        mUdpClient.sendUDPBroad(mContext);
        XLog.e("客户端发送广播...");
    }
}
