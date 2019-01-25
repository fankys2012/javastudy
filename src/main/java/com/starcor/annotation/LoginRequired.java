package com.starcor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要登录验证的Controller的方法上使用此注解
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-26 15:37
 */
@Target({ElementType.METHOD,ElementType.TYPE}) //该注解修饰类中的方法
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
    /**
     * 登录验证注解
     * 该注解可以标记Controller 或 Controller 中的方法.
     * 如果Controller 有该标记,那么这个Controller下面所有的方法都会被过滤器
     * 进行验证
     * 如果Controller 没有有该标记,但Controller中的某个方法拥有该标记
     * 那么这个方法将被过滤器验证(其他没有被标记的不会被验证)
     *
     * 特别注意,如果一个Controller 被标记LoginRequired 需要验证
     *
     */
}
