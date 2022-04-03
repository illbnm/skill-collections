package com.dmy.thinking.in.spring.bean.definition;

import com.alibaba.fastjson.JSON;
import com.dmy.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: dongmengyang
 * 基于注解注册BeanDefinition
 */
//3.通过@Import 进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        //创建beanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationBeanDefinitionDemo.class);
        context.refresh();
        // 注册configuration class（配置类）
        Config bean = context.getBean(Config.class);
        // 使用BeanDefinitionRegistry 进行注册
        injectByRegisterWithName(context,"api-user");

        injectByUtilNoName(context);

        // 依赖查找
        System.out.println("config类型bean："+context.getBeansOfType(Config.class));
        System.out.println("User类型bean："+context.getBeansOfType(User.class));
        //关闭spring应用上下文
        context.close();

    }
    // 使用命名方式BeanDefinitionRegistry 进行注册
    public static void injectByRegisterWithName(BeanDefinitionRegistry registry,String beanName){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        registry.registerBeanDefinition(beanName,builder.getBeanDefinition());
    }
    //使用非命名方式进行注册
    public static void injectByUtilNoName(BeanDefinitionRegistry registry){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(),registry);
    }


    //2.通过@Component进行导入
   @Component
    public static class Config {

        /**
         * 通过java 注解方式定义了一个bean
         *
         * @return
         */
        //1.通过@Bean 进行导入
        @Bean(name = "normer-user")
        public User user() {
            User user = new User();
            user.setName("bean");
            user.setId(1L);
            return user;
        }
    }


}
