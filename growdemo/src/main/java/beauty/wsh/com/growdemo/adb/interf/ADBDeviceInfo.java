package beauty.wsh.com.growdemo.adb.interf;

/**
 * Created by wuShaoHua on 2016/9/15.
 */
public interface ADBDeviceInfo {
    /**
     *
     adb shell getprop ro.product.model(查看当前手机版本)

     adb shell dumpsys battery(手机电量)

     adb shell wm size(手机屏幕)

     adb shell wm density(手机屏幕密度)

     adb shell dumpsys window displays(显示屏幕参数)（dumpsys-->显示）
     adb shell settings get secure android_id(显示andriod_id)
     adb shell dumpsys iphonesubinfo(获取IMEI权限)
     adb shell --> su --> service call iphonesubinfo 1

     adb shell getprop ro.build.version.release(Android系统版本)
     adb shell cat /sys/class/net/wlan0/address(获取mac地址)

     adb shell cat /proc/cpuinfo(查看当前cpu占用信息)
     adb shell cat /proc/meminfo(查看内存信息)
     adb shell cat /proc/iomem（查看IO内存分区）
     adb shell cat /system/build.prop(硬件与系统属性)

     adb shell getprop <属性名>
     adb shell getprop ro.build.version.sdk(查看SDK版本)
     adb shell getprop ro.build.version.release(查看Android系统版本)
     adb shell getprop ro.build.version.broad(查看处理器型号)
     adb shell getprop ro.build.version.brand(查看品牌)
     adb shell getprop ro.build.version.name(查看设备名)
     adb shell getprop ro.build.version.model(查看型号)
     adb shell getprop persist.sys.isUsbOtgEnabled(是否支持OTG)
     adb shell input text [String](当焦点处于某文本框时，该命令可以输入文本)  
     adb shell --> su --> date -s 20160914.111200(设置系统日期和时间)
     adb shell cat /system/build.prop（获取设备名称）

     adb shell screencap -p /sdcard/sc.png(屏幕截图)（-p指定生成的截图.png格式，如果文件名以.png结尾-p可以省略，否则不可省略）

     adb shell input keyevent [code](输入指定范围code,可以执行一些点击操作)
     (详细见adb说明)

     比如使用 adb shell input keyevent <keycode> 命令，不同的 keycode 能实现不同的功能，完整的 keycode 列表详见 KeyEvent，摘引部分我觉得有意思的如下：

     keycode	含义
     3	HOME 键
     4	返回键
     5	打开拨号应用
     6	挂断电话
     24	增加音量
     25	降低音量
     26	电源键
     27	拍照（需要在相机应用里）
     64	打开浏览器
     82	菜单键
     85	播放/暂停
     86	停止播放
     87	播放下一首
     88	播放上一首
     122	移动光标到行首或列表顶部
     123	移动光标到行末或列表底部
     126	恢复播放
     127	暂停播放
     164	静音
     176	打开系统设置
     187	切换应用
     207	打开联系人
     208	打开日历
     209	打开音乐
     210	打开计算器
     220	降低屏幕亮度
     221	提高屏幕亮度
     223	系统休眠
     224	点亮屏幕
     231	打开语音助手
     276	如果没有 wakelock 则让系统休眠
     下面是 input 命令的一些用法举例。

     电源键

     命令：

     adb shell input keyevent 26
     执行效果相当于按电源键。

     菜单键

     命令：

     adb shell input keyevent 82
     HOME 键

     命令：

     adb shell input keyevent 3
     返回键

     命令：

     adb shell input keyevent 4
     音量控制

     增加音量：

     adb shell input keyevent 24
     降低音量：

     adb shell input keyevent 25
     静音：

     adb shell input keyevent 164
     媒体控制

     播放/暂停：

     adb shell input keyevent 85
     停止播放：

     adb shell input keyevent 86
     播放下一首：

     adb shell input keyevent 87
     播放上一首：

     adb shell input keyevent 88
     恢复播放：

     adb shell input keyevent 126
     暂停播放：

     adb shell input keyevent 127
     点亮/熄灭屏幕

     可以通过上文讲述过的模拟电源键来切换点亮和熄灭屏幕，但如果明确地想要点亮或者熄灭屏幕，那可以使用如下方法。

     点亮屏幕：

     adb shell input keyevent 224
     熄灭屏幕：

     adb shell input keyevent 223
     滑动解锁

     如果锁屏没有密码，是通过滑动手势解锁，那么可以通过 input swipe 来解锁。

     命令（参数以机型 Nexus 5，向上滑动手势解锁举例）：

     adb shell input swipe 300 1000 300 500
     参数 300 1000 300 500 分别表示起始点x坐标 起始点y坐标 结束点x坐标 结束点y坐标。

     输入文本

     在焦点处于某文本框时，可以通过 input 命令来输入文本。

     命令：

     adb shell input text hello
     现在 hello 出现在文本框了
     */
}
