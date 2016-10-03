package beauty.wsh.com.growdemo.obfuscate;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wuShaoHua on 2016/10/2.
 */

public class MyObfuscate {
    private static MyObfuscate mInstance = new MyObfuscate();
    private MyObfuscate() {
    }
    public static MyObfuscate getmInstance(){
        return mInstance;
    }
    
    private Context mContext;
    public void init(Context context){
        mContext = context;
    }
    
//    public void show(){
//        Toast.makeText(mContext,"this is MyObfuscate",Toast.LENGTH_LONG).show();
//    }
    
    public String getStrFromMyObfuscate(){
        return "this is MyObfuscate";
    }
}
