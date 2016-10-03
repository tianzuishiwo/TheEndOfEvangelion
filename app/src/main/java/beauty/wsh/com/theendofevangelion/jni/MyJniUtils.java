package beauty.wsh.com.theendofevangelion.jni;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class MyJniUtils {
    static {
        System.loadLibrary("app");
    }
    
    public static native String getStringFromCS2(String s);
}
