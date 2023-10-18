package com.springboot.forum.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示这个注解是用在method上的
@Target(ElementType.METHOD)
//这个声明的有效时长
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
//    登录的时候才可以访问
}
