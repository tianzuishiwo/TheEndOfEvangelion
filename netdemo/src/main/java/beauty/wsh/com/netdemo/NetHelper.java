package beauty.wsh.com.netdemo;

/**
 * Created by wuShaoHua on 2016/9/12.
 */
public class NetHelper {
    private static NetHelper mInstance = new NetHelper();
    private NetHelper() {
    }
    public static NetHelper getmInstance(){
        return mInstance;
    }
    
    public void init(){
        //初始化必要参数
        
    }
}
