package org.example;

import java.lang.annotation.*;

/**
 * 注解不支持继承
 */
@Target(ElementType.FIELD)/*作用域*/
@Retention(RetentionPolicy.RUNTIME)/*保留期*/
@Documented
@Inherited/*是否可继承*/
//@Repeatable({})
public @interface Annotation {
    @Native/*可用作代码生成*/
    String name = null;
}
