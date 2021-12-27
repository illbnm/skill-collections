package com.dmy.thinking.in.spring.ioc.overview.domain;

import com.dmy.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @Author: dongmengyang
 */
@Super
public class SuperUser extends User {

    public String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                '}';
    }
}
