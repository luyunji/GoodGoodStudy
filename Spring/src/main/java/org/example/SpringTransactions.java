package org.example;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * spring-transaction分为编程式事务和声明式事务，基于spring-aop，由于通过cglib生成子类代理，因此无法代理private方法
 * 声明式事务只能使用在public方法上
 * <a href="https://juejin.cn/post/6854573213616177159">...</a>
 * @author luyunji
 */
@EnableTransactionManagement
@Component
public class SpringTransactions {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * {@link Propagation}事务传播类型，使用ThreadLocal保存事务状态
     * REQUIRED默认开启事务，如果不存在，则创建一个新的事务（setAutoCommit(false)）
     * REQUIRES_NEW无论如何开启一个新的事务(使用一个新的连接去执行)
     * NESTED嵌套事务，在一个事务中开启一个子事务，子事务使用savepoint实现（setSavepoint）
     * MANDATORY如果方法是在一个事务中，则加入事务，否则抛出异常（检测是否有事务）
     * NOT_SUPPORTED如果方法在事务中，则挂起当前事务，也就是不会回滚
     * NEVER以非事务的方式运行，如果当前存在事务，则抛出异常
     * SUPPORTS如果当前存在事务，则加入该事务；如果当前不存在事务，则以非事务的方式继续运行
     * {@link Isolation}读未提交，读已提交，可重复读，串行化
     *
     * <a href="https://blog.csdn.net/nextyu/article/details/78669997">...</a>
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public void statement(){
        this.transactionTemplate.executeWithoutResult(transactionStatus -> {

        });
        /*通过aop加入对应的事件属性，为每一种类型的，自定义回滚方法和入参*/
        applicationEventPublisher.publishEvent(null);
    }

    /**
     * 发生回滚执行的事件,可以设置回滚操作
     * 通过aop注册执行方法相关的事件，自定义增改相关的事件，增会传入id，回滚会删除，
     * 更新会回滚数据，查询需加入到原数据到threadLocal，用threadLocal中的数据进行回滚
     * 多数据源回滚，微服务回滚
     */
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void rollback(ApplicationEvent event){
        /*根据类型和方法确认的回滚方法，传入对应参数*/
    }

    /**
     * 数据双写，用于数据源切换，切读切写，需要数据对比支撑，并需要拦截异常
     * 一般来说使用2的次方扩容，不会使用一致性hash，从实用意义上来说不会使用
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void dataDoubleWrite(){

    }
}
