package gr.demokritos.config;

import gr.demokritos.utils.CassandraConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
@EnableCassandraRepositories(basePackages = CassandraConstants.PERSISTENCE_PACKAGE)
@ConditionalOnProperty(
        name = "backend",
        havingValue = "CASSANDRA")
public class CassandraConfig extends AbstractCassandraConfiguration {

    private Logger logger = LoggerFactory.getLogger(CassandraConfig.class);

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpaceName;

    @Value("${spring.data.cassandra.contact-points}")
    private String host;

    @Value("${spring.data.cassandra.port}")
    private String port;

    /*
     * Provide a contact point to the configuration.
     */
    @Override
    public String getContactPoints() {
        return host;
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster =
                new CassandraClusterFactoryBean();
        cluster.setContactPoints(getContactPoints());
        cluster.setPort(Integer.parseInt(port));
        return cluster;
    }

    /*
     * Provide a keyspace name to the configuration.
     */
    @Override
    public String getKeyspaceName() {
        return keySpaceName;
    }

    /*
     * Automatically creates a Keyspace if it doesn't exist
     */
    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
                .createKeyspace(getKeyspaceName()).ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication();
        return Arrays.asList(specification);
    }

    @Bean
    public CassandraMappingContext mappingContext() {
        CassandraMappingContext mappingContext= new CassandraMappingContext();
        try {
            mappingContext.setInitialEntitySet(getInitialEntitySet());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
        return mappingContext;
    }

    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    @Bean
    public CassandraSessionFactoryBean session() {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(cluster().getObject());
        session.setKeyspaceName(keySpaceName);
        session.setConverter(converter());
        session.setSchemaAction(SchemaAction.NONE);
        return session;
    }

    /*
     * Automatically configure a table if doesn't exist
     */
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }


    /*
     * Get the entity package (where the entity class has the @Table annotation)
     */
    @Override
    public String[] getEntityBasePackages() {
        return new String[] { CassandraConstants.ENTITIES_PACKAGE };
    }
}
