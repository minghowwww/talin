package com.asianrapid.talin.common.domain.common;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @ClassName CommonCondition
 * @Description: 共通查询条件Condition，包括map传值和对象传值
 * @Author Nio
 * @Date 2019/8/1 0001
 * @Version V1.0
 **/
public class CommonCondition extends BasePojo {

    private static final long serialVersionUID = -9207687950367376626L;

    /*
     * json String传值params
     */
    protected String params;

    /*
     * map传值Condition
     */
    protected Map<String, Object> mapCondition = null;

    /*
     * object传值Condition
     */
    protected JSONObject objectCondition = null;

    /**
     * @Description:无查询条件构造器
     */
    public CommonCondition() {
        super();
    }

    /**
     * @Description:条件map构造器
     */
    public CommonCondition(String json) {
        this.params = "params=" + json;
    }

    /**
     * @Description:条件对象构造器
     */
    public <T> CommonCondition(Class<T> bean, String json) {
        this.objectCondition = (JSONObject) JSONObject.parseObject(json).toJavaObject(bean);
    }

//	public static void main(String[] args) throws Exception {
//		String json = "{\"feeId\":\"1\",\"feeCode\":\"001\",\"status\":\"删除\"}";
//		CommonCondition financeCondition = CommonCondition.createObjectCondition(FeeRule.class, json);
//		System.out.println(financeCondition.hashCode());
//		CommonCondition mapCondition = CommonCondition.createMapCondition(json);
//		System.out.println(mapCondition.hashCode());
//	}

    /**
     * @return the mapCondition
     */
    public Map<String, Object> getMapCondition() {
        return mapCondition;
    }

    /**
     * @param mapCondition the mapCondition to set
     */
    public void setMapCondition(Map<String, Object> mapCondition) {
        this.mapCondition = mapCondition;
    }

    /**
     * @return the objectCondition
     */
    public JSONObject getObjectCondition() {
        return objectCondition;
    }

    /**
     * @param objectCondition the objectCondition to set
     */
    public void setObjectCondition(JSONObject objectCondition) {
        this.objectCondition = objectCondition;
    }

    public String getStringParams() {
        return params;
    }

    public JSONObject getJsonParams() {
        return JSONObject.parseObject(params);
    }


//    public UserInfo getUserInfo() {
//        return JSONObject.parseObject(params).getObject(SystemConst.SESSION_USERINFO_KEY, UserInfo.class);
//    }

    public void setParams(String params) {
        this.params = params;
    }
}
