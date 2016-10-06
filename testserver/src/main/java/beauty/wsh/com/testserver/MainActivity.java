package beauty.wsh.com.testserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import beauty.wsh.com.testserver.utils.XLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void startUDPServer(View view){
        XLog.e("---startUDPServer---");
        ServerHelper.getmInstance().start();
    }
    
    public void finish(View view){
        XLog.e("---finish---");
        ServerHelper.getmInstance().finish();
    }
}
