package com.dmy.muiltthread.utils.Synchonized;

/**
 * @Author: dongmengyang
 */
public class SynchonizedTest {
    public static Integer i = 1;

    public static synchronized void syncMethod() {
        i++;
    }

    public static void syncCodeBlock() {
        synchronized (SynchonizedTest.class) {
            System.out.println();
        }
    }


    public static void main(String[] args) {
        syncMethod();
    }


}
