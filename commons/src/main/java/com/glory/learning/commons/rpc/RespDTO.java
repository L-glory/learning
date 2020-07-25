package com.glory.learning.commons.rpc;

import lombok.Data;

import java.io.Serializable;

/**
 * PRC 响应DTO对象
 *
 * @author Glory
 * @create 2020-03-31 21:13
 **/
@Data
public class RespDTO<T> implements Serializable {

    private static final long serialVersionUID = 4168655728258887022L;

    private Integer code;

    private String msg;

    private T data;

    public static <T> RespDTO<T> ok(String msg, T data) {
        RespDTO<T> respDTO = new RespDTO<>();
        respDTO.setCode(RespCode.OK.getCode());
        respDTO.setMsg(msg);
        respDTO.setData(data);

        return respDTO;
    }

    public static <T> RespDTO<T> badRequest(String msg) {
        RespDTO<T> respDTO = new RespDTO<>();
        respDTO.setCode(RespCode.BAD_REQUEST.getCode());
        respDTO.setMsg(msg);
        respDTO.setData(null);

        return respDTO;
    }
}
