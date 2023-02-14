package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * spring启动学习应用
 * 添加注解{@link SpringBootApplication}
 * 默认profile是default
 * 启动程序，打包//todo
 *
 * @author by luyunji
 * @see <a href="https://www.baeldung.com/spring-cloud-bootstrap-properties">bootstrap.yaml与application.yaml说明</a>
 */
@SpringBootApplication
public class SpringBootStarter /*extends SpringBootServletInitializer*/ {

    /**
     * springboot应用启动过程与原理
     * {@link SpringApplication#createBootstrapContext()}创建启动上下文
     * {@link SpringApplication#getSpringFactoriesInstances(Class)}加载启动注册器，应用初始化，监听器
     * {@link SpringApplication#deduceMainApplicationClass()}开启栈观察
     * {@link SpringApplication#configureHeadlessProperty()}设置缺少显示屏模式
     *
     * @param args 启动程序入参
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }

    /**
     * 外置Web容器使用该配置
     *
     * @param builder a builder for the application context
     */
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootStarter.class);
    }*/


}
