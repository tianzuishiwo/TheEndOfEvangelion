package beauty.wsh.com.theendofevangelion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import beauty.wsh.com.httpjar.MyHttpGet;
import beauty.wsh.com.theendofevangelion.jni.MyJniUtils;

public class MainActivity extends AppCompatActivity {

    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }

    private void initView() {
        mTvShow = (TextView) findViewById(R.id.tv_show);
    }
    
    public void loveyou(View view){
        Toast.makeText(this,"I love you",Toast.LENGTH_SHORT).show();
        mTvShow.setText(MyJniUtils.getStringFromCS2("java"));
    }
    
    public void clear(View view){
        mTvShow.setText("show_content");
    }
}
