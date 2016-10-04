package beauty.wsh.com.utilsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import beauty.wsh.com.growdemo.jni.JniUtils;
import beauty.wsh.com.info.MyInfo;


public class MainActivity extends AppCompatActivity {

    private TextView mTvContent;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }

    private void initView() {
        mTvContent = (TextView) findViewById(R.id.tv_content);
    }
    
    public void click(View view){
        flag = !flag;
        String CString = "default";
        if (flag){
            CString  = JniUtils.getStringFromC("java");
        }else {
            CString = MyInfo.getInfo();
        }
      
        XLog.w("CString: "+CString);
        Toast.makeText(this,"Toast:"+CString,Toast.LENGTH_SHORT).show();
        mTvContent.setText(CString);
    }
    
    public void clear(View view){
        mTvContent.setText("tv_show");
    }
}
