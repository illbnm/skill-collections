package com.dmy.muiltthread.utils.Dcl;

/**
 * @Author: dongmengyang
 */
public class DoubleCheckLockTest {
    private static volatile Object instance;

    public Object getSingletonObj() {
        if (instance == null) {
            synchronized (DoubleCheckLockTest.class) {
                if (instance == null) {
                    instance = new Object();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {

    }


}
