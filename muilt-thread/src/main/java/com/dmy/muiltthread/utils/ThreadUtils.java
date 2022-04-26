package com.dmy.muiltthread.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.SecureUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.File;
import java.util.ArrayList;
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
        ArrayList<String> test = new ArrayList<>();
        test.stream().forEach(item -> {
        });


    }


    public static void main(String[] args) {
        String init = "0000000000000000";

        ArrayList<String> temp = new ArrayList<>();
        File md5 = new File("E:\\file\\md5.txt");
        for (int i = 0; i < 100000000; i++) {

            String encode = SecureUtil.md5(init);
            System.out.println("num:" + i + "   md5:" + encode);
            temp.add(encode + "\r");
            if (temp.size() > 20000000) {
                long s = System.currentTimeMillis();
                FileUtil.appendLines(temp, md5, "UTF-8");
                temp.clear();
                System.out.println(System.currentTimeMillis() - s);
            }
            init = encode;
        }
    }


}
