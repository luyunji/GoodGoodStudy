package org.example;

/**
 * 在classpath下的META-INF/services/目录里创建一个以服务接口命名的文件，这个文件里的内容就是这个接口的具体的实现类
 * ServiceLoader.load加载spi接口，并不是线程安全的
 * spi的应用，JDBC4.0
 * spring也支持spi，会加载META-INF/spring.factories，也就是starter的原理
 */
public class Spi {
}
