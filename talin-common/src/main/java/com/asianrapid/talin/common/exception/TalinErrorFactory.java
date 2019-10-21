package com.asianrapid.talin.common.exception;

import com.asianrapid.talin.common.domain.error.CommonError;
import org.springframework.stereotype.Component;

@Component
public class TalinErrorFactory {


    private static TalinErrorFactory saaSErrorFactory = new TalinErrorFactory();


    public static CommonError createError(String errorMsgCode) {
        return new CommonError(errorMsgCode, null);
    }

    public static CommonError createError(String errorMsgCode, String msg) {
        return new CommonError(errorMsgCode, msg);
    }

}
