package test.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService 是基于线程池设计的定时任务类，每个调度任务都会分配到线程
 * 池中的一个线程去执行，也就是说，任务是并发执行的，互不影响。
 * 需要注意，只有当调度任务来的时候，ScheduledExecutorSerice才会真正启动一个线程
 * 其余时间ScheduledExecutorService都是出于轮询任务的状态。
 *
 *
 * 最常用的两种调度方法
 *  ScheduleAtFixedRate
 *      每次执行时间为上次任务开始后推一个时间间隔
 *  ScheduleWithFixedDelay
 *      每次执行时间为上次任务结束起 向后推一个时间间隔
 *
 *   由此可见 ScheduleAtFixedRate 是基于固定时间间隔进行任务调度
 *   ScheduleWithFixedDelay 取决于每次任务执行的时间长短，是基于不固定时间间隔进行任务调度
 *
 *
 */
public class ScheduleExecutor {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        long initialDelay = 1;
        long period = 5;
        int i = 1;
        service.scheduleAtFixedRate(new ThreadRunner((i++)),initialDelay,period, TimeUnit.SECONDS);

    }
}
