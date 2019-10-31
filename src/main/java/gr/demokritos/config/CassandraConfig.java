package gr.demokritos.config;

import gr.demokritos.utils.CassandraConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
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
