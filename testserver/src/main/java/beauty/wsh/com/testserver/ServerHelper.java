package beauty.wsh.com.testserver;

import beauty.wsh.com.testserver.udp.UDPServer;
import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class ServerHelper {
    private static ServerHelper mInstance = new ServerHelper();
    private UDPServer mUdpServer;

    private ServerHelper() {
    }
    public static ServerHelper getmInstance(){
        return mInstance;
    }
    
    public void start(){
        XLog.e("---start---");
        mUdpServer = UDPServer.getmInstance();
        mUdpServer.openUDPServer();
    }
    
    public void finish(){
        XLog.e("---finish---");
        if (mUdpServer!=null){
            mUdpServer.closeUDPServer();
        }
    }
}
