package com.glory.learning.provider.aop;

import com.glory.learning.commons.rpc.RespDTO;

/**
 * 人物
 *
 * @author Glory
 * @create 2020-04-11 18:00
 **/
public interface LoadBalance {

    RespDTO<Host> getTarget(String path);
}
