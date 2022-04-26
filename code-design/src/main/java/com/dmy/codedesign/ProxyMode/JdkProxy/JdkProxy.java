package com.dmy.codedesign.ProxyMode.JdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: dongmengyang
 */
public class JdkProxy implements InvocationHandler {
    // 需要代理的对象
    private Object bean;

    public JdkProxy(Object bean) {
        this.bean = bean;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(), new Class[]{Person.class},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("doSomething")){
            System.out.println("早安doSomething~~~");
        }else if(methodName.equals("sleep")){
            System.out.println("晚安~~~");
        }
        return method.invoke(bean, args);
    }


    public static void main(String[] args) {
        Student student = new Student();
        JdkProxy proxy = new JdkProxy(student);
        proxy.getProxy();

    }
}
