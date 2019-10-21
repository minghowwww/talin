package com.asianrapid.talin.services.weixin.controller;

import com.asianrapid.talin.api.client.member.MemberServiceApi;
import com.asianrapid.talin.api.client.weixin.WeixinServiceApi;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.weixin.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WeixinController
 * @Author Nio
 * @Date 2019/8/1 0001
 * @Version V1.0
 **/
@Slf4j
@Api(tags = "微信服务接口")
@RequestMapping("/weixin")
@RestController
public class WeixinController implements WeixinServiceApi {

    private MemberServiceApi memberServiceApi;

    @Autowired
    public WeixinController(MemberServiceApi memberServiceApi) {
        this.memberServiceApi = memberServiceApi;
    }

    @Override
    public AppEntity testMember() {
        return memberServiceApi.test();
    }

    @ApiOperation(value = "微信基本信息查询接口", notes = "微信基本信息查询接口")
    @Override
    public BaseResponse<AppEntity> getAppInfo() {
        return BaseResponse.ok(new AppEntity("1", "wangminghao"));
    }

    @PostMapping("/fallback")
    public AppEntity fallback() {

        return new AppEntity("503", "fallback");
    }


}
