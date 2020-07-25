package com.glory.learning.provider.aop;

import lombok.Data;

import java.io.Serializable;

/**
 * 目标主机
 *
 * @author Glory
 * @create 2020-04-11 18:33
 **/
@Data
public class Host implements Serializable {

    private static final long serialVersionUID = -8108475301734011832L;

    private String ip;
    private int port;

    public Host(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
