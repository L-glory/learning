package com.glory.learning.consumer.spi;

import com.glory.learning.commons.rpc.RespDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

/**
 * Dubbo spi测试
 *
 * @author Glory
 * @create 2020-04-02 21:30
 **/
@Slf4j
public class DubboSpiTest {


    @Test
    public void invoke() {
        // step1: 初始化SPI加载器
        ExtensionLoader<UserService> extensionLoader = ExtensionLoader.getExtensionLoader(UserService.class);
        // step2: 加载SPI实现，根据META-INF/dubbo里边的配置key进行加载
        UserService ldapUserService = extensionLoader.getExtension("ldapUserServiceImpl");
        RespDTO<String> ladpResp = ldapUserService.login("Glory", "123456");
        log.info("[dubbo-spi-test] resp={}", ladpResp);
        UserService tokenUserService = extensionLoader.getExtension("tokenUserServiceImpl");
        RespDTO<String> tokenResp = tokenUserService.login("Glory", "123456");
        log.info("[dubbo-spi-test] resp={}", tokenResp);
    }

}
