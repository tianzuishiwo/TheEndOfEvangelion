package beauty.wsh.com.testserver.interf;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public interface IReceiveData {
    void onReceiveData(byte[] data, int offset, int length, String ip, int port);
}
