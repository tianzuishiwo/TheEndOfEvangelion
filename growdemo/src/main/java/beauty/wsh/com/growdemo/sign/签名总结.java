package beauty.wsh.com.growdemo.sign;

/**
 * Created by wuShaoHua on 2016/10/1.
 */

public interface 签名总结 {
    /**
     * 生成方式：
     * 方式一：开发工具生成AS、或者Eclipse；
     * 方式二：cmd命令生成；
     * 
     * AS生成：
     * 总是报错误：Password is not same.
     * 看沈洋视频解决；
     * ps:看沈洋视频后，操作即成功（重启了AS）,郁闷不只一两点。
     * 
     * cmd命令生成：
     * keytool -genkey -v -keystore release.keystore -alias androiddebugkey -keyalg RSA -validity 10000
     * ps:最后确认的时候，一定写"Y"或者"是"，否则陷入循环中。
     */
}
