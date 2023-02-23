package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * springAop启动流程,需要加入spring-boot-starter-aop
 * 配置启动AOP后进行织入
 * postProcessBeforeInstantiation主要生成把切面信息封装到Advisor
 * postProcessAfterInitialization进行注入到合适位置，创建代理实例
 * 在bean实例化过程当中进行切入，默认使用是动态代理，也可使用静态代理（编译时代理）
 * 默认在目标类实现接口时使用JDK代理，非接口使用Cglib代理
 * Cglib直接生成动态代理类继承目标类（Target$$CGLIB$$XX）,代理类会执行原方法并加入其前后执行逻辑，使用字节码增强生成动态代理类，原方法将被替换成代理方法
 * final和static方法不能被代理
 * 字节码重写分为运行时重写和类加载时重写，运行时重写使用Instrument的方式
 * JDK代理使用InvocationHandler实现代理类的构建，通过Proxy.newProxyInstance直接生成目标类实例（$Proxy0）,目标类通过反射调用代理方法
 * 反射慢在首次调用时的通过名字查找类和类的加载，后续调用性能和原生调用相差不大
 * @author luyunji
 * @see https://www.cnblogs.com/takumicx/p/10150344.html
 */
@EnableAspectJAutoProxy
@EnableLoadTimeWeaving/*Instrumentation接口实现*/
@Aspect
public class SpringAop {

    @Pointcut
    void pointCut(){}

    @Before("pointCut()")
    public void before(){}

    @After("pointCut()")
    public void after(){}

    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){}

}
