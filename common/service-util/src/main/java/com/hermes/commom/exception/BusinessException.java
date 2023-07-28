package com.hermes.commom.exception;

import com.hermes.commom.constant.ResultEnum;
import lombok.Data;

/**
 * 自定义异常
 *
 * @author fengtingjun
 * @date 2023/7/27 11:20
 */
@Data
public class BusinessException extends RuntimeException {

    /**
     * 异常状态码
     */
    private Integer code;


    /**
     * 通过状态码和错误消息创建异常对象
     *
     * @param message
     * @param code
     * @return
     * @author fengtingjun
     * @date 2023/07/27
     */
    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }


    /**
     * 接收枚举类型对象
     *
     * @param resultEnum
     * @return
     * @author fengtingjun
     * @date 2023/07/27
     */
    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
