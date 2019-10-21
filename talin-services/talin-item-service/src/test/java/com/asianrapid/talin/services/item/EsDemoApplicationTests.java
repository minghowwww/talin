package com.asianrapid.talin.services.item;

import com.asianrapid.talin.ItemApplication;
import com.asianrapid.talin.common.domain.dbo.Item;
import com.asianrapid.talin.common.domain.dbo.QItem;
import com.asianrapid.talin.services.item.dao.ItemDao;
import com.asianrapid.talin.services.item.dao.es.ItemRepository;
import com.asianrapid.talin.services.item.domain.es.ItemEs;
import com.querydsl.core.types.Predicate;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * https://www.w3cschool.cn/jpaspec/yaxg1s4f.html
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemApplication.class)
public class EsDemoApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemDao itemDao;

//    @Autowired
//    private ItemSpecification itemSpecification;

    @Autowired
    private EntityManager entityManager;

    /**
     * @Description:创建索引，会根据Item类的@Document注解信息来创建
     * @Date: 2018/9/29 0:51
     */
    @Test
    @Transactional
    public void testCreateIndex() {
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
        elasticsearchTemplate.createIndex(ItemEs.class);

//        List<Item> all = itemDao.findAll();
//        List<ItemEs> list = new ArrayList<>();
//        list.add(new ItemEs(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.baidu.com/13123.jpg"));
//        list.add(new ItemEs(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.baidu.com/13123.jpg"));
        //接收对象集合，实现批量新增
//        for (Item item : all) {
//            ItemEs itemEs = new ItemEs();
//            BeanUtils.copyProperties(item, itemEs);
//            list.add(itemEs);
//        }

//        itemRepository.saveAll(all);


        // 构建查询条件
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
//        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米"));
//        queryBuilder.withQuery(QueryBuilders.queryStringQuery("手机"));
        // 搜索，获取结果
//        Page<ItemEs> items = this.itemRepository.search(queryBuilder.build());
        // 总条数
//        long total = items.getTotalElements();
//        System.out.println("total = " + total);
//        for (ItemEs item : items) {
//            System.out.println(item);
//        }


//        itemRepository.deleteAll(list);

//        List<Item> all = itemDao.findAll(itemSpecification.listItemsSpecification());
//        for (Item item : all) {
////            System.out.println(item.getTitle() + ",----" + item.getItemCat().getName());
//            ItemEs itemEs = new ItemEs();
//            itemEs.setCategory(item.getItemCat().getName());
//            itemEs.setId(item.getId());
//            itemEs.setImages(item.getImage());
//            itemEs.setPrice(item.getPrice());
//            itemEs.setTitle(item.getTitle());
//            itemEs.setSellPoint(item.getSellPoint());
//
//            itemRepository.save(itemEs);
//        }

//        itemRepository.deleteAll();
    }

    @Test
    @Transactional
    public void testQueryDSL() {

//        QItem qItem = QItem.item;
//        Predicate predicate = qItem.title.likeIgnoreCase("%手机%").and(qItem.status.gt(0));
//        Iterable<Item> all = itemDao.findAll(predicate);
//        for (Item item : all) {
//            System.out.println(item.getTitle());
//        }

//        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
//        QUser user = QUser.user;
//        QUserRole userRole = QUserRole.userRole;
//        QRole role = QRole.role;
//        List<User> fetch = queryFactory.selectFrom(user).leftJoin(user.authorities, userRole).leftJoin(userRole.roleId, role).fetch();
//        for (User fetch1 : fetch) {
//            System.out.print(fetch1.getUsername() + ",");
//            System.out.println(fetch1.getAuthorities().get(0).getRoleId().getRoleCode());
//        }

        QItem qItem = QItem.item;
        Predicate predicate = qItem.status.lt(3);
        Iterable<Item> all = itemDao.findAll(predicate);
        for (Item item : all) {
            System.out.println(item.getTitle());
        }
    }
}
