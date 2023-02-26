package org.example;

import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;

/**
 * 继承，多态，封装
 * 泛化关系，extends
 * 实现关系，implements
 * 聚合关系，Aggregation，类的包含
 * 组合关系，Composition，强依赖
 * 关联关系，Association，1.n
 * 依赖关系，Dependency
 * 基本字段类型位数,并有对应的封装类型，可实现自动装拆箱，封装类型并支持池化特性
 * boolean/1
 * byte/8
 * char/16
 * short/16
 * int/32
 * float/32
 * long/64
 * double/64
 * private、protected 以及 public，如果不加访问修饰符，表示包级可见
 * 抽象类和接口，抽象类包含行为，接口一般只有定义，可以通过default方式定义行为
 * 重写和重载，浅拷贝和深拷贝
 * 类在第一次使用时才加载到jvm
 * 异常基础类是{@link Throwable}，其子类有ERROR和Exception
 * ERROR指的是jvm出现错误，不能再继续执行，Exception指的是出现的异常的情况
 * BigDecimal代表价格，String应注意编码，系统默认使用Unicode
 * 位数不同强制转换会被丢弃
 * 枚举类型，编译后实际就是类包含对应的静态变量
 * finalize在内存清理对应对象时会触发，java9开始废弃
 * 异常分为受检查异常和运行时异常
 * super必须在程序第一行
 * 默认是unicode编码
 */
public class Basic {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());
    }
}
