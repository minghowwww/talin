package com.asianrapid.talin.security.controller;

import com.asianrapid.talin.api.client.user.UserServiceApi;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.User;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.common.CommonGrid;
import com.asianrapid.talin.common.domain.dbo.SysMenu;
import com.asianrapid.talin.common.domain.dmo.UserDetailDMO;
import com.asianrapid.talin.common.domain.dmo.UserListDMO;
import com.asianrapid.talin.common.domain.dto.user.RegistDTO;
import com.asianrapid.talin.common.domain.dto.user.UserListDTO;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.security.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * @author Nio
 */
@Api(tags = "用户服务接口")
@Slf4j
@RestController
public class UserController extends BaseController implements UserServiceApi {

    private static final long serialVersionUID = 3409730164757194527L;

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "查询当前登陆用户信息接口", notes = "查询当前登陆用户信息接口")
    @GetMapping("/user")
    @Override
    public Principal user(Principal user) {
        return user;
    }

    @ApiOperation(value = "用户注册接口", notes = "用户注册接口")
    @Override
    public BaseResponse<User> regist(@Valid @RequestBody RegistDTO registDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return BaseResponse.validateError(result.getFieldError().getDefaultMessage());
            }
            return userService.regist(registDTO);
        } catch (Exception e) {
            errorLog("注册失败", e);
            throw new TalinServiceException("注册失败", e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "根据用户id获取菜单信息接口", notes = "根据用户id获取菜单信息接口")
    @Override
    public BaseResponse<List<SysMenu>> getMenusByUserId(String userId) {
        try {
            if (StringUtils.isEmpty(userId)) {

                return BaseResponse.validateError("用户名不能为空");
            }
            return userService.getMenusByUserId(userId);
        } catch (Exception e) {
            errorLog("根据用户id获取菜单信息失败", e);
            throw new TalinServiceException("根据用户id获取菜单信息失败", e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "用户列表数据获取", notes = "用户列表数据获取")
    @Override
    public BaseResponse<CommonGrid<UserListDMO>> getUserList(@Valid UserListDTO userListDTO, BindingResult result) {

        try {
            if (result.hasErrors()) {
                return BaseResponse.validateError(result.getFieldError().getDefaultMessage());
            }
            return userService.getUserList(userListDTO);
        } catch (Exception e) {
            errorLog("查询用户列表失败", e);
            throw new TalinServiceException("查询用户列表失败", e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "新建用户", notes = "新建用户")
    @Override
    public BaseResponse createUser(@Valid @RequestBody RegistDTO registDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return BaseResponse.validateError(result.getFieldError().getDefaultMessage());
            }
            return userService.createUser(registDTO);
        } catch (Exception e) {
            errorLog("创建用户失败", e);
            throw new TalinServiceException("创建用户失败", e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @Override
    public BaseResponse updateUser(@Valid RegistDTO registDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return BaseResponse.validateError(result.getFieldError().getDefaultMessage());
            }
            return userService.updateUser(registDTO);
        } catch (Exception e) {
            errorLog("修改用户信息失败", e);
            throw new TalinServiceException("修改用户信息失败", e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "查询用户详情", notes = "查询用户详情")
    @Override
    public BaseResponse<UserDetailDMO> getUserDetail(Long userId) {
        try {
            if (StringUtils.isEmpty(userId)) {
                return BaseResponse.validateError("用户id不能为空");
            }
            return userService.getUserDetail(userId);
        } catch (Exception e) {
            errorLog("查询用户详情失败", e);
            throw new TalinServiceException("查询用户详情失败", e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "重置密码", notes = "重置密码")
    @Override
    public BaseResponse resetPassword(Long userId) {
        try {
            return userService.resetPassword(userId);
        } catch (Exception e) {
            errorLog("重置密码失败", e);
            throw new TalinServiceException("重置密码失败", e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "停用账号", notes = "停用账号")
    @Override
    public BaseResponse discontinueUse(Long userId) {
        try {
            return userService.discontinueUse(userId);
        } catch (Exception e) {
            errorLog("停用账号失败", e);
            throw new TalinServiceException("停用账号失败", e);
        }
    }

}