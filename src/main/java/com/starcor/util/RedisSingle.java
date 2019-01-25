package com.starcor.util;

import org.springframework.context.ApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-28 15:05
 */
public class RedisSingle {

    private static final int DEFAULT_EXPIRE_TIME = 300;//second

    private Jedis jedis;

    private ApplicationContext applicationContext;

    private String jedisSingleName;

    private Jedis getJedis(){
        if (jedis == null) {
            JedisPool jedisPool = (JedisPool) applicationContext.getBean(jedisSingleName);
            jedis = jedisPool.getResource();
        }
        return jedis;
    }

    public String set(String key, String value) {
        return getJedis().setex(key, DEFAULT_EXPIRE_TIME, value);
    }

    public String get(String key) {
        return getJedis().get(key);
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String getJedisSingleName() {
        return jedisSingleName;
    }

    public void setJedisSingleName(String jedisSingleName) {
        this.jedisSingleName = jedisSingleName;
    }
}
