package com.roy.handle;

import com.roy.entity.Result;
import com.roy.exception.MyException;
import com.roy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ldj on 2017/6/29.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        if(e instanceof MyException) {
            MyException me = (MyException)e;
            return ResultUtil.error(me.getCode(),me.getMessage());
        }
        logger.error("系统异常 {}", e);
        return ResultUtil.error(-1,"未知异常: " + e);
    }
}
