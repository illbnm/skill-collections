package com.dmy.thinking.in.spring.ioc.overview.dependency.injection;

import com.dmy.thinking.in.spring.ioc.overview.Repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 *
 * @Author: dongmengyang
 */
public class DepenDencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF\\dependency-injection-context.xml");
        UserRepository userRepository =(UserRepository) beanFactory.getBean("userRepository");
//        //依赖查找
//        System.out.println(userRepository.getBeanFactory());
//        System.out.println(beanFactory==userRepository.getBeanFactory());
//        //依赖注入
//        System.out.println(beanFactory.getBean(BeanFactory.class));
        ObjectFactory userObjectFactory = userRepository.getObjectFactory();
        System.out.println(userObjectFactory.getObject());
    }
}
