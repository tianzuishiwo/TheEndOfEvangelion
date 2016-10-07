package beauty.wsh.com.testclient.udp;

import android.os.SystemClock;

import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import beauty.wsh.com.testclient.utils.MyCommonUtils;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class SendRunable implements Runnable {
    private String broadcastAddress;
    public SendRunable(String broadcastAddress) {
        this.broadcastAddress = broadcastAddress;
    }

    @Override
    public void run() {
        XLog.e("---run---");
        String data = "request";
        InetSocketAddress inetSocketAddress = new InetSocketAddress(broadcastAddress, 13002);
        DatagramPacket broadPacket = null;
        try {
            broadPacket = new DatagramPacket(data.getBytes(), data.length(), inetSocketAddress);
        } catch (SocketException e) {
            e.printStackTrace();
            XLog.e("发送广播失败");
        }
        while (UDPClient.enableSend){
            XLog.e("---while---");
            try {
                UDPClient.getmInstance().sendUDPData(broadPacket);
                SystemClock.sleep(2000L);
                XLog.e("每隔两秒，发送广播。。。");
            } catch (Exception e) {
                e.printStackTrace();
                XLog.e("发送广播失败");
            }
        }
        
    }
}
