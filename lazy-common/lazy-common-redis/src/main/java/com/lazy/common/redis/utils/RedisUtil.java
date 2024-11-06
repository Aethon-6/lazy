package com.lazy.common.redis.utils;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, String> stringRedisTemplate;

    /**
     * 将指定的键设置为指定的值在Redis中
     * 如果键已经存在，那么旧的值将被覆盖
     *
     * @param key   要设置的键，不能为空
     * @param value 要设置的值，可以为空
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 将指定的键值对设置到Redis中，并为键设置过期时间
     *
     * @param key     键，用于唯一标识存储的数据
     * @param value   值，与键关联的数据
     * @param timeout 超时时间，表示键在多少时间后应过期
     * @param unit    时间单位，用于解释timeout参数的时间单位
     */
    public void set(String key, String value, long timeout, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 根据键获取存储在Redis中的字符串值
     *
     * @param key Redis键，用于唯一标识存储的值
     * @return 与键关联的字符串值，如果键不存在，则返回null
     */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 使用Redis设置带有过期时间的键值对
     * <p>
     * 此方法主要用于缓存场景，其中数据只需要在一段时间内保持有效
     * 它使用Redis的特性来设置键值对，并同时指定该键值对在多少秒后过期
     *
     * @param key     键，用于唯一标识存储的数据在Redis中
     * @param value   值，与键关联的数据
     * @param timeout 过期时间，单位为秒，表示数据在Redis中保持有效的时间长度
     */
    public void setWithExpire(String key, String value, long timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 判断指定的键是否存在于Redis中
     *
     * @param key 要检查的键
     * @return 如果键存在，则返回true；否则返回false
     */
    public boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 删除指定的键
     * <p>
     * 本方法通过调用RedisTemplate的delete方法来删除给定的键
     * 主要用于在Redis中移除不再需要的数据
     *
     * @param key 要删除的键的名称
     */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 对指定键的数值进行增量操作
     * 如果键不存在，那么在增量操作之前，键会被初始化为0
     * 此方法主要用于处理计数器类型的场景，例如统计页面访问次数等
     *
     * @param key   Redis中的键，用于唯一标识一个数值
     * @param delta 增量，表示键的数值增加的量，可以是负数表示减少
     * @return 返回更新后的数值
     * <p>
     * 注意：此方法使用了requireNonNull来确保操作的结果不会为null
     * 这意味着如果key为null，或者key不存在，将会抛出NullPointerException
     */
    public String increment(String key, long delta) {
        return Objects.requireNonNull(stringRedisTemplate.opsForValue().increment(key, delta)).toString();
    }

    // 其他操作，如 List、Set、Hash 等操作可以类似地封装
}
