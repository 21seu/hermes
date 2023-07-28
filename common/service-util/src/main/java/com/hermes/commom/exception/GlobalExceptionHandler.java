package com.hermes.commom.exception;

import com.hermes.commom.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author fengtingjun
 * @date 2023/7/27 11:11
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(e);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result error(BusinessException e) {
        return Result.build(null, e);
    }

}
