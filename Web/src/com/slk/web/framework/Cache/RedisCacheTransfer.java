package com.slk.web.framework.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Create by 杨明 2019/6/20 0020 下午 16:07
 */
public class RedisCacheTransfer {

    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory){
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
