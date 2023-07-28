package com.hermes.commom.result;

import com.hermes.commom.constant.ResultEnum;
import com.hermes.commom.exception.BusinessException;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * 统一返回结果集对象
 *
 * @author fengtingjun
 * @date 2023/7/27 10:56
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -5091687920153518020L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 设置数据
     *
     * @param data       数据
     * @param resultEnum 结果枚举
     * @return {@link Result }<{@link T }>
     * @author fengtingjun
     * @date 2023/07/27
     */
    public static <T> Result<T> build(T data, ResultEnum resultEnum) {
        Result<T> result = new Result<>();
        if (Objects.nonNull(data)) {
            result.setData(data);
        }
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());

        return result;
    }

    /**
     * 重载：设置数据
     *
     * @param data      数据
     * @param exception 异常
     * @return {@link Result }<{@link T }>
     * @author fengtingjun
     * @date 2023/07/28
     */
    public static <T> Result<T> build(T data, BusinessException exception) {
        Result<T> result = new Result<>();
        result.setCode(exception.getCode());
        result.setMessage(exception.getMessage());

        return result;
    }

    /**
     * 成功
     *
     * @param data 数据
     * @return {@link Result }<{@link T }>
     * @author fengtingjun
     * @date 2023/07/27
     */
    public static <T> Result<T> success(T data) {
        return build(data, ResultEnum.SUCCESS);
    }

    /**
     * 失败
     *
     * @param data 数据
     * @return {@link Result }<{@link T }>
     * @author fengtingjun
     * @date 2023/07/27
     */
    public static <T> Result<T> fail(T data) {
        return build(data, ResultEnum.FAIL);
    }
}
