package beauty.wsh.com.testclient.tcp;

import android.icu.text.IDNA;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import beauty.wsh.com.testclient.InfoManager;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class TcpClient {
    private static TcpClient mInstance = new TcpClient();
    private Socket mSocket;
    private InputStream mIn;
    private OutputStream mOs;
    public static boolean enableRead = true;
    public static boolean enableHeart = true;
    public static boolean enableCheckHeart = true;

    private TcpClient() {
    }

    public static TcpClient getmInstance() {
        return mInstance;
    }

    public void startLinkServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }).start();
    }

    private void start() {
        XLog.i("---startLinkServer---start---");
        enableRead = true;
        enableHeart = true;
        enableCheckHeart = true;
        String ip = InfoManager.getmIp();
        int port = InfoManager.getmPort();
        port = 13004;
        XLog.e("连接服务端： ip = " + ip + " port = " + port);
        try {
            mSocket = new Socket(ip, port);
            mIn = mSocket.getInputStream();
            mOs = mSocket.getOutputStream();
            new ReceiveThread(mIn).start();
        } catch (IOException e) {
            e.printStackTrace();
            XLog.e("连接服务端失败：e=" + e);
        }

    }

    public void sendData(String data) {
//        XLog.i("---sendData---  , data = "+data);
        if (mOs != null) {
            try {
                mOs.write(data.getBytes(), 0, data.length());
            } catch (IOException e) {
                e.printStackTrace();
                XLog.e("发送数据失败： e=" + e);
            }
        }
    }

    public void finishTcpClient() {
        XLog.i("---finishTcpClient---");
        enableRead = false;
        enableHeart = false;
        enableCheckHeart = false;
        if (mIn != null) {
            try {
                mIn.close();
                mIn = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (mOs != null) {
                try {
                    mOs.close();
                    mOs = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (mSocket!=null){
                try {
                    mSocket.close();
                    mSocket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
}
