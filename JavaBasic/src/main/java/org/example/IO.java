package org.example;

/**
 * IO指的是输入和输出流,传输方式分为字节流(Stream)和字符流(Reader)
 * 字节流多数用于处理二进制文件，字符流多数用于处理文本文件
 * {@link Character}使用的是utf-16,中文字符和英文字符都占 2 个字节
 * 从数据操作上分为，文件、数组、管道(线程间通信)、基本数据类型、缓冲、打印、对象序列化、转换、Socket/Datagram
 * 使用的是装饰者模式，可以通过组合实现多种实例特性
 * {@link java.io.InputStream}，按字节读取，控制偏移量，多线程读取处理提高效率
 * {@link java.io.OutputStream}，按字节写入，flush可强制刷新
 * Unix IO数据流转，等待数据->复制内核缓冲区->复制应用缓冲区
 * 阻塞式IO，应用被阻塞，直到复制应用缓冲区才返回
 * 非阻塞式IO，采用轮询的方式获取IO是否完成
 * IO复用，事件驱动IO，阻塞式需要保持一个线程一个连接，不需要频繁去切换线程，epoll有LT(通知事件，可不立刻处理)和 ET(通知事件，必须立刻处理)，select（精度高，实时性高）、poll（没有文件描述符限制）、epoll（长连接轮询）
 * 信号驱动式，使用sigaction系统调用，内核数据到达向金城发送SIGIO信号，通知IO开始
 * 异步IO,使用aio_read系统调用会立即返回，发送信号通知IO完成，上面都是同步IO,获取复制内核数据都会被阻塞
 *
 */
public class IO {

    public static void main(String[] args) {
    }
}
