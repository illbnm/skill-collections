package com.dmy.codedesign.AbstractFactory;

import java.lang.reflect.InvocationHandler;

/**
 * 抽象工厂代理类
 * @Author: dongmengyang
 */
public class JdkProxy {

    public static<T> T getProxy(Class<T> interfaceClass,DealSomething dealSomething) {
        InvocationHandler handler = new JDKInvocationHandler(dealSomething);

    }



}
