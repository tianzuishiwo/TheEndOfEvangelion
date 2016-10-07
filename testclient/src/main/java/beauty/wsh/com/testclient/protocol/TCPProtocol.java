package beauty.wsh.com.testclient.protocol;

import java.util.Calendar;

import beauty.wsh.com.testclient.interf.IReceiveData;
import beauty.wsh.com.testclient.tcp.HeartCheckThread;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class TCPProtocol implements IReceiveData{
    private static TCPProtocol mInstance = new TCPProtocol();
    private TCPProtocol() {
    }
    public static TCPProtocol getmInstance(){
        return mInstance;
    }

    @Override
    public void onReceiveData(byte[] data, int offset, int length, String ip, int port) {
        if (length>0){
            String receiveData = new String(data, offset, length);
            XLog.w("收到服务端数据：receiveData = "+receiveData);
            resolveData(receiveData);
        }
       
    }

    private void resolveData(String receiveData) {
        //TODO 协议暂停
        switch (receiveData){
            case "server heart":
                //TODO 心跳（更新）
                HeartCheckThread.setLastTime(Calendar.getInstance());
                break;
            case "":
                break;
        }
    }
}
