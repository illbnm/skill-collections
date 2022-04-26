package com.dmy.codedesign.ProxyMode.CglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: dongmengyang
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    private Object bean;

    public CglibProxy(Object bean) {
        this.bean = bean;
    }

    public Object getProxy() {
        //设置需要创建子类的类
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //实现MethodInterceptor接口方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("doSomething")) {
            System.out.println("早安doSomething~~~");
        } else if (methodName.equals("sleep")) {
            System.out.println("晚安~~~");
        }

        //调用原bean的方法
        return method.invoke(bean, args);
    }

    public static void main(String[] args) {
        Order order = new Order("zs", 123L);
        CglibProxy proxy = new CglibProxy(order);
        Order orderProxy = (Order) proxy.getProxy();
        orderProxy.doSomething();

    }
}
