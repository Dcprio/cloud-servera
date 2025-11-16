package com.xlc.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.Properties;

@RestController
public class CommonController {


    @GetMapping("/version")
    @SentinelResource(value = "version", blockHandler = "handleBlock")
    public String getVersion(){
        String ip="";
        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()){
            Object o = enumeration.nextElement();
            String property = properties.getProperty(String.valueOf(o));
            if(String.valueOf(o) !=null && String.valueOf(o).contains("ip")){
                ip = property;
            }
        }
        return "2025-11-16"+":"+ip;
    }

    // 限流触发时调用
    public String handleBlock(BlockException ex) {
        return "限流了，请稍后再试";
    }

}
