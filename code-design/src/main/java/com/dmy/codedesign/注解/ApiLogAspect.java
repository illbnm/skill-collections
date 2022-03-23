package com.dmy.codedesign.注解;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Author: dongmengyang
 */
@Aspect
@Component
@Slf4j
public class ApiLogAspect {

    @Around(value = "@annotation(ApiLog)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法的参数列表
        Object[] args = joinPoint.getArgs();
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取参数类型数组
        Class[] paramTypeArray = methodSignature.getParameterTypes();
        long start = System.currentTimeMillis();
        log.info("method:{},args:{},start:{}",methodSignature.getName(),args,start);
        Object result = joinPoint.proceed(args);
        log.info("返回参数,res:{},耗时:{}", JSON.toJSONString(result), System.currentTimeMillis()-start);
        return result;
    }

}
