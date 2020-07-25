package com.glory.learning.provider.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * 延迟响应
 *
 * @author Glory
 * @create 2020-05-29 20:19
 **/
@Service
public class DelayHelloService {

    @HystrixCommand(fallbackMethod = "defaultFallback")
    public String hello(String saySomething) {
        return "glory";
    }

    public String defaultFallback(String saySomething) {
        return "fallback: DefaultName";
    }
}
