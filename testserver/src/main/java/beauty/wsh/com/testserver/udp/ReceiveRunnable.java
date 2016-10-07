package beauty.wsh.com.testserver.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import beauty.wsh.com.testserver.protocol.UDPProtocol;
import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class ReceiveRunnable implements Runnable {
    private DatagramSocket mUdpServerSocket;
    private DatagramPacket mReceivePacket;
    public ReceiveRunnable(DatagramSocket udpServerSocket) {
        mUdpServerSocket = udpServerSocket;
    }

    @Override
    public void run() {
        if (mReceivePacket==null){
            byte[] bytes = new byte[1024];
            mReceivePacket = new DatagramPacket(bytes, 0, bytes.length);
        }
       while (UDPServer.enableReceived){
           XLog.e("run(),开始接收数据...");
           try {
               mUdpServerSocket.receive(mReceivePacket);
               String ip = mReceivePacket.getAddress().getHostAddress();
               int port = mReceivePacket.getPort();
               XLog.w("服务端收到的: ip = "+ip+" port= "+port);
               UDPProtocol.getmInstance().onReceiveData(mReceivePacket.getData(),0,mReceivePacket.getLength(),ip,port);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
}
