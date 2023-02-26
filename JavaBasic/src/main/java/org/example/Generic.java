package org.example;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 泛型可进行编译器检查,上下限，指的是extends类型的子类或本身和supper类型的父类或本身，在编译后会出现类型擦除，在反射获取类型时将获取不到
 * 泛型不知道初始化确认类型的数组，<>定义对象，不能扩展Throwable，可通过反射来获取泛型
 */
public class Generic {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("org.example.Basic");
        Type superclass = aClass.getGenericSuperclass();
        Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
//        List<String>[] lists = new List<String>[10];不支持
        List<?>[] lists = new List<?>[10];
    }
}
