package com.glory.learning.commons.rpc;

/**
 * 公共静态变量
 *
 * @author Glory
 * @create 2020-03-31 21:19
 **/
public enum RespCode {

    OK(20000, "OK"),
    BAD_REQUEST(40000, "请求参数异常"),
    ERROR(50000, "服务异常");

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
