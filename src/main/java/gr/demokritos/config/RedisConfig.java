package gr.demokritos.config;

import gr.demokritos.utils.RedisConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
@EnableRedisRepositories(basePackages = RedisConstants.REDIS_PERSISTENCE_PACKAGE)
@ConditionalOnProperty(
        name = "backend",
        havingValue = "REDIS")
public class RedisConfig {

}
