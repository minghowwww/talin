package com.asianrapid.talin.services.pay.template.unionpay;

import com.unionpay.acp.sdk.LogUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName AliVerifySignature
 * @Description: TODO
 * @Author Nio
 * @Date 2019/9/7 0007
 * @Version V1.0
 **/
public class AliVerifySignature {

    public static Map<String, String> verifySignature (HttpServletRequest req) {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = req.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            params.put(name, valueStr);
        }
        LogUtil.printRequestLog(params);
        return params;
    }
}
