package org.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * JUC是Java并发框架
 * Lock框架{@link java.util.concurrent.locks.Condition}接口替代Object监视器使用，{@link java.util.concurrent.locks.Lock}替代synchronized,
 * {@link java.util.concurrent.locks.LockSupport}park和unpark类似线程中的Thread.suspend()和Thread.resume()，但是不会遇到可能引发的线程问题，会休眠当前线程，不会受语序不一的影响
 * sleep和wait的差别，sleep不会释放对象锁,wait和await，await会把线程添加到条件队列和完全释放锁
 * sleep和park会阻塞线程而且不会释放资源，wait和park，wait需要在同步块执行，wait有可能会出现异常
 * {@link java.util.concurrent.locks.StampedLock}StampedLock控制锁有三种模式(写，读，乐观读)
 * 同步辅助类
 * 独占acquire，公平和非公平，共享acquireShared，多个线程同时访问，底层通过{@link java.util.concurrent.locks.AbstractQueuedSynchronizer}实现，通过CLH队列锁去控制资源获取，CLH是一种虚拟双向队列，基于模版方法
 * AQS有两个链表，一个sync queue，核心方法acquire和release，一个condition queue，核心方法是await和signal
 * 公平锁，每个节点都是由前一个节点唤醒，发现前面节点是head便会执行
 * {@link java.util.concurrent.CountDownLatch}谞一个或者多个线程等待，是加技术，基于AQS，实施者是主线程，使用了state
 * {@link java.util.concurrent.CyclicBarrier}允许一组线程互相等待，直到达到一个公共的屏障点，是减计数，可重用，实施者是其他线程，使用了state
 * {@link java.util.concurrent.Phaser}分代控制理念支持对任务的动态调整，并支持分层结构来达到更高的吞吐量
 * {@link java.util.concurrent.Semaphore}信号量，基于AQS,允许特定数量的线程访问，没有重入的概念，连接池会使用，同时使用Condition
 * {@link java.util.concurrent.Exchanger}主要用于两个线程的数据交换，提供一个同步点，可以两个线程彼此交换数据
 * 并发集合
 * {@link java.util.concurrent.BlockingQueue}使用put和take进行阻塞，支持获取时间，线程池线程空闲时间由此确定
 * {@link java.util.concurrent.BlockingDeque}双端队列
 * {@link java.util.concurrent.ArrayBlockingQueue}FIFO，使用数组，不会扩容，有界，基于ReentrantLock
 * {@link java.util.concurrent.LinkedBlockingQueue}FIFO,吞吐量高，主要无界，用两个锁保证，基于ReentrantLock
 * {@link java.util.concurrent.DelayQueue}无界延时队列，使用{@link java.util.concurrent.locks.ReentrantLock}延时await的特性，基于ReentrantLock
 * {@link java.util.concurrent.PriorityBlockingQueue}无界优先级队列，使用{@link java.util.Comparator}保证顺序，基于ReentrantLock
 * {@link java.util.concurrent.SynchronousQueue}通过CAS实现并发访问，不存储元素，会阻塞插入，基于CAS
 * {@link java.util.concurrent.LinkedTransferQueue}单向无界链表，无锁，使用双重队列，入队是可以阻塞，出入队都会加节点，通过检测节点类型直接使用或往队列加数据
 * {@link java.util.concurrent.ConcurrentLinkedQueue}无界线程安全队列,使用的是延时更新策略，使用的是CAS,hops变量可以减少CAS
 * {@link java.util.concurrent.CopyOnWriteArrayList}高并发读，低并发写很高效
 * {@link java.util.concurrent.ConcurrentSkipListMap}使用跳表，数据结构类似B+树,并且是有序
 * {@link java.util.concurrent.ConcurrentHashMap}JDK8后使用CAS+synchronized保证并发安全,从头插法改成尾插法，防止死循环
 * Atomic,基于volatile和CAS，分为基础类型，数组，引用和字段，其中引用和字段通过版本号可以解决ABA问题，依赖UnSafe，基于汇编实现，循环开销较大
 * Executors
 * {@link java.util.concurrent.Executors}线程池工具类
 * {@link java.util.concurrent.FutureTask}为future提供一个基础实现，使用CAS保证结果同步和阻塞
 * {@link java.util.concurrent.CompletableFuture}future的一个高级使用类，可以控制完成、异常等结果处理
 * {@link java.util.concurrent.ThreadPoolExecutor},实例化入参核心线程数（不会收缩），最大线程数，最大线程存活时间（在getTask设置超时时间进行清理），线程工厂（设置线程池名称），阻塞队列，拒绝策略（Abort直接异常，Caller调用者执行，DiscardOld丢弃队列最前任务，Discard直接丢弃）
 * 大于核心线程数->大于阻塞队列数->大于最大线程数->拒绝策略，可以通过Future来获取结果，通过yield告诉调度器先执行其他线程
 * 线城池调优，从优先级、执行时间、性质（IO密集/CPU密集）、任务依赖，可以拆分两个线程池，cpu密集（Ncpu+1）,IO密集（Ncpu*2）
 * {@link java.util.concurrent.ScheduledThreadPoolExecutor}延迟和定期线程池,DelayedWorkQueue控制任务执行时间，一般有延时和周期执行两个参数
 * FixedRate固定周期执行，FixedDelay固定延时执行，不能调整最大线程数,使用的是无界队列
 * {@link java.util.concurrent.ForkJoinPool},是一种并行计算能力框架,核心是分治算法。每个线程都有自己的工作队列，也可以窃取其他队列
 * parallelStream默认使用ForkJoinPool，可以用于计算排序处理，大量多任务处理可以通过少数线程实现，fork（执行任务），join（等待任务结果），compute（）
 * @author luyunji
 */
public class JUC {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.parallelStream().forEach(System.out::println);
    }


}
