package beauty.wsh.com.testserver.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class UDPServer {
    public static boolean enableReceived = true;
    public static boolean enableSend = false;
    private static UDPServer mInstance = new UDPServer();
    private DatagramPacket mReceivePacket;

    public DatagramSocket getUdpServerSocket() {
        return mUdpServerSocket;
    }

    private DatagramSocket mUdpServerSocket;
    private DatagramPacket mDatagramPacket;

    private UDPServer() {
    }

    public static UDPServer getmInstance() {
        return mInstance;
    }

    private int serverPort = 13002;// 监听端口
    private String sendData = "default_data";

    public void openUDPServer() {
        XLog.e("---openUDPServer---");
        open();
    }

    private void open() {
        XLog.e("---open---");
        enableReceived = true;
        if (mDatagramPacket == null) {
            mDatagramPacket = new DatagramPacket(sendData.getBytes(), 0, sendData.length());
        }
        try {
            if (mUdpServerSocket == null) {
                mUdpServerSocket = new DatagramSocket(serverPort);
                new Thread(new ReceiveRunnable(mUdpServerSocket)).start();
            }
        } catch (SocketException e) {
            e.printStackTrace();
            XLog.e("开启UDPServer,异常: e="+e);
        }
    }

    public void closeUDPServer() {
        XLog.e("---closeUDPServer---");
        if (enableReceived) enableReceived = false;
        if (enableSend) enableSend = false;
        if (mUdpServerSocket != null) {
//            mUdpServerSocket.disconnect();
            mUdpServerSocket.close();
            mUdpServerSocket = null;
        }
    }

    public void sendData(String data) {
        if (mUdpServerSocket != null && mDatagramPacket != null) {
            try {
                mUdpServerSocket.send(mDatagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
                XLog.e("sendData: e=" + e);
            }
        }
    }
    public void sendData(DatagramPacket datagramPacket) {
        if (mUdpServerSocket != null ) {
            try {
                mUdpServerSocket.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
                XLog.e("sendData: e=" + e);
            }
        }
    }
}
