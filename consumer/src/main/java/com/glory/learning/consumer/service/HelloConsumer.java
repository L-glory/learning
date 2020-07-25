package com.glory.learning.consumer.service;

import com.glory.learning.commons.api.HelloService;
import com.glory.learning.commons.rpc.RespDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * hello consumer demo
 *
 * @author Glory
 * @create 2020-03-31 21:33
 **/
@Service
@Slf4j
public class HelloConsumer {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    public String hello(String msg) {
        //log.info("[hello-consumer] say what={}", msg);
        RespDTO<String> resp = helloService.hello(msg);
        //log.info("[hello-consumer] resp what={}", resp);
        return resp.getData();
    }


}
