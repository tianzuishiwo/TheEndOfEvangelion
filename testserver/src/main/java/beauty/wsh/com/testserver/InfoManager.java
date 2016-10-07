package beauty.wsh.com.testserver;

/**
 * Created by wuShaoHua on 2016/10/6.
 */

public class InfoManager {
    private static String ip;

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        InfoManager.port = port;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        InfoManager.ip = ip;
    }

    private static int port;
    
}
