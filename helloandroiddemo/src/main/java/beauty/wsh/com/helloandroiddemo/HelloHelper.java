package beauty.wsh.com.helloandroiddemo;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Button;

import beauty.wsh.com.helloandroiddemo.handler.main.MainHelper;
import beauty.wsh.com.helloandroiddemo.handler.sub.SubHelper;
import beauty.wsh.com.helloandroiddemo.handler.timer.CloseListener;
import beauty.wsh.com.helloandroiddemo.handler.timer.OpenListener;
import beauty.wsh.com.helloandroiddemo.handler.timer.TimerHandler;
import beauty.wsh.com.helloandroiddemo.handler.timer.TimerRunnable;
import beauty.wsh.com.helloandroiddemo.utils.XLog;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public class HelloHelper {
    private static HelloHelper mInstance = new HelloHelper();
    private TimerHandler mTimerHandler;
    private TimerRunnable mTimerRunnable;

    private HelloHelper() {
    }

    public static HelloHelper getInstance() {
        return mInstance;
    }

    private Context mContext;
    private Button mBtOpen;
    private Button mBtClose;
    private Handler mMainHandler ;

    public void init(Context context, Button btOpen, Button btClose, Handler handler) {
        XLog.e("---init---");
        mContext = context;
        mBtOpen = btOpen;
        mBtClose = btClose;
        mMainHandler = handler;
        mBtOpen.setOnClickListener(new OpenListener());
        mBtClose.setOnClickListener(new CloseListener());


        execute();
    }

    public void execute() {
        XLog.e("---execute---");
        SubHelper.getmInstance().start();//子线程handler使用
        
        //        MainHelper.getmInstance().start();//主线程handler使用
//        initTimerHandler();//定时器handler
    }

    public void initTimerHandler() {
        mTimerHandler = new TimerHandler();
        mTimerRunnable = new TimerRunnable();
    }

    public Handler getTimerHandler() {
        if (mTimerHandler != null)
            return mTimerHandler;
        XLog.e("mTimerHandler = null");
        return null;
    }

    public Runnable getTimerRunnable() {
        if (mTimerRunnable != null)
            return mTimerRunnable;
        XLog.e("mTimerRunnable = null");
        return null;
    }
    
    public Handler getMainHandler(){
        return mMainHandler;
    }
}
