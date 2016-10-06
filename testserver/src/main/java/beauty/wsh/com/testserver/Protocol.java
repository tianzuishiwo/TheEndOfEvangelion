package beauty.wsh.com.testserver;

import java.net.DatagramSocket;

import beauty.wsh.com.testserver.interf.IReceiveData;
import beauty.wsh.com.testserver.udp.SendRunnable;
import beauty.wsh.com.testserver.udp.UDPServer;
import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class Protocol implements IReceiveData {// 服务端协议
    private static Protocol mInstance = new Protocol();
    private DatagramSocket mUdpServerSocket;

    private Protocol() {
    }

    public static Protocol getmInstance() {
        return mInstance;
    }

    @Override
    public void onReceiveData(byte[] data, int offset, int length, String ip, int port) {
        String receiveData = new String(data, offset, length);
        XLog.w("收到的数据：receiveData=" + receiveData);
        resolveData(receiveData,ip,port);
    }

    private void resolveData(String receiveData, String ip, int port) {// 处理数据
        XLog.e("---resolveData---");
        String sendData = "default_data";
        switch (receiveData) {
            case "request":
                XLog.w("处理，request");
                //TODO 具体协议(特别数据才走这里)
                if (mUdpServerSocket==null){
                    mUdpServerSocket = UDPServer.getmInstance().getUdpServerSocket();
                    new Thread(new SendRunnable(mUdpServerSocket,ip,port)).start();
                }
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                break;
        }
        sendData(sendData);
    }

    private void sendData(String sendData) {
        UDPServer.getmInstance().sendData(sendData);
    }

}
