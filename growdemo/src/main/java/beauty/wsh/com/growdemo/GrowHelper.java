package beauty.wsh.com.growdemo;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

import beauty.wsh.com.growdemo.applyaar.AARHelper;
import beauty.wsh.com.growdemo.jni.JniUtils;
import beauty.wsh.com.growdemo.obfuscate.MyObfuscate;
import beauty.wsh.com.info.MyInfo;

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
    
   
    public String getToastStr(){
//        String CStr = JniUtils.getStringFromC("this is java");
        String CStr = MyObfuscate.getmInstance().getStrFromMyObfuscate();
        mTvContent.setText(CStr);
        return CStr;
    }
    // 点击，调用这个方法
    public void start() {
        String info = MyInfo.getInfo();
        mTvParameter.setText(info);
        AARHelper.getmInstance().init(mContext,mMainHandler,mTvContent).start();
    }
}
