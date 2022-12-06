package com.example.callweatherservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.example.callweatherservice.entity.WeatherAPI;

@Configuration
public class RedisTempleConfig {
  @Bean
  public RedisTemplate<String, WeatherAPI> redisTemplate(RedisConnectionFactory connectionFactory) {
      RedisTemplate<String, WeatherAPI> template = new RedisTemplate<>();
      template.setConnectionFactory(connectionFactory);
      StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
      template.setKeySerializer(stringRedisSerializer);
      return template;
  }
}
