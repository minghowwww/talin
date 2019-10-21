package com.asianrapid.talin.api.failback;

import com.asianrapid.talin.api.client.user.UserServiceApi;
import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.User;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.common.CommonGrid;
import com.asianrapid.talin.common.domain.dbo.SysMenu;
import com.asianrapid.talin.common.domain.dmo.UserDetailDMO;
import com.asianrapid.talin.common.domain.dmo.UserListDMO;
import com.asianrapid.talin.common.domain.dto.user.RegistDTO;
import com.asianrapid.talin.common.domain.dto.user.UserListDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * @ClassName UserServiceFallback
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@Component
public class UserServiceFallback extends BaseController implements UserServiceApi {
    @Override
    public Principal user(Principal user) {
        return null;
    }

    @Override
    public BaseResponse<User> regist(@Valid RegistDTO registDTO, BindingResult result) {

        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse<List<SysMenu>> getMenusByUserId(String userId) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse<CommonGrid<UserListDMO>> getUserList(UserListDTO userListDTO, BindingResult result) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse createUser(@Valid RegistDTO registDTO, BindingResult result) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse updateUser(@Valid RegistDTO registDTO, BindingResult result) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse<UserDetailDMO> getUserDetail(Long userId) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse resetPassword(Long userId) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse discontinueUse(Long userId) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }
}
