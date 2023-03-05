package org.example;

/**
 * {@link java.lang.ThreadLocal}多线程中为每一个线程创建单独的变量副本的类,使用数组进行存储，有hash冲突会在数据后1个存放
 * 使用的最多session管理和数据库链接管理
 * 强引用，线程中有直接依赖的（默认）
 * 线程池使用ThreadLocal会造成内存泄露，在线程池重复实力化ThreadLocal后，并且ThreadLocal是个大对象，容易造成内存泄露
 * 软引用，继承{@link java.lang.ref.SoftReference},内存不足时将被回收
 * 弱引用，继承{@link java.lang.ref.WeakReference},发生GC时会被回收
 * 虚引用，继承{@link java.lang.ref.PhantomReference},发生GC事会被回收，配合队列使用，判断对象是否会被回收
 * @author luyunji
 */
public class ThreadLocal {
}
