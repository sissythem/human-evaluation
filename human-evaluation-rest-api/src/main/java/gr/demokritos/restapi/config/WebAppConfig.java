package gr.demokritos.restapi.config;

import gr.demokritos.mongodb.config.MongoConfig;
import gr.demokritos.relational.config.RelationalDbConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebConfig.class,
                ApplicationConfig.class, MongoConfig.class, RelationalDbConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
