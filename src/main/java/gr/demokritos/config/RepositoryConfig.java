package gr.demokritos.config;

import gr.demokritos.relational.services.*;
import gr.demokritos.utils.RestApiConstants;
import gr.demokritos.commons.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Value("${backend}")
    private String backendMethod;

    @Bean(name = RestApiConstants.USER_SERVICE)
    public UserService userService() {
        if(backendMethod.equalsIgnoreCase(RestApiConstants.RELATIONAL)) {
            return new UserJpaService();
        } else if (backendMethod.equalsIgnoreCase(RestApiConstants.MONGODB)) {

        }
        return null;
    }

    @Bean(name = RestApiConstants.TEXT_SERVICE)
    public TextService textService() {
        if(backendMethod.equalsIgnoreCase(RestApiConstants.RELATIONAL)) {
            return new TextJpaService();
        } else if (backendMethod.equalsIgnoreCase(RestApiConstants.MONGODB)) {

        }
        return null;
    }

    @Bean(name = RestApiConstants.ANNOTATION_SERVICE)
    public AnnotationService annotationService() {
        if(backendMethod.equalsIgnoreCase(RestApiConstants.RELATIONAL)) {
            return new AnnotationJpaService();
        } else if (backendMethod.equalsIgnoreCase(RestApiConstants.MONGODB)) {

        }
        return null;
    }

    @Bean(name = RestApiConstants.CHARACTERISTIC_SERVICE)
    public CharacteristicService characteristicService() {
        if(backendMethod.equalsIgnoreCase(RestApiConstants.RELATIONAL)) {
            return new CharacteristicJpaService();
        } else if (backendMethod.equalsIgnoreCase(RestApiConstants.MONGODB)) {

        }
        return null;
    }

}
