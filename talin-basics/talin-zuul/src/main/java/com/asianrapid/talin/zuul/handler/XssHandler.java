package com.asianrapid.talin.zuul.handler;

import com.netflix.zuul.context.RequestContext;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @ClassName XssHandler
 * @Description: 防Xss注入式攻击
 * @Author Nio
 * @Date 2019/9/11 0011
 * @Version V1.0
 **/
@NoArgsConstructor
@Slf4j
public class XssHandler extends BaseHandler{

    public XssHandler(BaseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public Boolean execute(RequestContext ctx) {
        log.debug("-------------防Xss注入式攻击-------------");
        Map<String, List<String>> stringListMap = filterParameters(ctx.getRequest(), ctx);
        ctx.setRequestQueryParams(stringListMap);
        return true;
    }

    /**
     * 过滤参数
     */
    private Map<String, List<String>> filterParameters(HttpServletRequest request, RequestContext ctx) {
        Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();
        if (requestQueryParams == null) {
            requestQueryParams = new HashMap<>();
        }
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            ArrayList<String> arrayList = new ArrayList<>();
            // 将参数转化为html参数 防止xss攻击
            arrayList.add(StringEscapeUtils.escapeHtml(value));
            requestQueryParams.put(name, arrayList);
        }
        return requestQueryParams;
    }
}
