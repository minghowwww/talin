package com.asianrapid.talin.common.domain.common;

import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName BaseResponse
 * @Description: restful共同返回实体
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -855119284922927310L;

    private String code;

    private String msg;

    private T data;

    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<T>(ResponseCodeEnum.OK.getCode(), SystemMessageConst.OPERATION_SUCCESS, data);
    }

    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<T>(ResponseCodeEnum.OK.getCode(), SystemMessageConst.OPERATION_SUCCESS, null);
    }

    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<T>(ResponseCodeEnum.ERROR.getCode(), message, null);
    }

    public static <T> BaseResponse<T> error(String message, T data) {
        return new BaseResponse<T>(ResponseCodeEnum.ERROR.getCode(), message, data);
    }

    public static <T> BaseResponse<T> validateError(String message) {
        return new BaseResponse<T>(ResponseCodeEnum.CHECK.getCode(), message, null);
    }

    public static <T> BaseResponse<T> validateError(String message, T data) {
        return new BaseResponse<T>(ResponseCodeEnum.CHECK.getCode(), message, data);
    }
}
