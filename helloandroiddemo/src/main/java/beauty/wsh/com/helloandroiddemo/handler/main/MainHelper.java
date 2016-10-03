package beauty.wsh.com.helloandroiddemo.handler.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

import java.util.ArrayList;

import beauty.wsh.com.helloandroiddemo.HelloHelper;
import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class MainHelper {
    private static MainHelper mInstance = new MainHelper();
    private Handler mMainHandler;

    private MainHelper() {
    }
    public static MainHelper getmInstance(){
        return mInstance;
    }
    
    public void start(){
        mMainHandler = HelloHelper.getInstance().getMainHandler();
        // 子线程
        openSubThread();
    }

    private void openSubThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                XLog.e("进入子线程，先睡3秒...");
                SystemClock.sleep(3000L);//内部走-->Thread.sleep()
                
               // 获取消息的三种方式
//                Message msg = new Message();//方式一
//                Message msg = Message.obtain();//方式二
                Message msg = mMainHandler.obtainMessage();//方式三
                msg.what = 0;//相当于设定type,以便在handlemessage中加以区分
                msg.arg1 = 66;//arg1，arg2用来携带int类型参数
                msg.arg2 = 88;//效率比object高
                msg.obj = "object";//object 可以暂存任何类型参数
                Bundle bundle = new Bundle();
                bundle.putString("字符串key","字符串value");//bundle存储字符串
                bundle.putInt("int_key",0);//bundle存储基本类型
                bundle.putByte("byte_key",(byte) 120);
                bundle.putChar("char_key",'a');
                bundle.putStringArrayList("list_str_key",new ArrayList<String>());//bundle存储集合
                bundle.putIntegerArrayList("list_int_key",new ArrayList<Integer>());
                bundle.putStringArray("arr_str_key",new String[5]);//bundle存储数组
                bundle.putIntArray("arr_int_key",new int[6]);
                
                msg.setData(bundle);//message存储bundle
                msg.sendToTarget();//发送消息，方式一（内部走方式二）
//                mMainHandler.sendMessage(msg);//发送消息，方式二
                XLog.e("子线程发送消息，完成。");
            }
        }).start();
    }
}
