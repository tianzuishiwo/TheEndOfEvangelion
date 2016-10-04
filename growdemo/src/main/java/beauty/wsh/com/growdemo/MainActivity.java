package beauty.wsh.com.growdemo;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import beauty.wsh.com.growdemo.utils.XLog;

public class MainActivity extends AppCompatActivity {

    private GrowHelper mHelper;
    private Context mContext;
    private TextView mTvContent;
    private TextView mTvParameter;
    private Handler mMainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        XLog.e("---onCreate---");
        initView();
        init();
    }

    private void initView() {
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mTvParameter = (TextView) findViewById(R.id.tv_parameter);
    }

    private void init() {
        mHelper = GrowHelper.getInstance();
        mHelper.init(mContext, mTvContent, mTvParameter, mMainHandler);
    }

    public void click(View view) {
        XLog.e("---click---");
//        startActivity(new Intent(this, ADBActivity.class));
//        Toast.makeText(this, "Toast: " + mHelper.getToastStr(), Toast.LENGTH_SHORT).show();
        mHelper.start();
    }
}
