package org.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * spring定时任务原理，通过bean形式注入后，注册器会扫描注解注册任务
 * 默认的线程通过Executors.newSingleThreadScheduledExecutor())通过DelayedWorkQueue实现延迟和周期执行，使用nanoTime进行计时
 * 可以设置异步执行，加入Async注解
 * {@link java.util.Timer}只能实现一个单线程来执行任务，产生未处理异常会导致线程停止，利用Object.wait决定下一次任务的执行时间，并在执行当前任务前设置下一个任务，使用系统时间进行计时
 * {@link io.netty.util.HashedWheelTimer}业内使用哈希轮优化百万量级I/O超时检测，好处是高性能，低消耗，缺点是非准实时，延迟短平快的任务
 * Quartz Quartz Cluster-https://www.w3cschool.cn/quartz_doc/，支持持久化和RAM，持久化采用抢占DB锁的形式运行任务
 * elastic-job-https://shardingsphere.apache.org/elasticjob/current/cn/overview/，面向互联网生态和海量任务
 * xxl-job-https://www.xuxueli.com/xxl-job/,开箱即用，使用协同分配的形式，通过rpc进行调度执行器，使用timewheel
 *
 * @author luyunji
 */
@EnableScheduling
@EnableAsync
public class SpringSchedule {

    /**
     * <a href="https://blog.csdn.net/m0_37479246/article/details/78970809">...</a>
     */
    @Scheduled(fixedDelay = 1)
    @Async("executor")
    public void worker(){
        /*292年连续取值不相同*/
        long l = System.nanoTime();
        /*32位系统存在2038问题，无符号可延续到2106*/
        System.currentTimeMillis();
    }
}
