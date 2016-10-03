package beauty.wsh.com.growdemo.adb.interf;

/**
 * Created by wuShaoHua on 2016/9/15.
 */
public interface ADBLog {
//    adb logcat -c（清除log缓存）

    /**
     * 查看日志

     Android 系统的日志分为两部分，底层的 Linux 内核日志输出到 /proc/kmsg，Android 的日志输出到 /dev/log。

     Android 日志

     命令格式：

     [adb] logcat [<option>] ... [<filter-spec>] ...
     常用用法列举如下：

     按级别过滤日志

     Android 的日志分为如下几个级别：

     V —— Verbose（最低，输出得最多）
     D —— Debug
     I —— Info
     W —— Warning
     E —— Error
     F —— Fatal
     S —— Silent（最高，啥也不输出）
     按某级别过滤日志则会将该级别及以上的日志输出。

     比如，命令：

     adb logcat *:W
     会将 Warning、Error、Fatal 和 Silent 日志输出。

     按 tag 和级别过滤日志

     比如，命令：

     adb logcat ActivityManager:I MyApp:D *:S
     表示输出 tag ActivityManager 的 Info 以上级别日志，输出 tag MyApp 的 Debug 以上级别日志，及其它 tag 的 Silent 级别日志（即屏蔽其它 tag 日志）。

     日志格式

     可以用 adb logcat -v <format> 选项指定日志输出格式。

     日志支持按以下几种 <format>：

     brief

     默认格式。格式为：

     <priority>/<tag>(<pid>): <message>
     示例：

     D/HeadsetStateMachine( 1785): Disconnected process message: 10, size: 0
     process

     格式为：

     <priority>(<pid>) <message>
     示例：

     D( 1785) Disconnected process message: 10, size: 0  (HeadsetStateMachine)
     tag

     格式为：

     <priority>/<tag>: <message>
     示例：

     D/HeadsetStateMachine: Disconnected process message: 10, size: 0
     raw

     格式为：

     <message>
     示例：

     Disconnected process message: 10, size: 0
     time

     格式为：

     <datetime> <priority>/<tag>(<pid>): <message>
     示例：

     08-28 22:39:39.974 D/HeadsetStateMachine( 1785): Disconnected process message: 10, size: 0
     threadtime

     格式为：

     <datetime> <pid> <tid> <priority> <tag>: <message>
     示例：

     08-28 22:39:39.974  1785  1832 D HeadsetStateMachine: Disconnected process message: 10, size: 0
     long

     格式为：

     [ <datetime> <pid>:<tid> <priority>/<tag> ]
     <message>
     示例：

     [ 08-28 22:39:39.974  1785: 1832 D/HeadsetStateMachine ]
     Disconnected process message: 10, size: 0
     指定格式可与上面的过滤同时使用。比如：

     adb logcat -v long ActivityManager:I *:S
     清空日志

     adb logcat -c
     内核日志

     命令：

     adb shell dmesg
     输出示例：

     <6>[14201.684016] PM: noirq resume of devices complete after 0.982 msecs
     <6>[14201.685525] PM: early resume of devices complete after 0.838 msecs
     <6>[14201.753642] PM: resume of devices complete after 68.106 msecs
     <4>[14201.755954] Restarting tasks ... done.
     <6>[14201.771229] PM: suspend exit 2016-08-28 13:31:32.679217193 UTC
     <6>[14201.872373] PM: suspend entry 2016-08-28 13:31:32.780363596 UTC
     <6>[14201.872498] PM: Syncing filesystems ... done.
     中括号里的 [14201.684016] 代表内核开始启动后的时间，单位为秒。

     通过内核日志我们可以做一些事情，比如衡量内核启动时间，在系统启动完毕后的内核日志里找到 Freeing init memory 那一行前面的时间就是。
     */

    /**
     * adb logcat
     *    
     *    Log分类
     Android日志主要分为kernel、radio、event、main这四种log。
     * 
     * Kernel Log
     kernel log属于Linux内核的log ，可以通过读取/proc/kmsg或者通过串口来抓取。
     adb 抓取kernel log的命令如下（需要有root权限）：
     [java] view plain copy print?
     adb shell cat /proc/kmsg > /tmp/kernel.log
     *
     * Radio Log
     -b radio参数可以抓取Android RIL层 log，在调试Android通信方面的代码时，这个Log非常关键。抓取命令如下：
     [java] view plain copy print?
     adb logcat -b radio > /tmp/radio.log
     *
     * Main Log
     main log和我们在eclipse里通过DDMS中看到的log是一致的。抓取命令如下：
     [java] view plain copy print?
     adb logcat -b main > /tmp/main.log
     *
     * Event Log
     event log属于system log，平时可以跟在main log之后。抓取命令如下：
     [java] view plain copy print?
     adb logcat -b event -v time > /tmp/event.log
     -v time表示在log中加入每条log发生的时间。
     *
     * 完整Log
     adb logcat -b选项是可以复用的，因此我们抓取所有Log的命令就是复用了-b选项。抓取命令如下：
     [java] view plain copy print?
     adb logcat -b main -b system -b radio -b events -v time > /tmp/all.log
     
     */
    
}
