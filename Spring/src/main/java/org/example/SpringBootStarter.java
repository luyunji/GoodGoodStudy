package org.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * spring启动学习应用
 * 添加注解{@link SpringBootApplication}
 * 默认profile是default
 * 启动程序，打包，默认可以只加载spring-boot容器，可以打包成docker容器和war包
 * 使用内部容器可以选择Jetty，Undertow，可以制作成service
 *
 * @author by luyunji
 * @see <a href="https://www.baeldung.com/spring-cloud-bootstrap-properties">bootstrap.yaml与application.yaml说明</a>
 */
@SpringBootApplication
@ComponentScans({})
@Import(SpringBean.class)
public class SpringBootStarter extends SpringBootServletInitializer {

    /**
     * springboot应用启动过程与原理
     * {@link SpringApplication#createBootstrapContext()}创建启动上下文
     * {@link SpringApplication#getSpringFactoriesInstances(Class)}初始化启动注册器，应用上下文，监听器
     * {@link SpringApplication#deduceMainApplicationClass()}开启栈观察
     * {@link SpringApplication#configureHeadlessProperty()}设置缺少显示屏模式
     * {@link SpringApplication#getRunListeners(String[])}启动监听器
     * {@link SpringApplication#prepareEnvironment(SpringApplicationRunListeners, DefaultBootstrapContext, ApplicationArguments)}创建配置环境、加载属性配置文件和配置监听
     * {@link SpringApplication#printBanner(ConfigurableEnvironment)}打印banner
     * {@link SpringApplication#createApplicationContext()}创建应用上下文
     * {@link SpringApplication#refresh(ConfigurableApplicationContext)}}启动应用上下文，实例化bean，SpringFactoriesLoader加载自动配置
     * {@link SpringApplication#callRunners(ApplicationContext, ApplicationArguments)}执行自定义执行器
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
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootStarter.class);
    }


}
