package com.asianrapid.talin.common.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.common.helper.MessageSourceHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName TalinServiceException
 * @Author Nio
 * @Date 2019/8/5 0005
 * @Version V1.0
 **/
@Slf4j
@ControllerAdvice
@ResponseBody
public class TalinServiceExceptionHandler extends BaseExceptionHandler{

    public final static String MESSAGE_SAASSERVICEEXCEPTION = "exception.talinerviceexception"; //系统默认异常
    public final static String MESSAGE_HTTPMESSAGENOTREADABLEEXCEPTION = "exception.httpmessagenotreadableexception";
    public final static String MESSAGE_HTTPREQUESTMETHODNOTSUPPORTEDEXCEPTION = "exception.httprequestmethodnotsupportedexception";
    public final static String MESSAGE_EXCEPTION = "exception.exception";

    @Autowired
    private MessageSourceHelper messageSourceHelper;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TalinServiceException.class)
    public JSONObject handleSaaSServiceException(TalinServiceException e) {
        log.error("业务运行时异常", e);
        return getResponseEntity(e);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JSONObject handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数解析失败", e);
        return getResponseEntity(e, MESSAGE_HTTPMESSAGENOTREADABLEEXCEPTION);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JSONObject handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法", e);
        return getResponseEntity(e, MESSAGE_HTTPREQUESTMETHODNOTSUPPORTEDEXCEPTION);
    }

    /**
     * 500 - Internal Server CommonError
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public JSONObject handleException(Exception e) {
        log.error("服务运行异常", e);
        return getResponseEntity(e, MESSAGE_EXCEPTION);
    }

    /**
     * 根据各种异常构建 ResponseEntity 实体. 服务于以上各种异常
     * @param ex
     * @return
     */
    private JSONObject getResponseEntity(TalinServiceException ex) {
        JSONObject response = new JSONObject();
        response.put(SystemConst.RESPONSE_CODE_KEY, ex.getStringResponseCode());
        log.error( "ResponseCode: " + ex.getResponseCode());
        if (null != ex.getResponseMessage() && !"".equals(ex.getResponseMessage())) {
            response.put(SystemConst.RESPONSE_MSG_KEY, ex.getResponseMessage());
            log.error( "ResponseMessage: " + ex.getResponseMessage());
        } else {
            response.put(SystemConst.RESPONSE_MSG_KEY, messageSourceHelper.getMessage(MESSAGE_SAASSERVICEEXCEPTION));
            log.error( "ResponseMessage: " + messageSourceHelper.getMessage(MESSAGE_SAASSERVICEEXCEPTION));
        }
        if (ex.getExtMsg() != null && !"".equals(ex.getExtMsg())) {
            response.put(SystemConst.RESPONSE_PARAMS_KEY, ex.getExtMsg());
            log.error( "ResponseParams: " + ex.getExtMsg());
        }
        if (ex.getCause() != null) {
            String errorTrace = "";
            StackTraceElement[] trace = ex.getCause().getStackTrace();
            for (StackTraceElement s : trace) {
                errorTrace += "\tat " + s + "\r\n";
            }
            response.put(SystemConst.RESPONSE_STACKTRACE_KEY, errorTrace);
        }
        return response;
    }

    @Override
    protected JSONObject getResponseEntity(Exception ex, String messageCode) {
        JSONObject response = new JSONObject();
        response.put(SystemConst.RESPONSE_CODE_KEY, ResponseCodeEnum.ERROR.getCode());
        log.error( "ResponseCode: " + ResponseCodeEnum.ERROR);
        response.put(SystemConst.RESPONSE_MSG_KEY, messageSourceHelper.getMessage(messageCode));
        log.error( "ResponseMessage: " + messageSourceHelper.getMessage(messageCode));

        String errorTrace = "";
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            errorTrace += "\tat " + s + "\r\n";
        }
        response.put(SystemConst.RESPONSE_STACKTRACE_KEY, errorTrace);
        return response;
    }
}
