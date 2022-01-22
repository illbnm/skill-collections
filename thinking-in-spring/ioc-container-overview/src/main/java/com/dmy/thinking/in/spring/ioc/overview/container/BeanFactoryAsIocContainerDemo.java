package com.dmy.thinking.in.spring.ioc.overview.container;

import com.dmy.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Ioc容器
 * @Author: dongmengyang
 */
public class IocContainerDemo {
    public static void main(String[] args) {
        //创建beanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //xml 配置的路径
        String location = "META-INF\\dependency-lookup-context.xml";
        //加载资源
        int definitions = reader.loadBeanDefinitions(location);
        System.out.println(definitions);
        //依赖查找集合对象
        getColleectBeansByType(beanFactory);
    }

    private static void getColleectBeansByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beans);
        }
    }
}
