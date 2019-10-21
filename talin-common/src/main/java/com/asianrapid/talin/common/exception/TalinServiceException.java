package com.asianrapid.talin.common.exception;

import com.asianrapid.talin.common.domain.error.CommonError;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TalinServiceException
 * @Author Nio
 * @Date 2019/8/2 0002
 * @Version V1.0
 **/
@Slf4j
public class TalinServiceException extends ServiceException{

    /** 错误码，指需要在页面提示输入项错误的错误信息 **/
    private CommonError error;

    public TalinServiceException() {
        super();
    }

    public TalinServiceException(ResponseCodeEnum code) {
        super(code);
    }

    public TalinServiceException(String message) {
        super(message);
    }

    public TalinServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TalinServiceException(ResponseCodeEnum code, String message) {
        super(code, message);
    }

    public TalinServiceException(ResponseCodeEnum code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public TalinServiceException(ResponseCodeEnum code, String message, String... extMsg) {
        super(code, message, extMsg);
    }

    public TalinServiceException(ResponseCodeEnum code, String message, Throwable cause, String... extMsg) {
        super(code, message, cause, extMsg);
    }

    public TalinServiceException(String message, String... extMsg) {
        super(message, extMsg);
    }

    public TalinServiceException(String message, Throwable cause, String... extMsg) {
        super(message, cause, extMsg);
    }

    public TalinServiceException(CommonError error) {
        super(error.getErrorMessage());
        this.error = error;
    }

    public TalinServiceException(CommonError error, Throwable cause) {
        super(error.getErrorMessage(), cause);
        this.error = error;
    }

    public TalinServiceException(ResponseCodeEnum code, CommonError error) {
        super(code, error.getErrorMessage());
        this.error = error;
    }

    public TalinServiceException(ResponseCodeEnum code, CommonError error, Throwable cause) {
        super(code, error.getErrorMessage(), cause);
        this.error = error;
    }

    public TalinServiceException(ResponseCodeEnum code, CommonError error, String... extMsg) {
        super(code, error.getErrorMessage(), extMsg);
        this.error = error;
    }

    public TalinServiceException(ResponseCodeEnum code, CommonError error, Throwable cause, String... extMsg) {
        super(code, error.getErrorMessage(), cause, extMsg);
        this.error = error;
    }

    public TalinServiceException(CommonError error, String... extMsg) {
        super(error.getErrorMessage(), extMsg);
        this.error = error;
    }

    public TalinServiceException(CommonError error, Throwable cause, String... extMsg) {
        super(error.getErrorMessage(), cause, extMsg);
        this.error = error;
    }

    public CommonError getError() {
        return error;
    }

    public void setError(CommonError error) {
        this.error = error;
    }
}
