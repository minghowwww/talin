package com.asianrapid.talin.api.client.user;

import com.asianrapid.talin.api.failback.UserServiceFallback;
import com.asianrapid.talin.common.domain.User;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.common.CommonGrid;
import com.asianrapid.talin.common.domain.dbo.SysMenu;
import com.asianrapid.talin.common.domain.dmo.UserDetailDMO;
import com.asianrapid.talin.common.domain.dto.user.RegistDTO;
import com.asianrapid.talin.common.domain.dmo.UserListDMO;
import com.asianrapid.talin.common.domain.dto.user.UserListDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * @ClassName UserServiceApi
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@FeignClient(value = "app-asianrapid-auth", fallback = UserServiceFallback.class)
public interface UserServiceApi {

    /**
     * 获取当前用户信息
     * @param user
     * @return
     */
    @GetMapping("/user")
    Principal user(Principal user);

    /**
     * 用户注册
     * @param registDTO
     * @param result
     * @return
     */
    @PostMapping("/regist")
    BaseResponse<User> regist(@Valid @RequestBody RegistDTO registDTO, BindingResult result);

    /**
     * 根据用户id获取菜单权限
     * @param userId
     * @return
     */
    @GetMapping("/getMenusByUserId")
    BaseResponse<List<SysMenu>> getMenusByUserId(String userId);

    /**
     * 用户列表数据获取
     * @param userListDTO
     * @return
     */
    @GetMapping("/userManager/getUserList")
    BaseResponse<CommonGrid<UserListDMO>> getUserList(@Valid UserListDTO userListDTO, BindingResult result);

    /**
     * 创建用户
     * @param registDTO
     * @param result
     * @return
     */
    @PutMapping("/userManager/createUser")
    BaseResponse createUser(@Valid @RequestBody RegistDTO registDTO, BindingResult result);

    /**
     * 修改用户信息
     * @param registDTO
     * @param result
     * @return
     */
    @PostMapping("/userManager/updateUser")
    BaseResponse updateUser(@Valid @RequestBody RegistDTO registDTO, BindingResult result);

    /**
     * 查询用户详细信息
     * @param userId
     * @return
     */
    @GetMapping("/userManager/getUserDetail")
    BaseResponse<UserDetailDMO> getUserDetail(Long userId);

    /**
     * 重置用户密码
     * @param userId
     * @return
     */
    @PostMapping("/userManager/resetPassword")
    BaseResponse resetPassword(Long userId);

    /**
     * 停用账号
     * @param userId
     * @return
     */
    @PostMapping("/userManager/discontinueUse")
    BaseResponse discontinueUse(Long userId);
}
