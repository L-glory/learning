package com.glory.learning.provider.aop;

import com.glory.learning.commons.rpc.RespDTO;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

class LoadBalanceProxyTest {

    @Test
    public void jdkProxy() {
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 代理类加载器
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        // 被代理对象实例
        FirewallLoadBalance balance = new FirewallLoadBalance();
        // 被代理接口，这是JDK代理必要条件
        Class<?>[] interfaces = balance.getClass().getInterfaces();
        // 代理逻辑
        JdkLoadBalanceProxy balanceProxy = new JdkLoadBalanceProxy(balance);
        // 动态生成的代理对象：继承Proxy，实现"被代理对象"的接口
        LoadBalance proxy = (LoadBalance) Proxy.newProxyInstance(loader, interfaces, balanceProxy);
        RespDTO<Host> target = proxy.getTarget("/v2/api/session");
        System.out.println(target);
    }

    @Test
    public void cglibProxy() {
        // 被代理对象实例
        ServerLoadBalance balance = new ServerLoadBalance();
        // 代理逻辑
        CglibLoadBalanceProxy balanceProxy = new CglibLoadBalanceProxy(balance);
        // 创建代理对象
        LoadBalance proxy = (LoadBalance) balanceProxy.getProxyObject();
        RespDTO<Host> resp = proxy.getTarget("/v1/glory/api/session");
        System.out.println(resp);
    }
}