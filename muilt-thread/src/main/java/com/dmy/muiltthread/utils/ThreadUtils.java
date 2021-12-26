package com.dmy.muiltthread.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: dongmengyang
 */
public class ThreadUtils {
    public void init() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("order-check-es-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(1, 5,
                5L, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(),
                threadFactory);
    }


}
