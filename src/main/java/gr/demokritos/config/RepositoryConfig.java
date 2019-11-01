package gr.demokritos.config;

import gr.demokritos.cassandra.services.AnnotationCassandraService;
import gr.demokritos.cassandra.services.CharacteristicCassandraService;
import gr.demokritos.cassandra.services.TextCassandraService;
import gr.demokritos.cassandra.services.UserCassandraService;
import gr.demokritos.commons.services.AnnotationService;
import gr.demokritos.commons.services.CharacteristicService;
import gr.demokritos.commons.services.TextService;
import gr.demokritos.commons.services.UserService;
import gr.demokritos.mongodb.services.AnnotationMongoService;
import gr.demokritos.mongodb.services.CharacteristicMongoService;
import gr.demokritos.mongodb.services.TextMongoService;
import gr.demokritos.mongodb.services.UserMongoService;
import gr.demokritos.redis.services.AnnotationRedisService;
import gr.demokritos.redis.services.CharacteristicRedisService;
import gr.demokritos.redis.services.TextRedisService;
import gr.demokritos.redis.services.UserRedisService;
import gr.demokritos.relational.services.AnnotationJpaService;
import gr.demokritos.relational.services.CharacteristicJpaService;
import gr.demokritos.relational.services.TextJpaService;
import gr.demokritos.relational.services.UserJpaService;
import gr.demokritos.utils.BackendMethod;
import gr.demokritos.utils.RestApiConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Value("${backend}")
    private String backendMethod;

    @Bean(name = RestApiConstants.USER_SERVICE)
    public UserService userService() {
        BackendMethod method = BackendMethod.getEnumFromString(backendMethod);
        if (method == null) return null;
        switch (method) {
            case RELATIONAL:
                return new UserJpaService();
            case MONGODB:
                return new UserMongoService();
            case REDIS:
                return new UserRedisService();
            case CASSANDRA:
                return new UserCassandraService();
            case JSON:
            default:
                return null;
        }
    }

    @Bean(name = RestApiConstants.TEXT_SERVICE)
    public TextService textService() {
        BackendMethod method = BackendMethod.getEnumFromString(backendMethod);
        if (method == null) return null;
        switch (method) {
            case RELATIONAL:
                return new TextJpaService();
            case MONGODB:
                return new TextMongoService();
            case REDIS:
                return new TextRedisService();
            case CASSANDRA:
                return new TextCassandraService();
            case JSON:
            default:
                return null;
        }
    }

    @Bean(name = RestApiConstants.ANNOTATION_SERVICE)
    public AnnotationService annotationService() {
        BackendMethod method = BackendMethod.getEnumFromString(backendMethod);
        if (method == null) return null;
        switch (method) {
            case RELATIONAL:
                return new AnnotationJpaService();
            case MONGODB:
                return new AnnotationMongoService();
            case REDIS:
                return new AnnotationRedisService();
            case CASSANDRA:
                return new AnnotationCassandraService();
            case JSON:
            default:
                return null;
        }
    }

    @Bean(name = RestApiConstants.CHARACTERISTIC_SERVICE)
    public CharacteristicService characteristicService() {
        BackendMethod method = BackendMethod.getEnumFromString(backendMethod);
        if (method == null) return null;
        switch (method) {
            case RELATIONAL:
                return new CharacteristicJpaService();
            case MONGODB:
                return new CharacteristicMongoService();
            case REDIS:
                return new CharacteristicRedisService();
            case CASSANDRA:
                return new CharacteristicCassandraService();
            case JSON:
            default:
                return null;
        }
    }

}
