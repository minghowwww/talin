package com.asianrapid.talin.common.domain.error;

import com.asianrapid.talin.common.domain.common.BasePojo;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName CommonError
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/2 0002
 * @Version V1.0
 **/
@Slf4j
public class CommonError extends BasePojo {
    //错误代码
    private String errorCode;

    //错误信息
    private String errorMessage;

    //显示项目
//    private String[] fields;

    public CommonError() {
    }

    public CommonError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

//    public CommonError(String errorCode, String errorMessage, String[] fields) {
//        this.errorCode = errorCode;
//        this.errorMessage = errorMessage;
//        this.fields = fields;
//    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

//    public String[] getFields() {
//        return fields;
//    }
//
//    public void setFields(String[] fields) {
//        this.fields = fields;
//    }
}
