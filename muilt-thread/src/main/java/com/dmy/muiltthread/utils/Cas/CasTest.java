package com.dmy.muiltthread.utils.Cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * @Author: dongmengyang
 */
public class CasTest {
    public static AtomicInteger CasTest() {
        AtomicInteger counter = new AtomicInteger();
        counter.getAndAdd(10);
        return counter;
    }

    public static void main(String[] args) {

        System.out.println(CasTest());
    }


}
