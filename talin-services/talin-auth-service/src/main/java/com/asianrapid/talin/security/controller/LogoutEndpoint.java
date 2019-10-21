package com.asianrapid.talin.security.controller;

import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.exception.TalinServiceException;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName LogoutEndpoint
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/20 0020
 * @Version V1.0
 **/
@RestController
public class LogoutEndpoint extends BaseController {
    @Resource
    private ConsumerTokenServices consumerTokenServices;

    @DeleteMapping(value = "/user/logout", consumes = MediaType.ALL_VALUE + ";charset=utf-8", produces = MediaType.ALL_VALUE + ";charset=utf-8")
    public BaseResponse logout(@RequestHeader(value = "Authorization", required = true) String accessToken){
        if (!accessToken.contains(SystemConst.BLANK_SPACE)) {
            accessToken = accessToken.substring(accessToken.indexOf("Bearer") + 6);
        } else {
            accessToken = accessToken.substring(accessToken.indexOf(SystemConst.BLANK_SPACE) + 1);
        }
        if (consumerTokenServices.revokeToken(accessToken)) {
            return BaseResponse.ok();
        }
        throw new TalinServiceException(SystemConst.ERROR_ISFLASE, "consumerTokenServices.revokeToken");
    }
}

