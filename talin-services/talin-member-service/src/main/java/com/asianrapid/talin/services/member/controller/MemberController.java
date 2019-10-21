package com.asianrapid.talin.services.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.api.client.member.MemberServiceApi;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dbo.Customer;
import com.asianrapid.talin.common.domain.dto.weixin.AppEntity;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.services.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName MemberController
 * @Author Nio
 * @Date 2019/8/1 0001
 * @Version V1.0
 **/
@Api(tags = "会员服务接口")
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController implements MemberServiceApi{

    private final MemberService memberService;

    @Autowired
    public MemberController( MemberService memberService) {
        this.memberService = memberService;
    }

    @ApiOperation(value = "获取app信息", notes = "获取app信息")
    @PostMapping("/memberToWeixin")
    @Override
    public BaseResponse<AppEntity> getAppInfo() {
       return memberService.testWeixin();
    }

    @GetMapping("/test")
    @Override
    public AppEntity test() {
        return null;
    }

    @PostMapping("/insertCustomer")
    @Override
    public BaseResponse insertCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName("大傻");
        customer.setRegistDate(new Date());
        customer.setUpdateDate(new Date());
        customer.setTel("15941112191");
        try {
            memberService.insertCustomer(customer);
        } catch (Exception e) {
            throw new TalinServiceException("新增客户失败");
        }

        return BaseResponse.ok();
    }
}
