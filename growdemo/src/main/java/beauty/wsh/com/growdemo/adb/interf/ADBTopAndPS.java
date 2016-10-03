package beauty.wsh.com.growdemo.adb.interf;

/**
 * Created by wuShaoHua on 2016/9/15.
 */
public interface ADBTopAndPS {
    /**
     *
     adb shell ps(查看进程列表)
     adb shell kill [pid]（杀死一个进程）
     adb shell ps -x [PID]（查看指定进程状态）


     adb shell top(查看实时资源占用情况)
     adb shell top -m 6（查看占用内存前6的app）
     adb shell top -n 1（刷新一次内存信息，然后返回）
     adb shell procrank（查询各进程内存使用情况）

     列名	含义
     PID	进程 ID
     PR	优先级
     CPU%	当前瞬间占用 CPU 百分比
     S	进程状态（R=运行，S=睡眠，T=跟踪/停止，Z=僵尸进程）
     #THR	线程数
     VSS	Virtual Set Size 虚拟耗用内存（包含共享库占用的内存）
     RSS	Resident Set Size 实际使用物理内存（包含共享库占用的内存）
     PCY	调度策略优先级，SP_BACKGROUND/SPFOREGROUND
     UID	进程所有者的用户 ID
     NAME	进程名

     top 命令还支持一些命令行参数，详细用法如下：

     Usage: top [ -m max_procs ] [ -n iterations ] [ -d delay ] [ -s sort_column ] [ -t ] [ -h ]
     -m num  最多显示多少个进程
     -n num  刷新多少次后退出
     -d num  刷新时间间隔（单位秒，默认值 5）
     -s col  按某列排序（可用 col 值：cpu, vss, rss, thr）
     -t      显示线程信息
     -h      显示帮助文档

     */
}
