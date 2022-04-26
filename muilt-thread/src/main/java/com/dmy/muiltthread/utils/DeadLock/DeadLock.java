package com.dmy.muiltthread.utils.DeadLock;

/**
 * @Author: dongmengyang
 */
public class DeadLock {
    public static void main(String[] args) {
        Object resourceA = new Object();
        Object resourceB = new Object();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("线程" + Thread.currentThread() + "获取到了资源 resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread() + "正在等待获取资源 resourceB");
                    synchronized (resourceB) {
                        System.out.println("线程" + Thread.currentThread() + "获取到了资源 resourceB");
                    }

                }
            }
        });
        threadA.setName("thread A ");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB) {
                    System.out.println("线程" + Thread.currentThread() + "获取到了资源 resourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread() + "正在等待获取资源 resourceA");
                    synchronized (resourceA) {
                        System.out.println("线程" + Thread.currentThread() + "获取到了资源 resourceA");
                    }

                }
            }
        });
        threadB.setName("thread B ");
        threadA.start();
        threadB.start();

    }


}
