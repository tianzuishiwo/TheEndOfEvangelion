package beauty.wsh.com.testserver.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class TcpServer {
    private static TcpServer mInstance = new TcpServer();
    private ServerSocket mServerSocket;
    private int mServerPort = 13004;
    public static boolean enableAccpet = true;
    public static boolean enableRead = true;
    private OutputStream mOs;
    private InputStream mIn;

    private TcpServer() {
    }
    public static TcpServer getmInstance(){
        return mInstance;
    }
    
    public void startTcpServer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }).start();
    }

    private void start() {
        XLog.i("---start---");
        enableAccpet = true;
        enableRead = true;
        try {
            if (mServerSocket==null){
                mServerSocket = new ServerSocket(mServerPort);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (enableAccpet){
            try {
                XLog.i("tcpserver,陷入阻塞，等待客户端连接...");
                if (mServerSocket!=null){
                    Socket acceptSocket = mServerSocket.accept();
                    mOs = acceptSocket.getOutputStream();
                    mIn = acceptSocket.getInputStream();
                    new Thread(new NewRunnable(acceptSocket,mIn)).start();
                }
               
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void sendData(String data){
        XLog.d("发送数据，sendData");
        if (mOs!=null){
            try {
                mOs.write(data.getBytes(),0,data.length());
            } catch (IOException e) {
                e.printStackTrace();
                XLog.e("发送数据，失败。 e="+e);
            }
        }
    }
    
    public void finishTcpServer(){
        XLog.i("---finishTcpServer---");
        enableAccpet = false;
        enableRead = false;
        if (mOs!=null){
            try {
                mOs.close();
                mOs = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (mIn!=null){
            try {
                mIn.close();
                mIn = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (mServerSocket!=null){
            try {
                mServerSocket.close();
                mServerSocket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
