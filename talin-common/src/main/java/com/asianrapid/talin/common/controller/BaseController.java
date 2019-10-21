package com.asianrapid.talin.common.controller;

import com.asianrapid.talin.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @ClassName BaseController
 * @Author Nio
 * @Date 2019/8/2 0002
 * @Version V1.0
 **/
@Slf4j
public abstract class BaseController implements Serializable {
    private static final long serialVersionUID = 768992375948785970L;


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
        log.error(" error:（" + error + "）", throwable);
    }

    /**
     * debug日志
     *
     * @param debug 调试
     */
    protected void debugLog(String debug) {
        log.debug(" debug:（" + debug + "）");
    }

    /**
     * debug日志
     *
     * @param debug  调试
     * @param object 对象
     */
    protected void debugLog(String debug, Object object) {
        log.debug(" debug:（" + debug + "）", object);
    }
}
