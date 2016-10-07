package beauty.wsh.com.testclient.protocol;

import beauty.wsh.com.testclient.InfoManager;
import beauty.wsh.com.testclient.interf.IReceiveData;
import beauty.wsh.com.testclient.tcp.TcpClient;
import beauty.wsh.com.testclient.udp.UDPClient;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class UDPProtocol implements IReceiveData{// 协议类
    private static UDPProtocol mInstance = new UDPProtocol();
    private UDPProtocol() {
    }
    public static UDPProtocol getmInstance(){
        return mInstance;
    }

    @Override
    public void onReceiveData(byte[] data, int offset, int length, String ip, int port) {
        String receiveData = new String(data, offset, length);
        XLog.w("获取到: ip="+ip+" port="+port);
        XLog.w("收到服务端数据：receiveData="+receiveData);
        XLog.e("可以结束了，准备开启tcp.");
        InfoManager.setmIp(ip);
        InfoManager.setmPort(port);
        //TODO 结束发送广播
        UDPClient.getmInstance().closeUDPClient();
        //TODO 开启tcp连接
        TcpClient.getmInstance().startLinkServer();
    }
}
