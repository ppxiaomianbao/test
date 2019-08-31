package com.concurrent.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: con_demo
 * @Package: com.concurrent.demo.annotation
 * @ClassName: Commend
 * @Author: limingxing
 * @Description: todo 不推荐做法
 * @Date: 2019/8/27 8:59
 * @Version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotCommend {
    String value() default "";
}
