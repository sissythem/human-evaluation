package gr.demokritos.config;

import gr.demokritos.utils.RelationalConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = RelationalConstants.PERSISTENCE_PACKAGE)
@PropertySource("classpath:application.properties")
@ConditionalOnProperty(
        name = "backend",
        havingValue = "RELATIONAL")
public class RelationalDbConfig {

    @Value("${application.database}")
    private String database;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;


    @Bean(name = RelationalConstants.DATASOURCE)
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = RelationalConstants.ENTITY_MANAGER_FACTORY)
    @Primary
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.valueOf(database));
        vendorAdapter.setGenerateDdl(true);
        if (database.equalsIgnoreCase(RelationalConstants.SQL_SERVER)) {
            vendorAdapter.setDatabasePlatform(RelationalConstants.HIBERNATE_SQL_SERVER_DIALECT);
        } else if (database.equalsIgnoreCase(RelationalConstants.ORACLE)) {
            vendorAdapter.setDatabasePlatform(RelationalConstants.HIBERNATE_ORACLE_DIALECT);
        } else if (database.equalsIgnoreCase(RelationalConstants.POSTGRESQL)) {
            vendorAdapter.setDatabasePlatform(RelationalConstants.HIBERNATE_POSTGRESQL_DIALECT);
        } else if (database.equalsIgnoreCase(RelationalConstants.MY_SQL)) {
            vendorAdapter.setDatabasePlatform(RelationalConstants.HIBERNATE_MYSQL_DIALECT);
        }
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(RelationalConstants.PERSISTENCE_PACKAGE);
        factory.setDataSource(dataSource());
        factory.setJpaDialect(new HibernateJpaDialect());

        Map<String, Object> properties = factory.getJpaPropertyMap();
        properties.put(RelationalConstants.HIBERNATE_NAMING_STRATEGY, NamingConfig.class.getName());
        properties.put(RelationalConstants.HIBERNATE_ENTITY_MANAGER_FACTORY_NAME, RelationalConstants.ENTITY_MANAGER_FACTORY);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = RelationalConstants.TRANSACTION_MANAGER)
    @Primary
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean(name = RelationalConstants.ENTITY_MANAGER)
    @Primary
    public EntityManager entityManager() {
        EntityManagerFactory entityManagerFactory = entityManagerFactory();
        return entityManagerFactory.createEntityManager();
    }

    @Bean(name = RelationalConstants.MODEL_MAPPER)
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
