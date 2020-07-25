package com.glory.learning.provider.service;

import com.glory.learning.commons.api.HelloService;
import com.glory.learning.commons.rpc.RespDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * dubbo demo spi
 *
 * @author Glory
 * @create 2020-03-31 21:26
 **/
@Service(version = "1.0.0", weight = 4)
//@Service(value = "HelloService") // 可以指定bean ID
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Resource(name = "testServer")
    private TestServer testServer;

    @Override
    public RespDTO<String> hello(String saySomething) {
        log.info("[hello-service] say waht? msg={}", saySomething);
        return RespDTO.ok("成功", "叫你妈呢");
    }
}
