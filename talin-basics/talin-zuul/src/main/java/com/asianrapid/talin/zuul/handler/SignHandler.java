package com.asianrapid.talin.zuul.handler;

import com.asianrapid.talin.common.utils.RequestUtil;
import com.asianrapid.talin.common.utils.SignUtil;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @ClassName SignHandler
 * @Description: 网关验签
 * @Author Nio
 * @Date 2019/9/11 0011
 * @Version V1.0
 **/
@Slf4j
public class SignHandler extends BaseHandler {

    public SignHandler(BaseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public Boolean execute(RequestContext ctx) {
        log.debug("-------------网关验签-------------");

        boolean flag = true;
        Map<String, String> verifyMap = SignUtil.toVerifyMap(ctx.getRequest().getParameterMap(), false);
        if (!SignUtil.verify(verifyMap)) {
            resultError(ctx, "ip:" + RequestUtil.getIpAddress(ctx.getRequest()) + ",Sign fail");
            flag = false;
        }

        if (flag) {
            return nextHandler.execute(ctx);
        }
        return false;
    }

    private void resultError(RequestContext ctx, String errorMsg) {
        ctx.setResponseStatusCode(401);
        // 网关响应为false 不会转发服务
        ctx.setSendZuulResponse(false);
        ctx.setResponseBody(errorMsg);
    }
}
