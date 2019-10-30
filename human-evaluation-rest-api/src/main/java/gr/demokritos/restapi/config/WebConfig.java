package gr.demokritos.restapi.config;

import gr.demokritos.restapi.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = Constants.BASE_PACKAGE)
public class WebConfig implements WebMvcConfigurer {

    /**
     * Load properties files. Check classpath first and then catalina base.
     * Override the properties in the application.properties file in catalina base.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setIgnoreResourceNotFound(true);
        Resource[] resourceLocations = new Resource[]{
                new ClassPathResource(Constants.APPLICATION_PROPERTIES_FILE),
                new FileSystemResource(System.getProperty(Constants.CATALINA_BASE) + "/"
                        + Constants.APPLICATION_PROPERTIES_FILE)
        };
        p.setLocations(resourceLocations);
        return p;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
