package beauty.wsh.com.growdemo.multichannelapk;

/**
 * Created by wuShaoHua on 2016/10/1.
 */

public interface 多渠道打包 {
    /**
     * 所谓友盟打包，简单的有点郁闷。
     * 友盟打包如下：
     * 1.项目清单文件添加 meta-data 属性，里面的内容如下：
     * <meta-data android:name="UMENG_CHANNEL"
     * android:value="${UMENG_CHANNEL_VALUE}"/>
     * 备注：其实就是添加一个占位符。
     * 2.Project structrue中，在flavor属性，添加渠道如：wandoujia,baidu,anzhi等等；
     * 3.项目build.gradle的productFlavors属性中，添加占位符需要填写的内容，如下：
     *  wandoujia {
     *      manifestPlaceholders = [UMENG_CHANNEL_VALUE: "wangdoujia"]
     * }
     * 4.build-->generate signed apk，开始打包。 
     */
}
