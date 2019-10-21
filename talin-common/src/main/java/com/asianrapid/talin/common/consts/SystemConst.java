package com.asianrapid.talin.common.consts;

import com.asianrapid.talin.common.enums.SystemModeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName SystemConst
 * @Author Nio
 * @Date 2019/8/1 0001
 * @Version V1.0
 **/
@Component
public class SystemConst {

    public static SystemModeEnum SYSTEM_MODE = SystemModeEnum.TEST;

    @Value("${system.mode:1}")
    public void setSystemMode(String mode) {
        switch (mode) {
            case "0":
                SYSTEM_MODE = SystemModeEnum.DEV;
                break;
            case "1":
                SYSTEM_MODE = SystemModeEnum.TEST;
                break;
            case "2":
                SYSTEM_MODE = SystemModeEnum.MASTER;
                break;
            default:
                SYSTEM_MODE = SystemModeEnum.TEST;
                break;
        }
    }

    public final static String HEAD_AUTHORIZATION_KEY = "authorization"; // HEAD中authorization
    public final static String HEAD_RSESSIONID_KEY = "rsessionid"; // HEAD中SESSIONID
    public final static String HEAD_SYSTEMCODE_KEY = "system-code"; // HEAD中系统识别号
    public final static String HEAD_USERNAME_KEY = "username"; // HEAD中用户账号

    /**
     * 通用RESPONSE的key
     */
    public final static String RESPONSE_DATA_KEY = "data"; // RESPONSE中返回代码的key
    public final static String RESPONSE_CODE_KEY = "code"; // RESPONSE中返回代码的key
    public final static String RESPONSE_MSG_KEY = "msg"; // RESPONSE中返回消息的key

    /**
     * 从Action返回到页面专用RESPONSE的key
     */
    public final static String RESPONSE_FIELDS_KEY = "fields"; // 从Action返回页面时RESPONSE中返回页面项目id数组的key
    /**
     * 从微服务返回时专用RESPONSE的key
     */
    public final static String RESPONSE_PARAMS_KEY = "params"; // 从微服务返回时RESPONSE中返回接口参数变量或扩展内容的key
    public final static String RESPONSE_STACKTRACE_KEY = "stackTrace"; // 从微服务返回时RESPONSE中返回异常内容的key

    /**
     * SESSION KEY
     */
    public final static String SESSION_USERINFO_KEY = "userInfo"; //用户信息在session中的key
    public final static String SESSION_BEFOREDATA_KEY = "beforeData"; //beforeData在session中的key

    /**
     * PARAMS KEY
     */
    public final static String PARAMS_ROUTE_KEY = "route"; //页面路径在请求参数中的key

    /**
     * 业务缓存数据中需要设置key的开头字符串
     */
    public final static String CACHE_AVOIDDUPLICATIONCLICK = "avoidDuplicationClick"; // 重复点击

    public final static String CACHE_STATUS = "Hash_Status_Action"; // 数据字典
    public final static String CACHE_CITYS = "Hash_Citys_Action"; // 城市

    public final static String CACHE_CITYAREAS = "Set_CityAreas_Service"; // 城市

    public final static String CACHE_USERMENUS = "Set_UserMenus_DAO"; // 个人用户系统菜单

    public final static String CACHE_TENANTS = "Set_Tenants_DAO"; // 花果山全部租车公司列表
    public final static String CACHE_TENANTSITES = "Set_TenantSites_DAO"; // 菩提租车公司全部门店列表
    public final static String CACHE_CITYTENANTSITES = "Set_CityTenantSites_Service"; // 城市租车公司门店列表
    public final static String CACHE_USERTENANTSITES = "Set_UserTenantSites_Service"; // 用户租车公司门店列表
    public final static String CACHE_USERTENANTSITESANDBRANCHES = "Set_UserTenantSitesAndBranches_Service"; // 用户租车公司门店列表(含服务点)
    public final static String CACHE_TENANTSITESHAREDSITES = "Set_SiteSharedTenantSites_Service"; // 门店对应共享租车公司门店列表(含服务点)
    public final static String CACHE_TENANTSERVICEBRANCHES = "Set_TenantServiceBranches_DAO"; // 门店服务点列表
    public final static String CACHE_TENANTENTERPRISES = "Set_TenantEnterprises_DAO"; // 租车公司企业客户列表

    public final static String CACHE_BRANDS = "Set_Brands_DAO"; // 全部品牌列表
    public final static String CACHE_SERIES = "Set_Series_DAO"; // 品牌车系列表
    public final static String CACHE_CARTYPES = "Set_CarTypes_DAO"; // 车系车型列表
    public final static String CACHE_CARTYPECOLORS = "Set_CarTypeColors_DAO"; // 车型颜色列表
    public final static String CACHE_TENANTSITECARTYPES = "Set_SiteCarTypes_Service"; // 门店车型列表
    public final static String CACHE_TENANTSITECARS = "Set_SiteCars_Service"; //门店车辆列表

    public static final String[] ALL_CACHE = {

            CACHE_STATUS,
            CACHE_CITYS,

            CACHE_CITYAREAS,

            CACHE_USERMENUS,

            CACHE_TENANTS,
            CACHE_TENANTSITES,
            CACHE_CITYTENANTSITES,
            CACHE_USERTENANTSITES,
            CACHE_USERTENANTSITESANDBRANCHES,
            CACHE_TENANTSITESHAREDSITES,
            CACHE_TENANTSERVICEBRANCHES,
            CACHE_TENANTENTERPRISES,

            CACHE_BRANDS,
            CACHE_SERIES,
            CACHE_CARTYPES,
            CACHE_CARTYPECOLORS,
            CACHE_TENANTSITECARTYPES,
            CACHE_TENANTSITECARS
    };

    /**
     * 后台检查重复点击间隔1秒
     */
    public final static long AVOIDDUPLICATIONCLICK_TIMEOUT = 1;

    /**
     * 允许上传文件大小
     */
    public final static long FILE_MAX_SIZE = 10000 * 500; // 5M
    /**
     * 允许批量上传文件个数
     */
    public final static int FILE_MAX = 10;

    /**
     * yesorno
     */
    public final static String YES = "Y";
    public final static String NO = "N";
    public final static String REQUEST_PARAM_NOT_NULL = "请求参数不能为空";
    public final static String PARAM_NOT_NULL = "参数不能为空";

    /**
     * 用户ID
     */
    public final static String USER_ID = "userId";

    /**
     * 操作者姓名
     */
    public final static String NAME = "name";
    /**
     * 操作者姓名
     */
    public final static String CREATED_USERNAME = "createdUsername";
    /**
     * 操作类型
     */
    public final static String OPERATION_TYPE = "type";
    /**
     * 操作名称
     */
    public final static String OPERATION_TYPE_NAME = "typeName";

    /**
     *
     */
    public static final String ERROR_ISEMPTY = "error.isempty";

    public static final String ERROR_ISBLANK = "error.isblank";

    public static final String ERROR_ISFLASE = "error.isfalse";

    /**
     * 查询条件分隔符
     */
    public static String SPLIT_CHAR = " ";

    /**
     * 关键词模糊匹配最大个数
     */
    public static final int PARAM_CONDITION_NUM = 10;

    public static final String TOKEN_KEY = "token";

    // -----------------------支付------------------------------

    public static final String PAY_RESULT_NAME = "result";
    public static final String PAY_RESULT_PAYCODE_201 = "201";
    public static final String PAY_RESULT_PAYCODE_200 = "200";
    /**
     * 已经支付成功状态
     */
    public static final Long PAY_STATUS_SUCCESS = 1L;
    /**
     * 返回银联通知成功
     */
    public static final String PAY_YINLIAN_RESULT_SUCCESS = "ok";
    /**
     * 返回银联失败通知
     */
    public static final String PAY_YINLIAN_RESULT_FAIL = "fail";

    /**
     * 返回银联通知成功
     */
    public static final String PAY_ALI_RESULT_SUCCESS = "success";
    /**
     * 返回银联失败通知
     */
    public static final String PAY_ALI_RESULT_FAIL = "fail";

    public static final String PAY_ALI_TRADE_FINISHED = "TRADE_FINISHED";
    public static final String PAY_ALI_TRADE_SUCCESS = "TRADE_SUCCESS";

    public static final String THIRD_PARTY_PAYMENT_USER_ID = "8";

    // -----------------------支付------------------------------

    // -----------------------消息队列------------------------------

    /**
     * 添加积分队列
     */
    public static final String INTEGRAL_DIC_QUEUE = "integral_queue";
    /**
     * 支付补偿队列
     */
    public static final String PAYMENT_COMPENSATE_QUEUE = "payment_compensate_queue";
    /**
     * 积分交换机
     */
    public static final String INTEGRAL_EXCHANGE_NAME = "integral_exchange_name";

    // -----------------------消息队列------------------------------

    /**
     * redis黑名单键
     */
    public static final String BLACK_LIST_REDIS_KEY = "black_list_redis_key";

    /**
     * 逗号
     */
    public static final String COMMA = ",";

    /**
     * 空格
     */
    public static final String BLANK_SPACE = " ";

    /**
     * 星号脱敏
     */
    public static final String ASTERISK_DESENSITIZATION = "*********";

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";
}

