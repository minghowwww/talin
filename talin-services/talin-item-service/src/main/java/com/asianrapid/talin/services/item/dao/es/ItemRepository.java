package com.asianrapid.talin.services.item.dao.es;

import com.asianrapid.talin.services.item.domain.es.ItemEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nio
 * @Description:定义ItemRepository 接口
 * @Param: ItemEs:为实体类
 * Long:为Item实体类中主键的数据类型
 * @Date: 2018/9/29 0:50
 */
@Repository
public interface ItemRepository extends ElasticsearchRepository<ItemEs, Long> {

}
