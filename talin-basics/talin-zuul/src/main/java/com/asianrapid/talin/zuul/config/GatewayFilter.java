package com.asianrapid.talin.zuul.config;

import com.asianrapid.talin.common.utils.RedisUtil;
import com.asianrapid.talin.zuul.handler.BlackListHandler;
import com.asianrapid.talin.zuul.handler.XssHandler;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName GatewayFilter
 * @Author Nio
 * @Date 2019/9/11 0011
 * @Version V1.0
 **/
@Component
public class GatewayFilter extends ZuulFilter {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        XssHandler xssHandler = new XssHandler();
//        SignHandler signHandler = new SignHandler(xssHandler);
        BlackListHandler blackListHandler = new BlackListHandler(xssHandler, redisUtil);

        RequestContext ctx = RequestContext.getCurrentContext();
        return blackListHandler.execute(ctx);
    }
}
