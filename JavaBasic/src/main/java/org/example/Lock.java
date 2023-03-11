package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁机制，实现对共享资源互斥访问
 * synchronized,针对方法，代码块，锁住的可以是类，方法，对象，锁升级资源无锁->偏向锁（资源Mark Work写入线程id，适用于单个线程场景，由其他线程去撤销锁）->轻量级锁（Mark Word指向线程栈,资源重试计数和线程自旋，适用响应快，同步块执行速度快的场景）->重量级锁（阻塞没有锁的线程，吞吐量较大场景），字节码表现对象监视器monitorenter，monitorexit，synchroniedQueue是同步线程等待队列
 * 依赖底层操作系统Mutex Lock，由于从用户态切换到内核态，代价比较大，锁粗化（多个连续的锁扩展成一个范围更大的锁），StringBuffer的append连续操作，锁消除（通过JIT的逃逸分析检测不可能存在共享数据竞争的锁进行消除），javac编译器对String连接进行优化，自动转化成StringBuilder
 * 自适应自旋，由前一次锁上的自旋时间和锁的拥有者状态决定
 * volatile,基于内存屏障保证了可见性，由于处理器缓存所以缓存在数据不可见的情况，long和double分为高32位和低32位，普通读/写可能不是原子性，禁止重排序
 * {@link java.util.concurrent.locks.ReentrantLock},代码维度实现的锁，能够控制线程自旋等待。对比synchronized,是可中断的，并且可以设置等待时间，可实现公平锁，可以绑定多个条件对象
 * 除非需要使用 ReentrantLock 的高级功能，否则优先使用 synchronized
 * 单例实现，双重检查加锁(DCL)
 * final可以保证其他线程在读取前，一定会先读到final对象的引用，必须在构造函数前声明完成
 * 锁的特性：悲观锁（synchronized、Lock、for update）适合写多的场景，乐观锁(version,CAS)适合读多的场景
 * 锁对线程的处理：阻塞，非阻塞（自旋锁，Java默认是10次，适应性自旋）
 * 锁竞争方式：公平锁和非公平锁，公平锁不会饿死，但是吞吐量较低
 * 锁重入：可重入和不可重入，可重入锁的优点是可以避免死锁，不可重入锁需要先解锁才能获取
 * 锁共享：排他锁和共享锁{@link java.util.concurrent.locks.ReentrantReadWriteLock}，
 */
public class Lock {
    public synchronized static void main(String[] args) throws InterruptedException {
        synchronized ("1"){

        }
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
        condition1.await();//等待条件锁
        condition1.signal();//释放条件锁
        reentrantLock.lock();
        reentrantLock.tryLock();
        reentrantLock.unlock();
    }
}
