package com.glory.learning.aop;

import com.glory.learning.obserabale.GloryOb;
import com.glory.learning.obserabale.IOb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Glory
 * @create 2020-07-31 20:15
 **/
public class JDKProxy implements InvocationHandler {

    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before execute");
        Object result = method.invoke(target, args);
        System.out.println("after execute");
        return result;
    }

    public static void main(String[] args) {
        GloryOb ob = new GloryOb();
        JDKProxy proxy = new JDKProxy(ob);
        IOb proxyOb = (IOb) Proxy.newProxyInstance(ob.getClass().getClassLoader(), ob.getClass().getInterfaces(), proxy);
        proxyOb.print();
    }
}
