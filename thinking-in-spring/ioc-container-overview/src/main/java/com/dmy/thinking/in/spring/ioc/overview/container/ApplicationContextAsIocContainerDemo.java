package com.dmy.thinking.in.spring.ioc.overview.container;

import com.dmy.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Application context IoC 注解能力的
 * @Author: dongmengyang
 */
@Configuration
public class ApplicationContextAsIocContainerDemo {
    public static void main(String[] args) {
        //创建beanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //将当前类作为配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationContextAsIocContainerDemo.class);
        //启动流程:启动应用上下文
        context.refresh();
        getColleectBeansByType( context);
        //关闭
        context.close();

    }

    /**
     * 通过java 注解方式定义了一个bean
     * @return
     */
    @Bean
    public User user(){
        User user = new User();
        user.setName("bean");
        user.setId(1L);
        return user;
    }



    private static void getColleectBeansByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beans);
        }
    }


}
