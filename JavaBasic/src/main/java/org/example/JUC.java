package org.example;

/**
 * JUC是Java并发框架
 * Lock框架{@link java.util.concurrent.locks.Condition}接口替代Object监视器使用，{@link java.util.concurrent.locks.Lock}替代synchronized,
 * {@link java.util.concurrent.locks.LockSupport}类似线程中的Thread.suspend()和Thread.resume()，但是不会遇到可能引发的线程问题
 * {@link java.util.concurrent.locks.StampedLock}StampedLock控制锁有三种模式(写，读，乐观读)
 * 同步辅助类，{@link java.util.concurrent.CountDownLatch}谞一个或者多个线程等待
 * {@link java.util.concurrent.CyclicBarrier}允许一组线程互相等待，直到达到一个公共的屏障点
 * {@link java.util.concurrent.Phaser}支持对任务的动态调整，并支持分层结构来达到更高的吞吐量
 * {@link java.util.concurrent.Semaphore}信号量
 * {@link java.util.concurrent.Exchanger}主要用于两个线程的数据交换
 * 并发集合
 * {@link java.util.concurrent.ArrayBlockingQueue}FIFO
 * {@link java.util.concurrent.LinkedBlockingQueue}FIFO,吞吐量高，预知性能低
 * {@link java.util.concurrent.ConcurrentLinkedQueue}无界线程安全队列
 * {@link java.util.concurrent.DelayQueue}无界延时队列
 * {@link java.util.concurrent.PriorityBlockingQueue}无界优先级队列
 * {@link java.util.concurrent.SynchronousQueue}通过CAS实现并发访问
 * {@link java.util.concurrent.LinkedTransferQueue}单向无界链表
 * {@link java.util.concurrent.CopyOnWriteArrayList}高并发读，低并发写很高效
 * {@link java.util.concurrent.ConcurrentSkipListSet}使用跳表，数据结构类似B+树
 * {@link java.util.concurrent.ConcurrentHashMap}JDK8后使用CAS+synchronized保证并发安全
 * Atomic,分为基础类型，数组，引用和字段，其中引用和字段可以解决ABA问题
 * Executors，{@link java.util.concurrent.Executors}线程池工具类
 * {@link java.util.concurrent.FutureTask}为future提供一个基础实现
 * {@link java.util.concurrent.ThreadPoolExecutor},实例化入参核心线程数，最大线程数，最大线程存活时间，阻塞队列，拒绝策略
 * {@link java.util.concurrent.ScheduledExecutorService}延迟和定期线程池
 * Fork/Join,是一种并行计算能力框架
 * @author luyunji
 */
public class JUC {
}
