package beauty.wsh.com.testserver;

import beauty.wsh.com.testserver.tcp.TcpServer;
import beauty.wsh.com.testserver.udp.UDPServer;
import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class ServerHelper {
    private static ServerHelper mInstance = new ServerHelper();
    private UDPServer mUdpServer;
    private TcpServer mTcpServer;

    private ServerHelper() {
    }
    public static ServerHelper getmInstance(){
        return mInstance;
    }
    
    public void start(){
        XLog.i("---start---");
        mUdpServer = UDPServer.getmInstance();
        mUdpServer.openUDPServer();
        mTcpServer = TcpServer.getmInstance();
        mTcpServer.startTcpServer();
    }
    
    public void finish(){
        XLog.i("---finish---");
        if (mUdpServer!=null){
            mUdpServer.closeUDPServer();
        }
        if (mTcpServer!=null){
            mTcpServer.finishTcpServer();;
        }
    }
}
