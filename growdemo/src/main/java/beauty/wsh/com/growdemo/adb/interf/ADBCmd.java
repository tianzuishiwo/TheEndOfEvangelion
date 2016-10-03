package beauty.wsh.com.growdemo.adb.interf;

/**
 * Created by wuShaoHua on 2016/9/15.
 */
public interface ADBCmd {
    /**
     * 
     adb命令：
     
     （打开cmd窗口，输入前几个字符，点击Tab键，回车执行。好处：执行完，窗口不会关闭）
     
     adb -s a8c4b10b shell netcfg
     adb -s shell wm size
     adb get-serialno（获取序列号）
     
     adb shell --> su(获取root权限)
     $(没有root权限) --> #(获取root权限)

     adb root(判断该设备是否已经root)
     adb reboot(重启手机)

     adb shell --> su --> cat /data/misc/wifi/*.conf(查看连接过得wifi)
     adb shell --> su --> svc wifi disable(关闭wifi) --> svc wifi enable(开启wifi)
     重要备注：
     pm-->package manager
     am-->activity manager
     adb shell pm list package（列出全部包名）
     adb shell pm list packages(加不加s效果一样，pm什么意思)

     adb shell pm list package -f(全部包名，apk=包名)
     adb shell pm list package -s(全部系统应用)
     adb shell pm list package -3(第三方应用)
     adb shell pm list package -u(包含已卸载的应用)
     adb shell pm list package <过滤字符>（只显示含过滤字符的包名）

     adb shell pm list packages | grep baidu
     adb shell --> top | grep [关键字]（grep过滤包名）

    
     !!!!!无法实现
     adb shell dumpsys activity activities | grep mFocusedActivity(查看前台Activity)

     与应用交互
     adb shell am start [options] <intent>
     adb shell am start -a <action>(指定action,比如android.intent.action.VIEW)
     adb shell am start -c <action>(指定category,比如android.intent.category.APP_CONTACTS)
     adb shell am start -n <component>(指定完整component名,用于明确启动哪个activity)

     adb shell am startservice [options] <intent>
     adb shell am startservice -a <action>(指定action,比如android.intent..)
     adb shell am startservice -c <action>(指定category,比如android.intent.category..)
     adb shell am startservice -n <action>(指定完整component名，用于明确启动哪个service)

     adb shell am broadcast [options] <intent>
     adb shell am broadcast -a <action>(指定action,比如android.intent..)
     adb shell am broadcast -c <action>(指定category,比如androi.intent.category..)
     adb shell am broadcast -n <component>(指定完整component名,用于明确启动哪个broadcast)

     adb shell am force-stop <packagename>(强制停止应用)

     adb pull <设备里的文件路径> [电脑上的目录]（电脑上的目录可以省略，默认复制到发、当前目录）
     小技巧：设备上的文件路径可能需要 root 权限才能访问，如果你的设备已经 root 过，可以先使用 adb shell 和 su 命令在 adb shell 里获取 root 权限后，先 cp /path/on/device /sdcard/filename 将文件复制到 sdcard，然后 adb pull /sdcard/filename /path/on/pc。

     adb push <电脑里的文件> [设备上的目录+文件名]
     小技巧：设备上的文件路径普通权限可能无法直接写入，如果你的设备已经 root 过，可以先 adb push /path/on/pc /sdcard/filename，然后 adb shell 和 su 在 adb shell 里获取 root 权限后，cp /sdcard/filename /path/on/device。

     //TODO 挂载system
     重新挂载system分区为可写（注：需要root权限）
     adb shell --> su --> monut(查看挂载情况)
     mount -o remount,rw -t yaffs2 /dev/block/platform/msm_sdcc.1/by-name/system /system（重新挂载，这里的 /dev/block/platform/msm_sdcc.1/by-name/system 就是我们从上一步的输出里得到的文件路径。
     如果输出没有提示错误的话，操作就成功了，可以对 /system 下的文件为所欲为了。）

  
     压力测试：
     adb shell monkey -p com.example.gowildanzhuo.testdemo -v 50
     adb shell monkey -p <packagename> -v [times](monkey测试)


     其它
     如下是其它常用命令的简单描述，前文已经专门讲过的命令不再额外说明：

     命令	功能
     cat	显示文件内容
     cd	切换目录
     chmod	改变文件的存取模式/访问权限
     df	查看磁盘空间使用情况
     grep	过滤输出
     kill	杀死指定 PID 的进程
     ls	列举目录内容
     mount	挂载目录的查看和管理
     mv	移动或重命名文件
     ps	查看正在运行的进程
     rm	删除文件
     top	查看进程的资源占用情况

     adb shell rename path/oldfilename path/newfilename（重命名文件）
     adb shell rm /system/avi.apk（删除文件/system/avi.apk）
     adb shell rm -r <folder>（删除文件夹及其下面所有文件）
     adb shell mv path/file newpath/file（移动文件）
     adb shell chmod 777 /system/fonts/DroidSansFallback.ttf（设置文件权限）
     adb shell mkdir path/foldelname（新建文件夹）
     
     adb shell monkey -v -p your.package.name 500（跑monkey）
     adb shell service list（查看后台service信息）
     
     adb bugreport（查看bug报告）
     adb help（查看adb帮助）







     。
     */
}
