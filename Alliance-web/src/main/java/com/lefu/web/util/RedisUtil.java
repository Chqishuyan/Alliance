package com.lefu.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/27.
 */
@Component
public class RedisUtil {
    private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);
    @Resource
    private static JedisPool jedisPool;

    /**
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间 不设置传null
     */
    public static void set(String key, String value, Integer expireTime) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.setex(key, expireTime == null ? 0 : expireTime, value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
    }

    /**
     * @param key 键
     * @return
     */
    public static String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String value = null;
        try {
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis get 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
        return value;
    }

    /**
     *
     * @param key 键
     * @param map 值
     */
    public static void hmSet(String key, Map<String,String> map){
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hmset(key,map);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis hmset 设置Map<String,String> 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
    }

    /**
     *
     * @param key MAP 对应的key
     * @param feilds map中的属性key列表
     * @return
     */
    public static List<String> hmGet(String key,String... feilds) {
        Jedis jedis = jedisPool.getResource();
        List<String> lists = null;
        try {
            lists = jedis.hmget(key, feilds);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis hmget List<String> 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
        return lists;
    }

    /**
     *
     * @param key 键
     * @param map 值
     */
    public static void hmSet(byte[] key, Map<byte[],byte[]> map){
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hmset(key,map);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis hmset 设置Map<String,String> 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
    }

    /**
     *
     * @param key MAP 对应的key
     * @param bytes map中的属性key列表
     * @return
     */
    public static List<byte[]> hmGet(byte[] key,byte[]... bytes) {
        Jedis jedis = jedisPool.getResource();
        List<byte[]> lists = null;
        try {
            lists = jedis.hmget(key, bytes);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis hmget List<byte[]> 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
        return lists;
    }

    /**
     *
     * @param key map对应的key
     * @param feild map中的属性key
     * @param value  map中的value
     */
    public static void hSet(String key,String feild,String value){
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hset(key, feild, value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis hSet String 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
    }

    /**
     *
     * @param key  map对应的key
     * @param feild map中的属性key
     * @return
     */
    public static String hGet(String key,String feild){
        Jedis jedis = jedisPool.getResource();
        String value = null;
        try {
            value = jedis.hget(key, feild);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis hGet String 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
        return value;
    }

    /**
     *
     * @param key map对应的key
     * @param feild map中的属性key
     * @param value  map中的value
     */
    public static void hSet(byte[] key,byte[] feild,byte[] value){
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hset(key, feild, value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis hSet byte[] 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
    }

    /**
     *
     * @param key  map对应的key
     * @param feild map中的属性key
     * @return
     */
    public static byte[] hGet(byte[] key,byte[] feild){
        Jedis jedis = jedisPool.getResource();
        byte[] value = null;
        try {
            value = jedis.hget(key, feild);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis hGet byte[] 操作 异常 exception：{}", e);
        } finally {
            close(jedis);
        }
        return value;
    }

    private static void close(Jedis jedis){
        if(null != jedis){
            jedis.close();
        }
    }



}