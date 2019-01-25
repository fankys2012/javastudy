package com.starcor.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-26 17:12
 */
public class JedisClient {

    private static final String host = "192.168.56.120";

    private static final JedisClient jedisClient = new JedisClient();

    private Jedis jedis = null;


    private JedisClient(){}

    public static JedisClient getInstance(){
        return jedisClient;
    }

    private JedisPoolConfig getPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxWaitMillis(3000);
        return jedisPoolConfig;
    }

    public Boolean set(String key, String value) throws Exception {
        JedisPool pool = new JedisPool(getPoolConfig(),host);
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            throw e;
        }
        finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        pool.destroy();
        return true;
    }

    public String get(String key) throws Exception {
        JedisPool pool = new JedisPool(getPoolConfig(),host);
        Jedis jedis = null;
        String result = "";
        try {
            jedis = pool.getResource();
            result = jedis.get(key);
        }catch (Exception e){
            throw e;
        }
        finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        pool.destroy();
        return result;
    }
}
