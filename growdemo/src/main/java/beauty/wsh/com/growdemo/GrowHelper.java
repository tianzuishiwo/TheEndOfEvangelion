package beauty.wsh.com.growdemo;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

import beauty.wsh.com.growdemo.jni.JniUtils;
import beauty.wsh.com.growdemo.obfuscate.MyObfuscate;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class GrowHelper {
    private static GrowHelper mInstance = new GrowHelper();
    private GrowHelper() {
    }
    public static GrowHelper getInstance(){
        return mInstance;
    }
    private Context mContext;
    private TextView mTvContent;
    private TextView mTvParameter;
    private Handler mMainHandler = new Handler();

    public void init(Context context, TextView tvContent, TextView tvParameter, Handler mainHandler){
        mContext = context;
        mTvContent = tvContent;
        mTvParameter = tvParameter;
        mMainHandler = mainHandler;
    }
    
    // 点击，调用这个方法
    public String getToastStr(){
        //TODO
//        String CStr = JniUtils.getStringFromC("this is java");
        String CStr = MyObfuscate.getmInstance().getStrFromMyObfuscate();
        mTvContent.setText(CStr);
        return CStr;
    }
}
