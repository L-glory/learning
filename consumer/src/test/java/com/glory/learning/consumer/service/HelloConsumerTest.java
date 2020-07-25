package com.glory.learning.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class HelloConsumerTest {

    @Resource
    private HelloConsumer helloConsumer;

    @Test
    void hello() throws InterruptedException {
        String resp = helloConsumer.hello("我草你妈");
        log.info("[hello-consumer-test] resp={}", resp);
        Thread.sleep(2000L);
    }
}