package com.dmy.thinking.in.spring.bean.definition;

import com.dmy.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: dongmengyang
 * 基于注解注册BeanDefinition
 */
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        //创建beanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();
        Config bean = context.getBean(Config.class);

        //关闭spring应用上下文
        context.close();

    }
    @Component
    public static class Config {

        /**
         * 通过java 注解方式定义了一个bean
         *
         * @return
         */
        @Bean(name = "")
        public User user() {
            User user = new User();
            user.setName("bean");
            user.setId(1L);
            return user;
        }
    }


}
