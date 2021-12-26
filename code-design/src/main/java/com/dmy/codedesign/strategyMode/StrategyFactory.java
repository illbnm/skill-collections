package com.dmy.codedesign.strategyMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Author: dongmengyang
 */
@Service
public class StrategyFactory {
    @Autowired
    private Map<String, Strategy> strategyMap;

    public Integer excute(String name, Integer value1, Integer value2) {
        return strategyMap.get(name).excute(value1, value2);
    }

    @PostConstruct
    public void init(){
        Integer add = excute("add", 1, 1);
        System.out.println(add);
    }


}
