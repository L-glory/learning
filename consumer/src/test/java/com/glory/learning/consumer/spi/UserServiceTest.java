package com.glory.learning.consumer.spi;

import com.glory.learning.commons.rpc.RespDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.ServiceLoader;

@Slf4j
class UserServiceTest {

    @Test
    void login() {
        ServiceLoader<UserService> serviceLoader = ServiceLoader.load(UserService.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(userService -> {
            RespDTO<String> resp = userService.login("glory", "123456");
            log.info("[spi-test] resp={}", resp);
        });
    }

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.forEach((key, val) -> {
            System.out.println(key + "=" + val);
        });
    }
}