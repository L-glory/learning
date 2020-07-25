package com.glory.learning.provider.aop;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * LoadBalance动态代理 JDK原生实现
 *
 * @author Glory
 * @create 2020-04-11 18:40
 **/
@Slf4j
public class JdkLoadBalanceProxy implements InvocationHandler {

    private Object target;

    public JdkLoadBalanceProxy(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy       JDK生成的proxy代理类，继承了Proxy类，实现了target对象的Interfaces
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("[load-balance-proxy] proxy={}, method={}, args={}", proxy.getClass().getName(), method.getName(), Arrays.toString(args));
        return method.invoke(target, args);
    }
}
