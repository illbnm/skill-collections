package com.dmy.thinking.in.spring.bean.definition;

import com.dmy.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Author: dongmengyang
 */
public class BeanDefinitionCreateDemo {

    public static void main(String[] args) {
        //1.  通过BeanDefinitionBuid创建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",95027);
        beanDefinitionBuilder.addPropertyValue("name","张三");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition 并非bean的终态 可自定义修改

        // 2. 使用AbstractBeanDefinition 进行创建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues =  new MutablePropertyValues();
        propertyValues.addPropertyValue("id",95027);
        propertyValues.addPropertyValue("name","张三");
        genericBeanDefinition.setPropertyValues(propertyValues);


        System.out.println();


    }
}
