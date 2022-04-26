package com.dmy.codedesign.ProxyMode.JdkProxy;

/**
 * @Author: dongmengyang
 */
public class Student implements Person{
    @Override
    public void doSomething() {
        System.out.println("学生起床了");
    }
}
