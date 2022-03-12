package com.dmy.codedesign.AbstractFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: dongmengyang
 */
public class JDKInvocationHandler implements InvocationHandler {

    private DealSomething doSomething;

    public JDKInvocationHandler(DealSomething dealSomething) {
        this.doSomething = dealSomething;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return  null;
    }


}

 