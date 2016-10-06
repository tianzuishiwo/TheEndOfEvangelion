package beauty.wsh.com.testclient.udp;

import android.content.Context;
import android.content.IntentFilter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import beauty.wsh.com.testclient.utils.MyCommonUtils;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class UDPClient {
    public static boolean enableReceived = true;
    public static boolean enableSend = true;
    private static UDPClient mInstance = new UDPClient();
    private DatagramSocket mClientUDPSocket;
    private DatagramPacket mSendUDPPacket;

    private UDPClient() {
    }
    public static UDPClient getmInstance(){
        return mInstance;
    }

    private String sendUDPData = "defaut_udp_data";
    private int clientPort = 13001;// 监听端口
    
    public void startUDPBroad(){
        XLog.e("---startUDPBroad---");
        start();
    }

    private void start() {
        XLog.e("---start---");
        //要发送的数据包
        if (mSendUDPPacket==null){
            mSendUDPPacket = new DatagramPacket(sendUDPData.getBytes(), 0, sendUDPData.length());
        }
        try {
            if (mClientUDPSocket==null){
                mClientUDPSocket = new DatagramSocket(clientPort);
                //TODO 1.发送和监听的端口，怎么区分？
                //TODO 2.发送的广播地址？
                new Thread(new ReceiveRunable(mClientUDPSocket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean sendUDPData(String data){// 发送udp数据
        boolean isExcuted = false;
        sendUDPData = data;
        try {
            mClientUDPSocket.send(mSendUDPPacket);
            isExcuted = true;
        } catch (IOException e) {
            e.printStackTrace();
            XLog.e("IOException: e="+e);
            isExcuted = false;
        }
        return isExcuted;
    }
    public boolean sendUDPData(DatagramPacket datagramPacket){// 发送udp数据
        boolean isExcuted = false;
        try {
            mClientUDPSocket.send(datagramPacket);
            isExcuted = true;
        } catch (IOException e) {
            e.printStackTrace();
            XLog.e("IOException: e="+e);
            isExcuted = false;
        }
        return isExcuted;
    }
    
    public boolean sendUDPBroad(Context context){
//        DatagramPacket requestDatagramPacket = new DatagramPacket(requestBytes, requestBytes.length,
//                new InetSocketAddress(broadcastAddress, mPort));
        boolean isExcuted = false;
        String broadcastAddress = MyCommonUtils.getBroadcastAddress(context);
        XLog.w("broadcastAddress = "+broadcastAddress);
        new Thread(new SendRunable(broadcastAddress)).start();
       
        return isExcuted;
    }
    
    public void closeUDPClient(){// 关闭udp客户端
        if (enableReceived)// 关闭接收线程
            enableReceived = false;
        if (enableSend)// 关闭发送线程
            enableSend = false;
        if (mClientUDPSocket!=null&&mClientUDPSocket.isConnected()){
            mClientUDPSocket.close();
        }
        
       
    }
}
