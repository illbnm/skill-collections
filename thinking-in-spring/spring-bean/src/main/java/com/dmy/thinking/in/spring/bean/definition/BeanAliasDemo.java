package com.dmy.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: dongmengyang
 * 验证bean的别名`
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
        Object bean = beanFactory.getBean("张三");
        Object user = beanFactory.getBean("user");
        System.out.println(bean.equals(user));
    }




}
