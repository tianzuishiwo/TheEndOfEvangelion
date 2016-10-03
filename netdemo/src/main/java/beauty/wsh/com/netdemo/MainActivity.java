package beauty.wsh.com.netdemo;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import beauty.wsh.com.netdemo.net.MyHttpGet;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Handler mHandler = new Handler();
    private TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mTvContent = (TextView) findViewById(R.id.tv_content);
        init();
    }

    private void init() {
        MyHttpGet myHttpGet = MyHttpGet.getmInstance();
        myHttpGet.init(mContext,mHandler,mTvContent);
        myHttpGet.start();
    }
}
