package beauty.wsh.com.testclient.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import beauty.wsh.com.testclient.protocol.UDPProtocol;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class ReceiveRunable implements Runnable{
    private DatagramSocket mClientUDPSocket;
    public ReceiveRunable(DatagramSocket clientUDPSocket) {
        mClientUDPSocket = clientUDPSocket;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(bytes, 0, bytes.length);
        while (UDPClient.enableReceived){
            XLog.e("---run---");
            try {
                mClientUDPSocket.receive(receivePacket);
                String ip = receivePacket.getAddress().getHostAddress();
                int port = receivePacket.getPort();
                UDPProtocol protocol = UDPProtocol.getmInstance();
                protocol.onReceiveData(receivePacket.getData(),0,receivePacket.getLength(),ip,port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}
