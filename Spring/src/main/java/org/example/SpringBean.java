package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * spring实例化过程
 * {@link ComponentScan}声明自动注入要扫描的包
 * ComponentScanAnnotationParser#parse(AnnotationAttributes, String)自动扫描执行逻辑，两种实例化方式，注解和接口<br/>
 * {@link ClassPathScanningCandidateComponentProvider#findCandidateComponents(String)}获取全部bean类文件<br/>
 * {@link ScopeMetadataResolver#resolveScopeMetadata(BeanDefinition)}设置作用域，单例，原型，request，session
 * {@link BeanDefinitionReaderUtils#registerBeanDefinition(BeanDefinitionHolder, BeanDefinitionRegistry)}注册bean，校验同名的bean，设置作用域代理
 * {@link AbstractApplicationContext#refresh()}spring-bean实例化
 * {@link AbstractApplicationContext#obtainFreshBeanFactory()}加载BeanFactory
 * invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory, List)执行BeanFactory后置处理器，通过反射初始化bean
 * registerBeanPostProcessors(ConfigurableListableBeanFactory, AbstractApplicationContext)执行bean到后置处理器
 * {@link AbstractBeanFactory#doGetBean(String, Class, Object[], boolean)}获取并初始化bean，singletonObjects，earlySingletonObjects，singletonFactories三级缓存解决单例循环依赖
 * 其他循环依赖解决方式，1、单例，2、{@link org.springframework.context.annotation.DependsOn}，3、{@link org.springframework.context.annotation.Lazy}
 * bean生命周期
 * 1、构造函数初始化
 * 2、通过setter或者反射给属性赋值
 * 3、{@link jakarta.annotation.PostConstruct}bean实例化后执行的方法
 * 4、自定义的init方法{@link Bean#initMethod()}
 * 5、{@link jakarta.annotation.PreDestroy}bean销毁前执行得方法
 * 6、自定义的destroy{@link Bean#destroyMethod()}
 *
 * @author luyunji
 */

@Scope
@Conditional({})/*参考其引用注解*/
@Component
@Configuration
@Description("")
@ImportRuntimeHints({})/*云原生支持*/
@Lazy
@Primary/*兜底bean，多个同类bean使用*/
@Profile({})/*执行的profile*/
@PropertySources({})/*配置序列化*/
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)/*bean的角色*/
@Controller
@Service
@Repository
@Order
public class SpringBean {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * @param args 命令行入参
     */
    public static void main(String[] args) {

    }

    /**
     *
     */
    public void getBean() {
        /*通过上下文获取bean，策略工厂模式*/
        Object xxx = applicationContext.getBean("xxx");
    }


}
