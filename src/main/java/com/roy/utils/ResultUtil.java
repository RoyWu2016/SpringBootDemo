package com.roy.utils;

import com.roy.entity.Result;

/**
 * Created by ldj on 2017/6/29.
 */
public class ResultUtil {

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(data);

        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}
