package com.dmy.codedesign.FactoryBean;

import com.dmy.codedesign.ProxyMode.JdkProxy.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: dongmengyang
 */
public class PersonFactorybean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
