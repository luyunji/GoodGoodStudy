package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

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
 * 非阻塞式IO，采用轮询的方式获取IO是否完成，程序级别控制
 * IO复用，事件驱动IO，阻塞式需要保持一个线程一个连接，不需要频繁去切换线程，epoll有LT(通知事件，可不立刻处理)和 ET(通知事件，必须立刻处理)，select（精度高，实时性高）、poll（没有文件描述符限制）、epoll（长连接轮询）
 * 信号驱动式，使用sigaction系统调用，内核数据到达向金城发送SIGIO信号，通知IO开始
 * 异步IO,使用aio_read系统调用会立即返回，发送信号通知IO完成，上面都是同步IO,获取复制内核数据都会被阻塞，操作系统级别控制，产生各个阶段的时间
 * {@link java.net.Socket}BIO,流输入输出，通过accept监听端口，没有连接时会阻塞
 * {@link java.nio.channels.Channel}NIO,以块的方式处理数据，编码方式比较复杂，分为文件，UDP,TCP，{@link java.nio.channels.Selector}通过轮询事件，获取对应channel
 * {@link java.nio.MappedByteBuffer}内存映射文件，比常规流和通道快的多，通过直接写入内存，操作系统负责映射到文件中
 * {@link ServerSocketChannel}IO多路复用，select->poll->epoll(linux现有)->kqueue，每个通道都有Buffer支持，分别有position，limit，capacity，可以同时监听TCP和UDP
 * Reactor模型，Reactor，Acceptor和Handler，有单线程读写处理，单线程读写（单通道）-多线程处理，多线程读写处理（多通道）
 * 异步IO,采用订阅-通知的模式，win提供IOCP支持异步IO,linux暂时没有异步IO技术通过epoll模拟
 * NETTY和MINA是高性能、异步事件驱动的NIO框架，比原生更好用，提供编码和解码，客户端权限，原生bug修复
 * NETTY拥有api简单，功能强大，综合性能最佳，社区活跃，定制能力强的特点，HashedWheelTimer
 * Linux零拷贝，内存映射{@link java.nio.MappedByteBuffer}通过分配虚拟内存的方式进行映射，{@link java.nio.DirectByteBuffer}可以直接分配堆外内存，{@link java.nio.channels.FileChannel},线程安全，通过管道实现数据传输，基于sendfile实现
 * 通道等于内核缓冲区，缓冲区指的是用户空间缓冲区，分为堆内和堆外，堆外需要手动回收
 * Netty零拷贝，完全基于用户态，更多是偏向数据操作优化
 * RocketMQ零拷贝选择mmap+write,适合小块传输，频繁调用，Kafka采用sendfile方式，大文件传输效率高
 */
public class IO {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();/*创建选择器*/
        /*将通道注册到选择器上*/
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        /*while (true){
            *//*监听事件*//*
            int select = selector.select();*//*轮询代理器*//*
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if(next.isReadable()){

                }
                iterator.remove();
            }
        }*/
//        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        AsynchronousServerSocketChannel open = AsynchronousServerSocketChannel.open();
        open.bind(new InetSocketAddress("0.0.0.0", 83));
//        open.accept(null, new ServerSocketChannelHandle(serverSocket));
        LockSupport.park();
    }
}
