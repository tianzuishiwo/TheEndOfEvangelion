package beauty.wsh.com.testclient;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import beauty.wsh.com.testclient.utils.XLog;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        XLog.i("---initData---");
        XLog.e("这是客户端");
        mContext = getApplicationContext();
    }

    private void initView() {
        XLog.i("---initView---");
        XLog.d("---initView---");
        XLog.w("---initView---");
        XLog.e("---initView---");
        XLog.v("---initView---");
    }
    
    public void startUDPClient(View view){
        XLog.i("---startUDPClient---");
        ClientHelper.getmInstance().init(mContext).start();
    }
    
    public void finish(View view){
        XLog.i("---finish---");
        ClientHelper.getmInstance().finish();
    }
    
    public void send(View view){
        XLog.i("---send---");
        ClientHelper.getmInstance().sendData();
    }
    
    public void reset(View view){
        XLog.w("---reset---");
        ClientHelper.getmInstance().reset();
    }
}
