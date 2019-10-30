package gr.demokritos.relational.config;

import gr.demokritos.relational.utils.Constants;
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
@EnableJpaRepositories(basePackages = Constants.PERSISTENCE_PACKAGE)
@PropertySource("classpath:relationaldb.properties")
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


    @Bean(name = Constants.DATASOURCE)
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = Constants.ENTITY_MANAGER_FACTORY)
    @Primary
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.valueOf(database));
        vendorAdapter.setGenerateDdl(true);
        if (database.equalsIgnoreCase(Constants.SQL_SERVER)) {
            vendorAdapter.setDatabasePlatform(Constants.HIBERNATE_SQL_SERVER_DIALECT);
        } else if (database.equalsIgnoreCase(Constants.ORACLE)) {
            vendorAdapter.setDatabasePlatform(Constants.HIBERNATE_ORACLE_DIALECT);
        } else if (database.equalsIgnoreCase(Constants.POSTGRESQL)) {
            vendorAdapter.setDatabasePlatform(Constants.HIBERNATE_POSTGRESQL_DIALECT);
        } else if (database.equalsIgnoreCase(Constants.MY_SQL)) {
            vendorAdapter.setDatabasePlatform(Constants.HIBERNATE_MYSQL_DIALECT);
        }
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(Constants.PERSISTENCE_PACKAGE);
        factory.setDataSource(dataSource());
        factory.setJpaDialect(new HibernateJpaDialect());

        Map<String, Object> properties = factory.getJpaPropertyMap();
        properties.put(Constants.HIBERNATE_NAMING_STRATEGY, NamingConfig.class.getName());
        properties.put(Constants.HIBERNATE_ENTITY_MANAGER_FACTORY_NAME, Constants.ENTITY_MANAGER_FACTORY);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = Constants.TRANSACTION_MANAGER)
    @Primary
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean(name = Constants.ENTITY_MANAGER)
    @Primary
    public EntityManager entityManager() {
        EntityManagerFactory entityManagerFactory = entityManagerFactory();
        return entityManagerFactory.createEntityManager();
    }

    @Bean(name = Constants.RELATIONAL_MODEL_MAPPER)
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
