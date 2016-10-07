package beauty.wsh.com.testserver.udp;

import android.os.SystemClock;

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
    private InetAddress mDesIp;
//    private String ip;
//    private int port;

    public SendRunnable(DatagramSocket udpServerSocket, String ip, int port) {
        if (ip!=null){
            InfoManager.setIp(ip);
            InfoManager.setPort(port);
        }
        mDatagramSocket = udpServerSocket;
        if (mSendPacket == null) {
            mSendPacket = new DatagramPacket(sendData.getBytes(), 0, sendData.length());
        }
    }

    @Override
    public void run() {
        try {
            mDesIp = InetAddress.getByName(InfoManager.getIp());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            XLog.e("找不到客户端ip: e=" + e);
        }
        mSendPacket.setAddress(mDesIp);// 不可缺少，否则空指针
        mSendPacket.setPort(InfoManager.getPort());// 不可缺少
//        mDatagramSocket.connect(mDesIp, InfoManager.getPort());// 这句话，仅仅第一次启动应用有用，关闭广播再启用发送数据包就空指针
        XLog.w("udp服务端发送： ip = "+InfoManager.getIp()+" port = "+InfoManager.getPort());
        while (UDPServer.enableSend) {// 记得关掉
            SystemClock.sleep(2000L);
            UDPServer.getmInstance().sendData(mSendPacket);
            XLog.e("每隔2秒，给客户端发送数据...");
        }
    }
}
