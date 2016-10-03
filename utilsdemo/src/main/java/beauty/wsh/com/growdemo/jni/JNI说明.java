package beauty.wsh.com.growdemo.jni;

/**
 * Created by wuShaoHua on 2016/9/16.
 */
public interface JNI说明 {
    /**
     * 很烦啊，调试了好久！
     * 尤其是，当你做了正确修改，依旧显示错误，仅仅因为instant install 不稳定
     * 没有把最新的东西更新到apk中。
     * 悲剧了！
     * 
     * 注意：
     * 1.判断so文件加载是否成功，static代码块中打log;
     * 2.判断native方法调用是否成功。
     * 
     * jni 的java源码类的所在文件夹（包名）是否正确，（so文件中已经写死）
     * 
     * 真成功了，也就很容易了。
     * 一直失败，也就产生阴影了。
     */
}
