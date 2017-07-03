package com.roy.exception;

import com.roy.enums.ResultEnum;

/**
 * Created by ldj on 2017/6/29.
 */
public class MyException extends RuntimeException{

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
