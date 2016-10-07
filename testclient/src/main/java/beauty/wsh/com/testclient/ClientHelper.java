package beauty.wsh.com.testclient;

import android.content.Context;
import android.os.SystemClock;

import java.net.InetSocketAddress;

import beauty.wsh.com.testclient.tcp.TcpClient;
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
        InfoManager.setContext(mContext);
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
    
    public void finish(){
        TcpClient.getmInstance().finishTcpClient();
    }
    
    public void sendData(){
        if (index>=9){
            index = 0;
        }
        TcpClient.getmInstance().sendData(dataArr[index++]);
    }
    
    private String[] dataArr = {"0","1","2","3","4","5","6","7","8","9"};
    private int index = 0;
    
    public void reset(){
        XLog.i("---一键重置，reset()---");
        UDPClient.getmInstance().closeUDPClient();
        TcpClient.getmInstance().finishTcpClient();
        SystemClock.sleep(2000L);
        start();
    }
}
