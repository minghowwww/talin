package com.asianrapid.talin.api.failback;

import com.asianrapid.talin.api.client.member.MemberServiceApi;
import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.weixin.AppEntity;
import org.springframework.stereotype.Component;

/**
 * @ClassName MemberServiceFallback
 * @Author Nio
 * @Date 2019/8/17 0017
 * @Version V1.0
 **/
@Component
public class MemberServiceFallback extends BaseController implements MemberServiceApi {
    private static final long serialVersionUID = 1625006709096879667L;

    @Override
    public BaseResponse<AppEntity> getAppInfo() {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, new AppEntity("500", "Member.fallback"));
    }

    @Override
    public AppEntity test() {
        return new AppEntity("500", "Member.fallback");
    }

    @Override
    public BaseResponse insertCustomer() {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK);
    }
}
