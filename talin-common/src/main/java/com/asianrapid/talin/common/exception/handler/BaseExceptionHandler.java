package com.asianrapid.talin.common.exception.handler;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.domain.error.CommonError;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import com.asianrapid.talin.common.exception.TalinValidateException;
import com.asianrapid.talin.common.helper.MessageSourceHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName BaseExceptionHandler
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/5 0005
 * @Version V1.0
 **/
@Slf4j
public abstract class BaseExceptionHandler {
    public final static String MESSAGE_SAASVALIDATEEXCEPTION = "exception.saasvalidateexception"; //SaaS系统检验异常

    @Autowired
    private MessageSourceHelper messageSourceHelper;

    protected JSONObject getResponseEntity(Exception ex, String messageCode) {
        JSONObject response = new JSONObject();
        response.put(SystemConst.RESPONSE_CODE_KEY, ResponseCodeEnum.ERROR.getCode());
        log.error( "ResponseCode: " + ResponseCodeEnum.ERROR);
        response.put(SystemConst.RESPONSE_MSG_KEY, messageSourceHelper.getMessage(messageCode));
        log.error( "ResponseMessage" + messageSourceHelper.getMessage(messageCode));
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(TalinValidateException.class)
    public JSONObject handleSaaSValidateErrorException(TalinValidateException e) {
        log.error("参数检查异常", e);
        return getResponseEntity(e);
    }

    /**
     * 根据各种异常构建 ResponseEntity 实体. 服务于以上各种异常
     * @param ex
     * @return
     */
    private JSONObject getResponseEntity(TalinValidateException ex) {
        JSONObject response = new JSONObject();
        response.put(SystemConst.RESPONSE_CODE_KEY, ex.getStringResponseCode());
        log.error( "ResponseCode: " + ex.getResponseCode());
        CommonError error = ex.getError();
        buildResponse(response, error, messageSourceHelper.getMessage(MESSAGE_SAASVALIDATEEXCEPTION));
        return response;
    }

    protected void buildResponse(JSONObject response, CommonError error, String responseMessage) {
        if (error != null && error.getErrorMessage() != null && !"".equals(error.getErrorMessage())) {
            response.put(SystemConst.RESPONSE_MSG_KEY, error.getErrorMessage());
            log.error( "ResponseMessage: " + error.getErrorMessage());
//            if (error.getFields() != null && error.getFields().length > 0) {
//                log.error("Fields [" + error.getFields() + "]");
//                response.put(SystemConst.RESPONSE_FIELDS_KEY, error.getFields());
//            }
        } else {
            response.put(SystemConst.RESPONSE_MSG_KEY, responseMessage);
            log.error( "ResponseMessage: " + responseMessage);
        }
    }
}
