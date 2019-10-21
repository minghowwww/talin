package com.asianrapid.talin.common.domain.dmo;

import com.asianrapid.talin.common.domain.common.TableRow;
import lombok.Data;


/**
 * @ClassName UserListDMO
 * @Description: 用户列表查询结果dto
 * @Author Nio
 * @Date 2019/9/21 0021
 * @Version V1.0
 **/
@Data
public class UserListDMO implements TableRow {

    private Long id;
    private String username;
    private String email;
    private String phone;
    private long isManager;

}
