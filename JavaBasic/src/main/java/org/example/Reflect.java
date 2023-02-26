package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射一般从元数据区查找对应类型，通过类字节码找到对应的变量和方法
 * 反射使用软引用缓存class信息，而且每次获取类，都会生成一个新的classLoader，并且可以卸载
 * 类加载器可以从.class文件加载到内存当中，利用设null类加载器对象，实现对象class和对象实例的卸载
 * 反射是考虑到线程安全的
 */
public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object ins = Class.forName("org.example.Basic").getDeclaredConstructor().newInstance();
        Method me = ins.getClass().getDeclaredMethod("main", String[].class);
        me.setAccessible(false);
        String[] params = new String[]{"1"};
        Object[] objs = new Object[]{params};
        me.invoke(ins, objs);
    }
}
