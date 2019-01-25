package com.starcor.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-26 18:27
 */
public class RedisCacheUtil {

    private static final int DEFAULT_EXPIRE_TIME = 300;//second

    private JedisCluster jedisCluster;

    private ApplicationContext applicationContext;

    private String jedisClusterName;

    private JedisCluster getJedisCluster(){
        if(jedisCluster == null){
            jedisCluster = (JedisCluster) applicationContext.getBean(jedisClusterName);
        }
        return jedisCluster;
    }





    /**
     * 设置String类型的值
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        return getJedisCluster().setex(key, DEFAULT_EXPIRE_TIME, value);
    }

    /**
     * 设置String类型的值并设置过期时间
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public String setAndExpire(String key, int seconds, String value) {
        if(seconds == -1){
            return getJedisCluster().set(key,value);
        }
        return getJedisCluster().setex(key, seconds, value);
    }

    /**
     * 为指定键设置过期时间
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(String key, int seconds) {
        return getJedisCluster().expire(key, seconds);
    }

    /**
     * 获取String类型的值
     * @param key
     * @return
     */
    public String get(String key) {
        return getJedisCluster().get(key);
    }

    /**
     * 删除指定键
     * @param key
     * @return
     */
    public Long del(String key) {
        return getJedisCluster().del(key);
    }

    /**
     * 批量删除key
     * @param keys
     */
    public void batchDel(List<String> keys){
        for (String key: keys) {
            this.del(key);
        }
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String getJedisClusterName() {
        return jedisClusterName;
    }

    public void setJedisClusterName(String jedisClusterName) {
        this.jedisClusterName = jedisClusterName;
    }
}
