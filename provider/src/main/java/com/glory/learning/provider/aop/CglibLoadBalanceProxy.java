package com.glory.learning.provider.aop;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * cglib代理类
 *
 * @author Glory
 * @create 2020-04-11 23:58
 **/
@Slf4j
public class CglibLoadBalanceProxy implements MethodInterceptor {

    private Object target;

    public CglibLoadBalanceProxy(Object target) {
        this.target = target;
    }

    // 创建被代理的子类
    public Object getProxyObject() {
        //工具类
        Enhancer enhancer = new Enhancer();
        // 设置需要继承的类
        enhancer.setSuperclass(target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理类(被代理类的子类)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("[cglib-load-balance-proxy] proxy={}, method={}, args={}, methodProxy={}",
                proxy.getClass().getName(),
                method.getName(),
                Arrays.toString(args),
                methodProxy.getSignature().getName());
        // 反射方式调用性能低
        // method.invoke(target, args);
        return methodProxy.invoke(target, args);
    }
}
