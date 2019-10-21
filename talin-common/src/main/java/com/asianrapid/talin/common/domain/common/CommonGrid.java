package com.asianrapid.talin.common.domain.common;

import com.alibaba.fastjson.JSONArray;
import com.querydsl.core.QueryResults;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName CommonGrid
 * @Description: 数据表格共通响应实体
 * @Author Nio
 * @Date 2019/8/1 0001
 * @Version V1.0
 **/
@Slf4j
@Data
public class CommonGrid<T extends TableRow> extends BasePojo {

    private static final long serialVersionUID = -2368652248747429600L;

    private Long totalRecords;

    private List<T> rowList;

    private Integer totalPages;

    public CommonGrid(Long totalRecords, List<T> rowList, Integer totalPages) {
        this.totalRecords = totalRecords;
        this.rowList = rowList;
        this.totalPages = totalPages;
    }

    public CommonGrid(Page page) {
        this.totalRecords = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.rowList = page.getContent();
    }


    public CommonGrid(QueryResults results, Class clz) {
        this.totalRecords = results.getTotal();
        this.totalPages = new Double(Math.ceil(results.getResults().size() / results.getLimit())).intValue();
        List<T> ts = new ArrayList<>();
        results.getResults().stream().forEach(v -> {
            Object instance = null;
            try {
                instance = clz.newInstance();
            } catch (InstantiationException e) {
                log.error("DBOConvertToDTO失败", e);
            } catch (IllegalAccessException e) {
                log.error("DBOConvertToDTO失败", e);
            }
            BeanUtils.copyProperties(v, instance, clz);
            ts.add((T) instance);
        });
        this.rowList = ts;
    }

    public CommonGrid(Page page, Class clz) {
        this.totalRecords = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        List<T> ts = new ArrayList<>();
        page.getContent().stream().forEach(v -> {
            Object instance = null;
            try {
                instance = clz.newInstance();
            } catch (InstantiationException e) {
                log.error("DBOConvertToDTO失败", e);
            } catch (IllegalAccessException e) {
                log.error("DBOConvertToDTO失败", e);
            }
            BeanUtils.copyProperties(v, instance, clz);
            ts.add((T) instance);
        });
        this.rowList = ts;
    }

//    public Map<String, Object> getMap() {
//        JSONArray array = new JSONArray();
//        if(rowList != null){
//            for (T t : rowList) {
//                array.add(t.toRowJson());
//            }
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("total", totalRecords);
//        map.put("rows", array);
//        return map;
//    }

}
