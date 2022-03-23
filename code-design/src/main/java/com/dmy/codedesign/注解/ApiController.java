package com.dmy.codedesign.注解;

import com.alibaba.fastjson.JSON;
import com.dmy.codedesign.注解.Dto.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.Thread.sleep;


/**
 * @Author: dongmengyang
 */
@Controller
@RequestMapping("/api")
public class ApiController {
    @PostMapping("/run1")
    @ApiLog
    @ResponseBody
    public String getInfo(@RequestBody Request request) {
        return "tests";
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setOrderId(4);
        String string = JSON.toJSONString(request);
        System.out.println(string);
    }
}
