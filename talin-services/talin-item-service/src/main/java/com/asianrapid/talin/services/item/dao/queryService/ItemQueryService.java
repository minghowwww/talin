package com.asianrapid.talin.services.item.dao.queryService;

import com.asianrapid.talin.common.domain.dbo.Item;
import com.asianrapid.talin.common.domain.dbo.QItem;
import com.asianrapid.talin.services.item.dao.ItemDao;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @ClassName ItemQueryService
 * @Description: TODO
 * @Author Nio
 * @Date 2019/10/9 0009
 * @Version V1.0
 **/
@Repository
public class ItemQueryService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ItemDao itemDao;

    public List<Item> listItems() {
        QItem qItem = QItem.item;
        Predicate predicate = qItem.status.lt(3);
        Iterable<Item> all = itemDao.findAll(predicate);
        return (List<Item>)all;
    }
}
