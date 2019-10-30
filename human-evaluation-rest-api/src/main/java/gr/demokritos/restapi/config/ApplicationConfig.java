package gr.demokritos.restapi.config;

import gr.demokritos.relational.services.*;
import gr.demokritos.restapi.utils.Constants;
import gr.demokritos.serviceInterfaces.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@ComponentScan(basePackages = Constants.BASE_PACKAGE,
        excludeFilters =
                {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class),
                        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ControllerAdvice.class)})
public class ApplicationConfig {

    @Value("${backend}")
    private String backendMethod;

    @Bean(name = Constants.USER_SERVICE)
    public UserService userService() {
        if(backendMethod.equalsIgnoreCase(Constants.RELATIONAL)) {
            return new UserJpaService();
        } else if (backendMethod.equalsIgnoreCase(Constants.MONGODB)) {

        }
        return null;
    }

    @Bean(name = Constants.TEXT_SERVICE)
    public TextService textService() {
        if(backendMethod.equalsIgnoreCase(Constants.RELATIONAL)) {
            return new TextJpaService();
        } else if (backendMethod.equalsIgnoreCase(Constants.MONGODB)) {

        }
        return null;
    }

    @Bean(name = Constants.GRADE_SERVICE)
    public GradeService gradeService() {
        if(backendMethod.equalsIgnoreCase(Constants.RELATIONAL)) {
            return new GradeJpaService();
        } else if (backendMethod.equalsIgnoreCase(Constants.MONGODB)) {

        }
        return null;
    }

    @Bean(name = Constants.ANNOTATION_SERVICE)
    public AnnotationService annotationService() {
        if(backendMethod.equalsIgnoreCase(Constants.RELATIONAL)) {
            return new AnnotationJpaService();
        } else if (backendMethod.equalsIgnoreCase(Constants.MONGODB)) {

        }
        return null;
    }

    @Bean(name = Constants.CHARACTERISTIC_SERVICE)
    public CharacteristicService characteristicService() {
        if(backendMethod.equalsIgnoreCase(Constants.RELATIONAL)) {
            return new CharacteristicJpaService();
        } else if (backendMethod.equalsIgnoreCase(Constants.MONGODB)) {

        }
        return null;
    }

}
