package com.dmy.codedesign.ProxyMode.CglibProxy;

import lombok.Data;

/**
 * @Author: dongmengyang
 */
@Data
public  class Order {
    private  String name ;

    private Long orderId;

    public Order() {
    }

    public Order(String name, Long orderId) {
        this.name = name;
        this.orderId = orderId;
    }

    public void  doSomething(){
        System.out.println("name:"+name+"orderId:"+orderId);
    }
}
