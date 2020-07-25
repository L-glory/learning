package com.glory.learning.provider.controller;

/**
 * 用户接口
 *
 * @author Glory
 * @create 2020-04-12 0:51
 **/

import com.glory.learning.commons.rpc.RespDTO;
import com.glory.learning.provider.service.DelayHelloService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

@RequestMapping(value = "/v1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestControllerAdvice
public class UserController {

    @Resource(name = "delayHelloService")
    private DelayHelloService delayHelloService;

    @GetMapping("/session/users/name")
    public RespDTO<String> getName() {
        delayHelloService.hello("what your name");
        return RespDTO.ok("ok", "Glory");
    }
}
