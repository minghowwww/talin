package com.asianrapid.talin.common.utils;

import com.asianrapid.talin.common.exception.TalinServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 *
 * @author Nio
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存放string类型
     *
     * @param key     key
     * @param data    数据
     * @param timeout 超时间
     */
    public void setString(String key, String data, Long timeout) {
        try {

            stringRedisTemplate.opsForValue().set(key, data);
            if (timeout != null) {
                stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            }

        } catch (Exception e) {
            throw new TalinServiceException("redis存储字符串失败", e);
        }

    }

    /**
     * 开启Redis 事务
     */
    public void begin() {
        // 开启Redis 事务权限
        stringRedisTemplate.setEnableTransactionSupport(true);
        // 开启事务
        stringRedisTemplate.multi();

    }

    /**
     * 提交事务
     */
    public void exec() {
        // 成功提交事务
        stringRedisTemplate.exec();
    }

    /**
     * 回滚Redis 事务
     */
    public void discard() {
        stringRedisTemplate.discard();
    }

    /**
     * 存放string类型
     *
     * @param key  key
     * @param data 数据
     */
    public void setString(String key, String data) {
        setString(key, data, null);
    }

    /**
     * 根据key查询string类型
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    /**
     * 根据对应的key删除key
     *
     * @param key
     */
    public Boolean delKey(String key) {
        return stringRedisTemplate.delete(key);
    }


    /**
     * 插入set数据
     *
     * @param key
     * @param value
     */
    public Long addSet(String key, String value) {
        try {
            SetOperations<String, String> set = stringRedisTemplate.opsForSet();
            Long add = set.add(key, value);
            return add;
        } catch (Exception e) {
            throw new TalinServiceException("redis插入set失败", e);
        }
    }

    /**
     * 删除set中的元素
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean delSet(String key, String value) {
        Long remove = stringRedisTemplate.opsForSet().remove(key, value);
        return !new Long(0L).equals(remove);
    }

    /**
     * 获取set集合
     *
     * @param key
     * @return
     */
    public Set<String> getSet(String key) {
        Set<String> members = stringRedisTemplate.opsForSet().members(key);
        return stringRedisTemplate.opsForSet().members(key);
    }

    /**
     * 判断set中是否存在
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean checkSet(String key, String value) {
        return stringRedisTemplate.opsForSet().isMember(key, value);
    }

    public Long getSetSize(String key) {
		return stringRedisTemplate.opsForSet().size(key);
    }
}
