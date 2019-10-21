package com.asianrapid.talin.common.service;

import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.common.exception.TalinValidateException;
import com.asianrapid.talin.common.utils.DateUtil;
import com.asianrapid.talin.common.utils.SecurityContextUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @ClassName BaseService
 * @Author Nio
 * @Date 2019/8/22 0022
 * @Version V1.0
 **/
@Slf4j
public class BaseService {

    /**
     * info日志
     *
     * @param info 信息
     */
    protected void infoLog(String info) {
        log.info(DateUtil.getNewDate2String() + " info:（" + info + "）");
    }

    /**
     * error日志
     *
     * @param error 错误
     */
    protected void errorLog(String error) {
        log.error(DateUtil.getNewDate2String() + " error:（" + error + "）");
    }

    /**
     * error日志
     *
     * @param error     错误
     * @param throwable 异常
     */
    protected void errorLog(String error, Throwable throwable) {
        log.error(DateUtil.getNewDate2String() + " error:（" + error + "）", throwable);
    }

    /**
     * debug日志
     *
     * @param debug 调试
     */
    protected void debugLog(String debug) {
        log.debug(DateUtil.getNewDate2String() + " debug:（" + debug + "）");
    }

    /**
     * debug日志
     *
     * @param debug  调试
     * @param object 对象
     */
    protected void debugLog(String debug, Object object) {
        log.debug(DateUtil.getNewDate2String() + " debug:（" + debug + "）", object);
    }

    /**
     * 校验返回值是否有异常，有则抛出异常
     *
     * @param response
     */
    protected void checkFeignClientResponse(BaseResponse response) {
        if (ResponseCodeEnum.CHECK.getCode().equals(response.getCode())) {
            errorLog("code:" + response.getCode());
            errorLog("msg:" + response.getMsg());
            throw new TalinValidateException("error.servicevalidate", response.getMsg());// 校验异常返回异常信息
        } else if (!ResponseCodeEnum.OK.getCode().equals(response.getCode())) {
            errorLog("code:" + response.getCode());
            errorLog("msg:" + response.getMsg());
            throw new TalinServiceException("exception.operation");// 操作异常，请稍后重试！
        }
    }

    /**
     * 获取当前登陆用户id
     * @return
     */
    protected Integer getCurrentUserId() {
        //获取当前登陆用户
        return SecurityContextUtil.getCurrentUserId();
    }

    /**
     * 获取当前登陆用户信息
     * @return
     */
    protected Map<String, Object> getCurrentUser() {
        return SecurityContextUtil.getCurrentUser();
    }

}
