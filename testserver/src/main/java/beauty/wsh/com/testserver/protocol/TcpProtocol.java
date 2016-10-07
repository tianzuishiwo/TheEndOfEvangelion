package beauty.wsh.com.testserver.protocol;

import beauty.wsh.com.testserver.interf.IReceiveData;
import beauty.wsh.com.testserver.tcp.TcpServer;
import beauty.wsh.com.testserver.udp.UDPServer;
import beauty.wsh.com.testserver.utils.XLog;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class TcpProtocol implements IReceiveData{
    private static TcpProtocol mInstance = new TcpProtocol();
    private TcpProtocol() {
    }
    public static TcpProtocol getmInstance(){
        return mInstance;
    }
    @Override
    public void onReceiveData(byte[] data, int offset, int length, String ip, int port) {
        XLog.w("offset = "+offset+" length = "+length);
        String receiveData = new String(data, offset, length);
        XLog.w("读取到数据： receiveData = "+receiveData);
        resolveData(receiveData);
    }

    private void resolveData(String receiveData) {
        String sendData ="";
        switch (receiveData){//TODO 数据返回处理
            case "0":
                sendData = "link success";
                //TODO  停止udpserver发送数据，而不是关闭
//                UDPServer.getmInstance().closeUDPServer();
              
                break;
            case "1":
                sendData = "one apple";
                break;
            case "2":
                sendData = "two apple";
                break;
            case "3":
                sendData = "three apple";
                break;
            case "4":
                sendData = "four apple";
                break;
            case "5":
                sendData = "five apple";
                break;
            case "6":
                sendData = "six apple";
                break;
            case "7":
                sendData = "seven apple";
                break;
            case "8":
                sendData = "eight apple";
                break;
            case "heart"://TODO 处理心跳
                XLog.e("处理，心跳...");
                sendData = "server heart";
                UDPServer.enableSend = false;
                break;
            default:
                sendData = "defaut data";
                break;
        }
        //向客户端发送数据
        XLog.e("向客户端发送数据: sendData = "+sendData);
        TcpServer.getmInstance().sendData(sendData);
    }
}
