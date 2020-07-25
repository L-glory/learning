package com.glory.learning.provider.command;

import com.netflix.hystrix.*;

/**
 * 返回一个数据的command
 * @author Glory
 * @create 2020-05-30 22:19
 **/
public class HelloCommand extends HystrixCommand<String> {


    public HelloCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("helloServiceGroup"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("hello-response"))
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("hello-thread-pool"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
    }


    @Override
    protected String run() throws Exception {
        return "Service: Glory";
    }
}
