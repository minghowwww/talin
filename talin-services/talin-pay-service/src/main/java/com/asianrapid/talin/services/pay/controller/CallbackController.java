package com.asianrapid.talin.services.pay.controller;

import com.asianrapid.talin.services.pay.template.AbstractPayCallbackTemplate;
import com.asianrapid.talin.services.pay.template.factory.TemplateFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CallbackController
 * @Author Nio
 * @Date 2019/9/6 0006
 * @Version V1.0
 **/
@RequestMapping("/callback")
@RestController
public class CallbackController {

    private static final String UNION_PAY_CALLBACK_TEMPLATE = "unionPayCallbackTemplate";
    private static final String ALI_PAY_CALLBACK_TEMPLATE = "aliPayCallbackTemplate";
    private static final String ALI_PAY_SYNC_CALLBACK_TEMPLATE = "aliPaySyncCallbackTemplate";
    /**
     * 银联异步回调接口执行代码
     *
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/unionPayAsyncCallback")
    public String unionPayAsyncCallback(HttpServletRequest req, HttpServletResponse resp) {
        AbstractPayCallbackTemplate abstractPayCallbackTemplate = TemplateFactory
                .getPayCallbackTemplate(UNION_PAY_CALLBACK_TEMPLATE);
        return abstractPayCallbackTemplate.asyncCallBack(req, resp);
    }

    /**
     * 支付宝异步回调接口执行代码
     *
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/aliPayAsyncCallback")
    public String aliPayAsyncCallback(HttpServletRequest req, HttpServletResponse resp) {
        AbstractPayCallbackTemplate abstractPayCallbackTemplate = TemplateFactory
                .getPayCallbackTemplate(ALI_PAY_CALLBACK_TEMPLATE);
        return abstractPayCallbackTemplate.asyncCallBack(req, resp);
    }


    /**
     * 支付宝同步回调接口执行代码
     *
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/aliPaySyncCallback")
    public String aliPaySyncCallback(HttpServletRequest req, HttpServletResponse resp) {
        AbstractPayCallbackTemplate abstractPayCallbackTemplate = TemplateFactory
                .getPayCallbackTemplate(ALI_PAY_SYNC_CALLBACK_TEMPLATE);
        return abstractPayCallbackTemplate.asyncCallBack(req, resp);
    }
}
