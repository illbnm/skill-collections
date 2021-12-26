package com.dmy.codedesign.strategyMode.Impl;

import com.dmy.codedesign.strategyMode.Strategy;
import org.springframework.stereotype.Component;

/**
 * @Author: dongmengyang
 */
@Component(value = "divide")
public class DivideStrategy implements Strategy {

    @Override
    public Integer excute(Integer value1, Integer value2) {
        return value1/value2;
    }
}
