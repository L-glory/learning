package com.glory.learning.consumer.spi;

import com.glory.learning.commons.rpc.RespDTO;

import java.util.UUID;

/**
 * @author Glory
 * @create 2020-04-02 21:07
 **/
public class LdapUserServiceImpl implements UserService {

    @Override
    public RespDTO<String> login(String name, String password) {
        return RespDTO.ok("Ldap Login Success", UUID.randomUUID().toString());
    }
}
