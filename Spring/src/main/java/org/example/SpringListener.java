package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventListenerMethodProcessor;

/**
 * 在BeanFactory启动的后置处理器中，{@link EventListenerMethodProcessor}会把所有监听器注册到监听管理器中
 * 同时spring具备Runner机制，提供在启动后需要加入配置或者处理逻辑
 * 标准事件，contextRefreshed,contextStarted,ContextStopped,ContextClosedEvent,RequestHandledEvent
 * {@link org.springframework.boot.ApplicationRunner}{@link org.springframework.boot.CommandLineRunner}
 * @author luyunji
 */
@Configuration
public class SpringListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 注解式监听
     * @param event ...
     */
    @EventListener(ApplicationEvent.class)
    public void listen(ApplicationEvent event) {
        System.out.println("事件触发：" + event.getClass().getName());
    }

    /**
     * 接口式监听
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

    }

    /**
     * 自定义事件
     */
    static class CustomEvent extends ApplicationEvent {
        public CustomEvent(Object source) {
            super(source);
        }
    }

    /**
     * 自定义事件发布
     */
    public void publish(){
        Object param = new Object();
        applicationEventPublisher.publishEvent(new CustomEvent(param));
    }


}
