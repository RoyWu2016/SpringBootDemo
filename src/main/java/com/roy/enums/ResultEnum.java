package com.roy.enums;

/**
 * Created by ldj on 2017/6/29.
 */
public enum ResultEnum {
    SUCCESS(0,"成功"),
    FAIL(1,"交易失败"),
    UNKNOW_ERROR(-1,"未知异常");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
