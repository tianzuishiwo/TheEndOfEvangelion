package beauty.wsh.com.growdemo.applyaar;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

import beauty.wsh.com.httpjar.MyHttpGet;

/**
 * Created by wuShaoHua on 2016/10/4.
 */

public class AARHelper {
    private static AARHelper mInstance = new AARHelper();
    private AARHelper() {
    }
    public static AARHelper getmInstance(){
        return mInstance;
    }
    private Context mContext;
    private Handler mHandler;
    private TextView mTvContent;
    
    public AARHelper init(Context context, Handler handler, TextView tvContent){
        mContext = context;
        mHandler = handler;
        mTvContent = tvContent;
        return mInstance;
    }
    
    public void start(){
        MyHttpGet instance = MyHttpGet.getmInstance();
        instance.init(mContext,mHandler,mTvContent);
        instance.start();
    }
}
