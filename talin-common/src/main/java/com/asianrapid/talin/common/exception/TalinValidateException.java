package com.asianrapid.talin.common.exception;

import com.asianrapid.talin.common.domain.error.CommonError;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ValidationException;

/**
 * @ClassName TalinValidateException
 * @Author Nio
 * @Date 2019/8/2 0002
 * @Version V1.0
 **/
@Slf4j
public class TalinValidateException extends ValidationException {
    private static final long serialVersionUID = 6450121080288563177L;
    /** 返回响应码：正常、错误、警告等 **/
    protected ResponseCodeEnum responseCode = ResponseCodeEnum.CHECK;

    /** 错误码，指需要在页面提示输入项错误的错误信息 **/
    private CommonError error;

    public TalinValidateException(CommonError error) {
        super("请求参数不符合要求");
        this.error = error;
    }

    public TalinValidateException() {
        super("请求参数不符合要求");
        this.error = TalinErrorFactory.createError(responseCode.getCode());
    }

    public TalinValidateException(String msgParams) {
        super("请求参数不符合要求");
        this.error = TalinErrorFactory.createError(responseCode.getCode(), msgParams);
    }

    public TalinValidateException(String errorMsgCode, String msgParams) {
        super("请求参数不符合要求");
        this.error = TalinErrorFactory.createError(errorMsgCode, msgParams);
    }

    public TalinValidateException(ResponseCodeEnum code) {
        super("请求参数不符合要求");
        this.error = TalinErrorFactory.createError(code.getCode());
        this.responseCode = code;
    }

    public TalinValidateException(ResponseCodeEnum code, String msgParams) {
        super("请求参数不符合要求");
        this.error = TalinErrorFactory.createError(code.getCode(), msgParams);
        this.responseCode = code;
    }

    public CommonError getError() {
        return this.error;
    }

    public void setError(CommonError error) {
        this.error = error;
    }

    public ResponseCodeEnum getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCodeEnum responseCode) {
        this.responseCode = responseCode;
    }

    public String getStringResponseCode() {
        return this.responseCode.getCode();
    }
}
