package beauty.wsh.com.testclient.tcp;

import java.io.IOException;
import java.io.InputStream;

import beauty.wsh.com.testclient.protocol.TCPProtocol;
import beauty.wsh.com.testclient.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class ReceiveThread extends Thread {
    private InputStream mIn;
    public ReceiveThread(InputStream in) {
        mIn = in;
        XLog.i("开启线程，接收服务端发送数据...");
        HeartThread heartThread = new HeartThread();
        heartThread.start();
    }

    @Override
    public void run() {
        byte[] bytes = new byte[1024];
        int length = -1;
        while (TcpClient.enableRead){
            if (mIn!=null){
                try {
//                    XLog.i("读取数据，陷入阻塞...");
                    length = mIn.read(bytes);
                    TCPProtocol.getmInstance().onReceiveData(bytes,0,length,null,0);
                } catch (IOException e) {
                    e.printStackTrace();
                    XLog.e("读取数据失败：e="+e);
                }
            }
        }
    }
}
