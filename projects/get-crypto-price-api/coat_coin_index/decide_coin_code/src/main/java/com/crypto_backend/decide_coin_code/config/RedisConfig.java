package com.crypto_backend.decide_coin_code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.crypto_backend.decide_coin_code.dto.CoinAndTransactionInfo;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, CoinAndTransactionInfo> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String,CoinAndTransactionInfo> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        return template;
    }
    
}
