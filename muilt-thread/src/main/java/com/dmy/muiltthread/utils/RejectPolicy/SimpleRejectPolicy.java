package com.dmy.muiltthread.utils.RejectPolicy;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: dongmengyang
 */
public class SimpleRejectPolicy implements RejectedExecutionHandler {
    /**
     * 自定义拒绝策略
     *
     * @param r
     * @param executor
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        executor.getQueue();
    }
}
