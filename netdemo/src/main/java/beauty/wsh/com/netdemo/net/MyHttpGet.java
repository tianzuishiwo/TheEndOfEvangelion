package beauty.wsh.com.netdemo.net;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wuShaoHua on 2016/9/12.
 */
public class MyHttpGet {
    private static MyHttpGet mInstance = new MyHttpGet();
    private URL mUrl;
    private Context mContext;
    private Handler mHandler;
    private TextView mTvContent;

    private MyHttpGet() {
    }
    public static MyHttpGet getmInstance(){
        return mInstance;
    }
    
    public void init(Context context, Handler handler, TextView tvContent){
        mContext = context;
        mHandler = handler;
        mTvContent = tvContent;
    }
    
    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
               get(); 
            }
        }).start();
    }
    
    private void get(){
        StringBuilder sb = new StringBuilder();
        try {
            mUrl = new URL("http://www.androidweekly.cn/");
            URLConnection urlConnection = mUrl.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.connect();
            InputStream is = urlConnection.getInputStream();
            byte[] bytes = new byte[1024];
            int len =0;
            while ((len=is.read(bytes))!=-1){
                sb.append(new String(bytes,0,len));
            }
            final String content = sb.toString();
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mTvContent.setText(content);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
