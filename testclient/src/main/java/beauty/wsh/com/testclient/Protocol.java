package beauty.wsh.com.testclient;

import beauty.wsh.com.testclient.interf.IReceiveData;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class Protocol implements IReceiveData{// 协议类
    private static Protocol mInstance = new Protocol();
    private Protocol() {
    }
    public static Protocol getmInstance(){
        return mInstance;
    }


    @Override
    public void onReceiveData(byte[] data, int offset, int length, String ip, int port) {
        String receiveData = new String(data, offset, length);
        XLog.w("获取到: ip="+ip+" port="+port);
        XLog.w("收到服务端数据：receiveData="+receiveData);
        XLog.e("可以结束了，准备开启tcp.");
    }
}
