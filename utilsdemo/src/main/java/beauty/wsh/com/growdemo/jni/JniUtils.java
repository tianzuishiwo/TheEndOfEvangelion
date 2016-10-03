package beauty.wsh.com.growdemo.jni;

import beauty.wsh.com.utilsdemo.XLog;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class JniUtils {
    static {
        XLog.w("jni,开始调用！");
        System.loadLibrary("growdemo");
        XLog.w("jni,调用成功！");
//        System.loadLibrary("growdemo.so");
    }
    public static native String getStringFromC(String s);
}
//beauty.wsh.com.growdemo.jni.JniUtils