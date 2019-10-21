package com.asianrapid.talin.services.item.domain.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Nio
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(indexName = "item",type = "docs", shards = 1, replicas = 0)
public class ItemEs {
	
	/**
	 * @Description: @Id注解必须是springframework包下的
	 * org.springframework.data.annotation.Id						
	 */
    @Id
    private Long id;

    /**
     * 标题
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word")
    private String title;

    /**
     * 分类
     */
    @Field(type = FieldType.keyword)
    private String category;

    /**
     * 卖点
     */
    @Field(type = FieldType.keyword)
    private String sellPoint;

    /**
     * 价格
     */
    @Field(type = FieldType.Double)
    private Long price;

    /**
     * 图片地址
     */
    @Field(index = false, type = FieldType.keyword)
    private String images;
}
