package beauty.wsh.com.testclient.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import java.net.InetAddress;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class MyCommonUtils {
    /**
     * 获取广播地址
     */
    public static String getBroadcastAddress(Context context) {
        try {
            String              currentBroadcastIp = null;
            ConnectivityManager manager            = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info               = manager.getActiveNetworkInfo();
            int                 network_type       = info.getType();
            if (network_type == 1) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                DhcpInfo dhcp        = wifiManager.getDhcpInfo();
                int         broadcast   = (dhcp.ipAddress & dhcp.netmask) | ~dhcp.netmask;
                byte[]      quads       = new byte[4];
                for (int k = 0; k < 4; k++) {
                    quads[k] = (byte) ((broadcast >> k * 8) & 0xFF);
                    currentBroadcastIp = InetAddress.getByAddress(quads).getHostAddress();
                }
            }
            return currentBroadcastIp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
