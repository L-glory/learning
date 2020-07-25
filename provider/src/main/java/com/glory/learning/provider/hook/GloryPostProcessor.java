package com.glory.learning.provider.hook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Glory
 * @create 2020-06-30 20:14
 **/
//@Component
@Slf4j
public class GloryPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("[glory-test] before beanName={}", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("[glory-test] after beanName={}", beanName);
        return bean;
    }
}
