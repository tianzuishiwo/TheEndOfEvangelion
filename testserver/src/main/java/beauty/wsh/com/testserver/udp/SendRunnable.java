package beauty.wsh.com.testserver.udp;

import android.os.SystemClock;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import beauty.wsh.com.testserver.InfoManager;
import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class SendRunnable implements Runnable {
    private DatagramSocket mDatagramSocket;
    private String sendData = "server send client for ip and port";
    private DatagramPacket mSendPacket;
    private InetAddress mByName;
//    private String ip;
//    private int port;

    public SendRunnable(DatagramSocket udpServerSocket, String ip, int port) {
        InfoManager.setIp(ip);
        InfoManager.setPort(port);
        mDatagramSocket = udpServerSocket;
        if (mSendPacket == null) {
            mSendPacket = new DatagramPacket(sendData.getBytes(), 0, sendData.length());
        }
    }

    @Override
    public void run() {
        try {
            mByName = InetAddress.getByName(InfoManager.getIp());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            XLog.e("找不到客户端ip: e=" + e);
        }
        mDatagramSocket.connect(mByName, InfoManager.getPort());
        while (UDPServer.enableSend) {// 记得关掉
            try {
                UDPServer.getmInstance().sendData(mSendPacket);
                SystemClock.sleep(2000L);
                XLog.e("每隔2秒，给客户端发送数据...");
            } catch (Exception e) {
                e.printStackTrace();
                XLog.e("给客户端发送数据，失败 : e=" + e);
            }
        }
    }
}
