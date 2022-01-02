package com.seckill.dis.cache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis连接池
 */
@Component
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    @Bean
    public JedisPool jedisPoolFactory() {
        // jedis连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);

        JedisPool pool = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout(),redisConfig.getPassword(),0);
        return pool;
    }

//    public JedisPool jedisPoolFactory(){
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
//        jedisPoolConfig.setMaxIdle(redisConfig.getPoolMaxldle());
//        jedisPoolConfig.setMaxWaitMillis(1000*redisConfig.getPoolMaxWait());
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig,redisConfig.getHost(),redisConfig.getPort(),redisConfig.getTimeout()*1000,redisConfig.getPassword(),0);
//        return jedisPool;
//    }
}
