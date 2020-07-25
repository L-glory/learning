package com.glory.learning.consumer.spi;

import com.glory.learning.commons.rpc.RespDTO;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * 用户服务
 *
 * @author Glory
 * @create 2020-04-02 21:06
 **/
@SPI
public interface UserService {

    /**
     * 用户登录接口
     * @param name          用户名
     * @param password      MD5哈希处理的密码串
     * @return
     */
    @Adaptive
    RespDTO<String> login(final String name, final String password);
}
