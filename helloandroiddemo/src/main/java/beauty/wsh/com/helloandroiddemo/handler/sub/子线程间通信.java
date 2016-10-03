package beauty.wsh.com.helloandroiddemo.handler.sub;

/**
 * Created by wuShaoHua on 2016/9/17.
 */
public interface 子线程间通信 {
    /**
     * 本来的思路是：
     * 创建两个子线程，一个开启handler,重写handlemessage方法，接收信息。
     * 另一个传入handler,不断发送消息。
     * （主线程的使用方式，转到子线程，自己开启Looper）
     * 谁知？
     * Looper.prepare()方法可以调用，Looper.Loop()一使用就蹦。
     * PS:怀疑是谷歌在最新api,增加的限制。
     */
}
