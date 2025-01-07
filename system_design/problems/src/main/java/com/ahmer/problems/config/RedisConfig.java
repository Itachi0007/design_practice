package com.ahmer.problems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

// Marks this class as a configuration class for Spring Boot
@Configuration
public class RedisConfig {

    // Define a RedisTemplate bean for working with Redis
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
        // Create a new instance of RedisTemplate
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

        // Set the connection factory (manages Redis connections)
        redisTemplate.setConnectionFactory(connectionFactory);

        // Configure the serializer for values to handle string conversions
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(String.class));

        // Return the configured RedisTemplate bean
        return redisTemplate;
    }
}
