package com.glory.learning.provider.configure;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Glory
 * @create 2020-05-29 22:00
 **/
@SpringBootConfiguration
@EnableAspectJAutoProxy
public class AppConfigure {

    @Bean
    public HystrixCommandAspect hystrixCommandAspect() {
        return new HystrixCommandAspect();
    }

}
