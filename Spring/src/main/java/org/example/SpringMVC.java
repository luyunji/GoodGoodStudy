package org.example;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.SpringServletContainerInitializer;

/**
 * 使用{@link SpringServletContainerInitializer}代替web.xml，通过配置spi启动spring-web容器
 * 调用{@link SpringBootServletInitializer#configure(SpringApplicationBuilder)}方法启动spring容器
 * 调用到{@link AbstractApplicationContext#onRefresh()}有{@link AbstractApplicationContext#createWebServer()}方法启动Servlet容器
 * {@link DispatcherServletAutoConfiguration}装载{@link org.springframework.web.servlet.DispatcherServlet}
 * 这时会加载各种Resolver(Multipart,Locale,Theme,Exception,View),Mapping,Adapter等
 * 处理请求过程，DispatcherServlet->HandlerMapping->Chain(Interceptor)->HandlerAdapter->返回ModelAndView->ViewResolver->Model->通过默认模版引擎Thymeleaf生成页面
 * {@link ServletComponentScan}可以扫描servlet3.0相关的注解
 * @author luyunji
 */
public class SpringMVC {
}
