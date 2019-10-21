package com.asianrapid.talin.common.domain.dbo.primaryKey;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName SeckillItemPK
 * @Description: 秒杀商品表主键
 * @Author Nio
 * @Date 2019/9/16 0016
 * @Version V1.0
 **/
public class SeckillItemPK implements Serializable {

    private long itemId;
    private long activityId;
}
