package beauty.wsh.com.javademo.api.string;

/**
 * Created by wuShaoHua on 2016/10/3.
 */

public class MyString {
    private static MyString mInstance = new MyString();
    private MyString() {
    }
    public static MyString getmInstance(){
        return mInstance;
    }
    
}
