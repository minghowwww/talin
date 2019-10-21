package com.asianrapid.talin.zuul.handler;

import com.netflix.zuul.context.RequestContext;
import lombok.Data;

/**
 * @ClassName BaseHandler
 * @Description: 基础责任链抽象类
 * @Author Nio
 * @Date 2019/9/11 0011
 * @Version V1.0
 **/
@Data
public abstract class BaseHandler {

    protected BaseHandler nextHandler;

    public abstract Boolean execute(RequestContext ctx);
}
