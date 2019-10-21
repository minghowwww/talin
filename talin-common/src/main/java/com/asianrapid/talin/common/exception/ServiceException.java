package com.asianrapid.talin.common.exception;

import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ServiceException
 * @Author Nio
 * @Date 2019/8/2 0002
 * @Version V1.0
 **/
@Slf4j
public class ServiceException extends RuntimeException{

    /** 返回响应码：正常、错误、警告等 **/
    protected ResponseCodeEnum responseCode = ResponseCodeEnum.ERROR;

    /** 返回响应信息 **/
    protected String responseMessage;

    /** 扩展异常描述 **/
    protected String extMsg;

    public ServiceException() {
    }

    public ServiceException(ResponseCodeEnum code) {
        this.responseCode = code;
    }

    /**
     * SaaSException构造方法
     * @param message
     */
    public ServiceException(String message) {
        super(message);
        this.responseMessage = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.responseMessage = message;
    }

    public ServiceException(ResponseCodeEnum code, String message) {
        super(message);
        this.responseCode = code;
        this.responseMessage = message;
    }

    public ServiceException(ResponseCodeEnum code, String message, Throwable cause) {
        super(message, cause);
        this.responseCode = code;
        this.responseMessage = message;
    }

    public ServiceException(ResponseCodeEnum code, String message, String... extMsg) {
        super(message);
        this.responseCode = code;
        this.responseMessage = message;
        this.extMsg = buildExtMsg(extMsg);
    }

    public ServiceException(ResponseCodeEnum code, String message, Throwable cause, String... extMsg) {
        super(message, cause);
        this.responseCode = code;
        this.responseMessage = message;
        this.extMsg = buildExtMsg(extMsg);
    }

    public ServiceException(String message, String... extMsg) {
        super(message);
        this.responseMessage = message;
        this.extMsg = buildExtMsg(extMsg);
    }

    public ServiceException(String message, Throwable cause, String... extMsg) {
        super(message, cause);
        this.responseMessage = message;
        this.extMsg = buildExtMsg(extMsg);
    }

    private String buildExtMsg(String... extMsg) {
        StringBuilder builder = new StringBuilder(100);
        builder.append(this.responseMessage);
        if(null != extMsg){
            for(String ext : extMsg ){
                builder.append("[").append(ext).append("]");
            }
        }
        return builder.toString();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "," + extMsg;
    }

    public String getStringResponseCode() {
        return responseCode.getCode();
    }

    public ResponseCodeEnum getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCodeEnum responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getExtMsg() {
        return extMsg;
    }

    public void setExtMsg(String extMsg) {
        this.extMsg = extMsg;
    }
}
