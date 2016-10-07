package beauty.wsh.com.testserver.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import beauty.wsh.com.testserver.protocol.TcpProtocol;
import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class NewRunnable implements Runnable {
    private Socket mSocket;
    private InputStream mIn;
//    private OutputStream mOs;

    public NewRunnable(Socket acceptSocket,InputStream in) {
        XLog.i("收到客户端连接请求，建立连接，开启新线程...");
        mSocket = acceptSocket;
        mIn = in;
    }

    @Override
    public void run() {
       
        byte[] bytes = new byte[1024];
        int length = -1;
        
        while (TcpServer.enableRead){
            try {
                XLog.i("子线程，读取数据，阻塞中...");
                length = mIn.read(bytes);
                if (length>0) 
                    TcpProtocol.getmInstance().onReceiveData(bytes,0,length,null,0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
