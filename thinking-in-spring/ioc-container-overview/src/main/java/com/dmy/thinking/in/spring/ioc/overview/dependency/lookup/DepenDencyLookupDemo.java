package com.dmy.thinking.in.spring.ioc.overview.dependency.lookup;

import com.dmy.thinking.in.spring.ioc.overview.annotation.Super;
import com.dmy.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 通过名称的方式进行依赖查找
 *
 * @Author: dongmengyang
 */
public class DepenDencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF\\dependency-lookup-context.xml");
//        // 按照类型查找单个
//        getBeanByType(beanFactory);
//        // 按照类型查找集合
//        getColleectBeansByType(beanFactory);
//        // 按照名称实时查找
//        getBeanIntime(beanFactory);
//        // 按照名称延迟查找
//        getBeanInLazy(beanFactory);
        // 通过注解查找
        getBeanByAnnotation(beanFactory);
        
    }

    private static void getBeanByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beans = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(beans);
        }
    }

    private static void getColleectBeansByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beans);
        }
    }

    private static void getBeanByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    private static void getBeanIntime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }
    private static void getBeanInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找："+user);
    }
}
