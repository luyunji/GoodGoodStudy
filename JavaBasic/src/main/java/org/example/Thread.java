package org.example;

/**
 * 使用线程
 * 实现{@link Runnable}{@link java.util.concurrent.Callable}，Runnable无返回值，Callable有返回值
 * 继承{@link java.lang.Thread}
 * {@link java.lang.Thread#setDaemon(boolean)}守护线程，当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程
 * {@link java.lang.Thread#yield()}只是对线程调度器的一个建议，而且也只是建议具有相同优先级的其它线程可以运行
 * {@link java.lang.Thread#join()}在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束
 * {@link java.lang.Thread#wait()}调用 wait() 使得线程等待某个条件满足，线程在等待时会被挂起，当其他线程的运行使得这个条件满足时，其它线程会调用 notify() 或者 notifyAll() 来唤醒挂起的线程,能用在同步方法或者同步控制块中使用，wait会释放锁
 * {@link InterruptedException}该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException,但是不能中断 I/O 阻塞和 synchronized 锁阻塞。interrupted不能终止执行中的线程，线程池使用shutdown操作
 * {@link java.util.concurrent.ThreadPoolExecutor}线程池
 * {@link java.util.concurrent.Future}用户获取线程结果
 * <a href="https://pdai.tech/images/pics/ace830df-9919-48ca-91b5-60b193f593d2.png">线程状态图</a>
 * @author luyunji
 */
public class Thread {
}
