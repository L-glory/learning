package com.glory.learning.provider;

import com.glory.learning.provider.service.HelloServiceImpl;
import org.junit.jupiter.api.Test;

class InterfaceTestTest {

    @Test
    void superInterfaces() {
        Class<?>[] interfaces = HelloServiceImpl.class.getInterfaces();
        System.out.println("debug");
    }
}