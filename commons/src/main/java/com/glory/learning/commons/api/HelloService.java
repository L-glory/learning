package com.glory.learning.commons.api;

import com.glory.learning.commons.rpc.RespDTO;

/**
 * dubbo demo api
 *
 * @author Glory
 * @create 2020-03-31 21:12
 **/
public interface HelloService {

    RespDTO<String> hello(String saySomething);
}
