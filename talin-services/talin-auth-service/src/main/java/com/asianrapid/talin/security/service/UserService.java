package com.asianrapid.talin.security.service;

import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.domain.User;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.common.CommonGrid;
import com.asianrapid.talin.common.domain.dbo.SysMenu;
import com.asianrapid.talin.common.domain.dbo.UserRole;
import com.asianrapid.talin.common.domain.dmo.UserDetailDMO;
import com.asianrapid.talin.common.domain.dmo.UserListDMO;
import com.asianrapid.talin.common.domain.dto.user.RegistDTO;
import com.asianrapid.talin.common.domain.dto.user.UserListDTO;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.common.service.BaseService;
import com.asianrapid.talin.security.dao.MenuDao;
import com.asianrapid.talin.security.dao.UserDao;
import com.asianrapid.talin.security.dao.queryService.UserQueryService;
import com.asianrapid.talin.security.dao.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName UserService
 * @Description: 用户业务luojiceng
 * @Author Nio
 * @Date 2019/9/18 0018
 * @Version V1.0
 **/
@Service
public class UserService extends BaseService {
    private final UserDao userDao;
    private final UserQueryService userQueryService;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final MenuDao menuDao;

    @Autowired
    public UserService(UserDao userDao, UserQueryService userQueryService, PasswordEncoder bCryptPasswordEncoder, MenuDao menuDao) {
        this.userDao = userDao;
        this.userQueryService = userQueryService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.menuDao = menuDao;
    }

    @Transactional(rollbackFor = Exception.class)
    public BaseResponse<User> regist(RegistDTO registDTO) {
        User user = new User();
        user.setUsername(registDTO.getUsername());
        user.setEmail(registDTO.getEmail());
        user.setPhone(registDTO.getPhone());
        user.setPassword(bCryptPasswordEncoder.encode(registDTO.getPassword()));
        user.setIsManager(registDTO.getIsManager());
        user.setCreateBy(0);
        user.setCreateTime(new Date());
        user.setUpdateBy(0);
        user.setUpdateTime(new Date());

        User save = userDao.save(user);
        return BaseResponse.ok(save);
    }

    public BaseResponse<List<SysMenu>> getMenusByUserId(String userId) {
        debugLog("根据用户id获取菜单信息, 用户id:{}", userId);
        User user = userQueryService.findByUserId(userId);
        if (user.getIsManager() == 0) {
            return BaseResponse.error("该用户不是系统用户");
        }
        List<UserRole> authorities = user.getAuthorities();
        List<String> list = authorities.stream().map(v -> v.getRoleId().getMenuList()).collect(Collectors.toList());
        Optional<String> reduce = list.stream().map(v -> v.toString()).reduce(String::concat);
        reduce.orElseThrow(TalinServiceException::new);
        List<SysMenu> menus = new ArrayList<>();
        for (String str : reduce.get().split(SystemConst.COMMA)) {
            SysMenu menu = menuDao.findByMenuIdAndMenuRank(NumberUtils.parseNumber(str, Long.class), 1L);
            if (menu != null) {
                //查询子菜单
                List<SysMenu> children = menuDao.findByParentMenuId(menu.getMenuId());
                List<SysMenu> realChildren = children.stream().filter(v -> Arrays.asList(reduce.get().split(SystemConst.COMMA)).contains(String.valueOf(v.getMenuId()))).collect(Collectors.toList());
                menu.setChildren(realChildren);
                menus.add(menu);
            }
        }
        return BaseResponse.ok(menus);
    }

    public BaseResponse<CommonGrid<UserListDMO>> getUserList(UserListDTO userListDTO) {
        debugLog("获取用户列表数据参数:{}", userListDTO.toString());

        CommonGrid<UserListDMO> grid = userQueryService.findUserlist(userListDTO.getUsername(), Long.valueOf(userListDTO.getPage()) - 1, Long.valueOf(userListDTO.getSize()));
        return BaseResponse.ok(grid);
    }

    @Transactional(rollbackFor = Exception.class)
    public BaseResponse createUser(RegistDTO registDTO) {
        User user = new User();
        user.setUsername(registDTO.getUsername());
        user.setEmail(registDTO.getEmail());
        user.setPhone(registDTO.getPhone());
        user.setPassword(bCryptPasswordEncoder.encode(registDTO.getPassword()));
        user.setIsManager(registDTO.getIsManager());
        user.setCreateBy(getCurrentUserId());
        user.setCreateTime(new Date());
        user.setUpdateBy(getCurrentUserId());
        user.setUpdateTime(new Date());

        User save = userDao.save(user);
        return BaseResponse.ok(save);
    }

    @Transactional(rollbackFor = Exception.class)
    public BaseResponse updateUser(RegistDTO registDTO) {
        User user = new User();
        user.setUsername(registDTO.getUsername());
        user.setEmail(registDTO.getEmail());
        user.setPhone(registDTO.getPhone());
        user.setPassword(bCryptPasswordEncoder.encode(registDTO.getPassword()));
        user.setIsManager(registDTO.getIsManager());
        user.setUpdateBy(getCurrentUserId());
        user.setUpdateTime(new Date());

        User save = userDao.saveAndFlush(user);
        return BaseResponse.ok(save);
    }

    public BaseResponse<UserDetailDMO> getUserDetail(Long userId) {
        User user = userDao.findByIdAndIsDeleted(userId, 0L);
        UserDetailDMO userDetailDMO = new UserDetailDMO();

        userDetailDMO.setUsername(user.getUsername());
        userDetailDMO.setEmail(user.getEmail());
        userDetailDMO.setPhone(user.getPhone());
        userDetailDMO.setIsManager(user.getIsManager());
        userDetailDMO.setPassword(SystemConst.ASTERISK_DESENSITIZATION);
        return BaseResponse.ok(userDetailDMO);
    }

    public BaseResponse resetPassword(Long userId) {
        Optional<User> user = userDao.findById(userId);
        user.orElseThrow(TalinServiceException::new);
        User user1 = user.get();
        user1.setPassword(SystemConst.DEFAULT_PASSWORD);
        user1.setUpdateBy(getCurrentUserId());
        user1.setUpdateTime(new Date());
        userDao.saveAndFlush(user1);
        return BaseResponse.ok();
    }

    public BaseResponse discontinueUse(Long userId) {
        Optional<User> user = userDao.findById(userId);
        user.orElseThrow(TalinServiceException::new);
        User user1 = user.get();
        user1.setIsDeleted(1);
        user1.setUpdateBy(getCurrentUserId());
        user1.setUpdateTime(new Date());
        userDao.saveAndFlush(user1);
        return BaseResponse.ok();
    }
}
