package com.glory.learning.provider.aop;

import com.glory.learning.commons.rpc.RespDTO;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 服务器负载均衡
 * @author Glory
 * @create 2020-04-11 18:35
 **/
@EnableAspectJAutoProxy
public class ServerLoadBalance implements LoadBalance {

    @Override
    public RespDTO<Host> getTarget(String path) {
        if (path == null || "".equals(path.trim())) {
            return RespDTO.badRequest("path参数错误");
        }

        if (path.contains("glory")) {
            return RespDTO.ok("ok", new Host("192.168.0.99", 1216));
        }

        return RespDTO.ok("ok", new Host("192.168.0.88", 1182));
    }
}
