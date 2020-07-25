package com.glory.learning.provider.aop;

import com.glory.learning.commons.rpc.RespDTO;

/**
 * 防火墙负载均衡
 *
 * @author Glory
 * @create 2020-04-11 18:45
 **/
public class FirewallLoadBalance implements LoadBalance {

    @Override
    public RespDTO<Host> getTarget(String path) {
        if (path == null || "".equals(path.trim())) {
            return RespDTO.badRequest("path参数错误");
        }

        if (path.contains("api")) {
            return RespDTO.ok("ok", new Host("192.168.0.110", 5544));
        }

        return RespDTO.ok("ok", new Host("192.168.0.120", 6633));
    }
}
