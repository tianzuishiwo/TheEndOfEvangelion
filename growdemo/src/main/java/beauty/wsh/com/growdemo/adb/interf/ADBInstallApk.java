package beauty.wsh.com.growdemo.adb.interf;

/**
 * Created by wuShaoHua on 2016/9/15.
 */
public interface ADBInstallApk {
//    adb install a.apk（普通安装）
//    adb install -r a.apk(覆盖安装)
//    adb install -s a.apk(应用安装到sdcard)
//
//    adb uninstall <packagename>
//    adb uninstal -k <packagename>(保留数据和缓存目录)
//
//    adb shell pm clear <packagename>(应用：清除缓存和清除数据)
    /**
     * 安装 APK

     命令格式：

     adb install [-lrtsdg] <path_to_apk>
     参数：

     adb install 后面可以跟一些可选参数来控制安装 APK 的行为，可用参数及含义如下：

     参数	含义
     -l	将应用安装到保护目录 /mnt/asec
     -r	允许覆盖安装
     -t	允许安装 AndroidManifest.xml 里 application 指定 android:testOnly="true" 的应用
     -s	将应用安装到 sdcard
     -d	允许降级覆盖安装
     -g	授予所有运行时权限
     运行命令后如果见到类似如下输出（状态为 Success）代表安装成功：

     [100%] /data/local/tmp/1.apk
     pkg: /data/local/tmp/1.apk
     Success
     上面是当前最新版 v1.0.36 的 adb 的输出，会显示 push apk 文件到手机的进度百分比。

     使用旧版本 adb 的输出则是这样的：

     12040 KB/s (22205609 bytes in 1.801s)
     pkg: /data/local/tmp/SogouInput_android_v8.3_sweb.apk
     Success
     而如果状态为 Failure 则表示安装失败，比如：

     [100%] /data/local/tmp/map-20160831.apk
     pkg: /data/local/tmp/map-20160831.apk
     Failure [INSTALL_FAILED_ALREADY_EXISTS]
     常见安装失败输出代码、含义及可能的解决办法如下：

     输出	含义	解决办法
     INSTALL_FAILED_ALREADY_EXISTS	应用已经存在	使用 -r 参数
     INSTALL_FAILED_INVALID_APK	无效的 APK 文件	
     INSTALL_FAILED_INVALID_URI	无效的 APK 文件名	确保 APK 文件名里无中文
     INSTALL_FAILED_INSUFFICIENT_STORAGE	空间不足	清理空间
     INSTALL_FAILED_DUPLICATE_PACKAGE	已经存在同名程序	
     INSTALL_FAILED_NO_SHARED_USER	请求的共享用户不存在	
     INSTALL_FAILED_UPDATE_INCOMPATIBLE	已经安装过签名不一样的同名应用，且数据没有移除	
     INSTALL_FAILED_SHARED_USER_INCOMPATIBLE	请求的共享用户存在但签名不一致	
     INSTALL_FAILED_MISSING_SHARED_LIBRARY	安装包使用了设备上不可用的共享库	
     INSTALL_FAILED_REPLACE_COULDNT_DELETE	替换时无法删除	
     INSTALL_FAILED_DEXOPT	dex 优化验证失败或空间不足	
     INSTALL_FAILED_OLDER_SDK	设备系统版本低于应用要求	
     INSTALL_FAILED_CONFLICTING_PROVIDER	设备里已经存在与应用里同名的 content provider	
     INSTALL_FAILED_NEWER_SDK	设备系统版本高于应用要求	
     INSTALL_FAILED_TEST_ONLY	应用是 test-only 的，但安装时没有指定 -t 参数	
     INSTALL_FAILED_CPU_ABI_INCOMPATIBLE	包含不兼容设备 CPU 应用程序二进制接口的 native code	
     INSTALL_FAILED_MISSING_FEATURE	应用使用了设备不可用的功能	
     INSTALL_FAILED_CONTAINER_ERROR	sdcard 访问失败	确认 sdcard 可用，或者安装到内置存储
     INSTALL_FAILED_INVALID_INSTALL_LOCATION	不能安装到指定位置	切换安装位置，添加或删除 -s 参数
     INSTALL_FAILED_MEDIA_UNAVAILABLE	安装位置不可用	一般为 sdcard，确认 sdcard 可用或安装到内置存储
     INSTALL_FAILED_VERIFICATION_TIMEOUT	验证安装包超时	
     INSTALL_FAILED_VERIFICATION_FAILURE	验证安装包失败	
     INSTALL_FAILED_PACKAGE_CHANGED	应用与调用程序期望的不一致	
     INSTALL_FAILED_UID_CHANGED	以前安装过该应用，与本次分配的 UID 不一致	清除以前安装过的残留文件
     INSTALL_FAILED_VERSION_DOWNGRADE	已经安装了该应用更高版本	使用 -d 参数
     INSTALL_FAILED_PERMISSION_MODEL_DOWNGRADE	已安装 target SDK 支持运行时权限的同名应用，要安装的版本不支持运行时权限	
     INSTALL_PARSE_FAILED_NOT_APK	指定路径不是文件，或不是以 .apk 结尾	
     INSTALL_PARSE_FAILED_BAD_MANIFEST	无法解析的 AndroidManifest.xml 文件	
     INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION	解析器遇到异常	
     INSTALL_PARSE_FAILED_NO_CERTIFICATES	安装包没有签名	
     INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES	已安装该应用，且签名与 APK 文件不一致	先卸载设备上的该应用，再安装
     INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING	解析 APK 文件时遇到 CertificateEncodingException	
     INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME	manifest 文件里没有或者使用了无效的包名	
     INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID	manifest 文件里指定了无效的共享用户 ID	
     INSTALL_PARSE_FAILED_MANIFEST_MALFORMED	解析 manifest 文件时遇到结构性错误	
     INSTALL_PARSE_FAILED_MANIFEST_EMPTY	在 manifest 文件里找不到找可操作标签（instrumentation 或 application）	
     INSTALL_FAILED_INTERNAL_ERROR	因系统问题安装失败	
     INSTALL_FAILED_USER_RESTRICTED	用户被限制安装应用	
     INSTALL_FAILED_DUPLICATE_PERMISSION	应用尝试定义一个已经存在的权限名称	
     INSTALL_FAILED_NO_MATCHING_ABIS	应用包含设备的应用程序二进制接口不支持的 native code	
     INSTALL_CANCELED_BY_USER	应用安装需要在设备上确认，但未操作设备或点了取消	在设备上同意安装
     INSTALL_FAILED_ACWF_INCOMPATIBLE	应用程序与设备不兼容	
     does not contain AndroidManifest.xml	无效的 APK 文件	
     is not a valid zip file	无效的 APK 文件	
     Offline	设备未连接成功	先将设备与 adb 连接成功
     unauthorized	设备未授权允许调试	
     error: device not found	没有连接成功的设备	先将设备与 adb 连接成功
     protocol failure	设备已断开连接	先将设备与 adb 连接成功
     Unknown option: -s	Android 2.2 以下不支持安装到 sdcard	不使用 -s 参数
     No space left on devicerm	空间不足	清理空间
     Permission denied ... sdcard ...	sdcard 不可用	
     参考：PackageManager.java

     adb install 内部原理简介

     adb install 实际是分三步完成：

     push apk 文件到 /data/local/tmp。

     调用 pm install 安装。

     删除 /data/local/tmp 下的对应 apk 文件。

     所以，必要的时候也可以根据这个步骤，手动分步执行安装过程。

     卸载应用

     命令：

     adb uninstall [-k] <packagename>
     <packagename> 表示应用的包名，-k 参数可选，表示卸载应用但保留数据和缓存目录。

     命令示例：

     adb uninstall com.qihoo360.mobilesafe
     表示卸载 360 手机卫士。

     清除应用数据与缓存

     命令：

     adb shell pm clear <packagename>
     <packagename> 表示应用名包，这条命令的效果相当于在设置里的应用信息界面点击了「清除缓存」和「清除数据」。

     命令示例：

     adb shell pm clear com.qihoo360.mobilesafe
     表示清除 360 手机卫士的数据和缓存。

     查看前台 Activity

     命令：

     adb shell dumpsys activity activities | grep mFocusedActivity
     输出示例：

     mFocusedActivity: ActivityRecord{8079d7e u0 com.cyanogenmod.trebuchet/com.android.launcher3.Launcher t42}
     其中的 com.cyanogenmod.trebuchet/com.android.launcher3.Launcher 就是当前处于前台的 Activity。
     */
}
