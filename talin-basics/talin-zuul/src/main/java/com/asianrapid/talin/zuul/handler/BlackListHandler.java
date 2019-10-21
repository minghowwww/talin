package com.asianrapid.talin.zuul.handler;

import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.utils.RedisUtil;
import com.asianrapid.talin.common.utils.RequestUtil;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName BlackListHandler
 * @Description: ip黑名单验证
 * @Author Nio
 * @Date 2019/9/11 0011
 * @Version V1.0
 **/
@Slf4j
public class BlackListHandler extends BaseHandler {
    private RedisUtil redisUtil;

    public BlackListHandler(BaseHandler nextHandler, RedisUtil redisUtil) {
        this.nextHandler = nextHandler;
        this.redisUtil = redisUtil;
    }

    @Override
    public Boolean execute(RequestContext ctx) {
        log.debug("-------------ip黑名单验证-------------");

        Boolean flag = redisUtil.checkSet(SystemConst.BLACK_LIST_REDIS_KEY, RequestUtil.getIpAddress(ctx.getRequest()));

        if (flag) {
            return nextHandler.execute(ctx);
        }
        return false;
    }


}
