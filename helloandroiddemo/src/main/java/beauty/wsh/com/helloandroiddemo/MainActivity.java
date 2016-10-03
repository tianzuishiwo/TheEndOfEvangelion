package beauty.wsh.com.helloandroiddemo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import beauty.wsh.com.helloandroiddemo.utils.XLog;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Button mBtOpen;
    private Button mBtClose;
    private TextView mTvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        XLog.e("---onCreate---");
        initView();
//        initListener();
        init();
    }

    private void init() {
        HelloHelper helper = HelloHelper.getInstance();
        helper.init(mContext, mBtOpen, mBtClose, mHandler);
    }

    private void initListener() {
        //初始化监听器
    }

    private void initView() {
        mBtOpen = (Button) findViewById(R.id.bt_open);
        mBtClose = (Button) findViewById(R.id.bt_close);
        mTvContent = (TextView) findViewById(R.id.tv_content);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            XLog.e("---handleMessage--- msg.what: "+msg.what);
            switch (msg.what) {
                case 0:
                    handleMsg(msg);
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    };

    private void handleMsg(Message msg) {
        StringBuilder sb = new StringBuilder();
        int arg1 = msg.arg1;
        int arg2 = msg.arg2;
        Object obj = msg.obj;
        String objStr = (String) obj;
        Bundle bundle = msg.getData();
        String strKey = (String) bundle.get("字符串key");
        int intKey = bundle.getInt("int_key");
        sb.append(arg1+"\n").append(arg2+"\n").append(objStr+"\n").append(strKey+"\n").append(intKey+"\n");
        
        mTvContent.setText("The data from subThread: "+sb.toString());
//        bundle.putString("字符串key","字符串value");//bundle存储字符串
//        bundle.putInt("int_key",0);//bundle存储基本类型
//        bundle.putByte("byte_key",(byte) 120);
//        bundle.putChar("char_key",'a');
//        bundle.putStringArrayList("list_str_key",new ArrayList<String>());//bundle存储集合
//        bundle.putIntegerArrayList("list_int_key",new ArrayList<Integer>());
//        bundle.putStringArray("arr_str_key",new String[5]);//bundle存储数组
//        bundle.putIntArray("arr_int_key",new int[6]);
    }
}
