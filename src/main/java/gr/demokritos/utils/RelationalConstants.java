package gr.demokritos.utils;

public class RelationalConstants {
    /** Databases **/
    public static final String SQL_SERVER = "SQL_SERVER";
    public static final String ORACLE = "ORACLE";
    public static final String POSTGRESQL = "POSTGRESQL";
    public static final String MY_SQL = "MYSQL";

    public static final String PERSISTENCE_PACKAGE = "gr.demokritos.relational.persistence";
    public static final String HIBERNATE_SQL_SERVER_DIALECT = "org.hibernate.dialect.SQLServer2008Dialect";
    public static final String HIBERNATE_ORACLE_DIALECT = "org.hibernate.dialect.Oracle10gDialect";
    public static final String HIBERNATE_POSTGRESQL_DIALECT  ="org.hibernate.dialect.PostgreSQLDialect";
    public static final String HIBERNATE_MYSQL_DIALECT = "org.hibernate.dialect.MySQL8Dialect";
    public static final String HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    public static final String HIBERNATE_ENTITY_MANAGER_FACTORY_NAME = "hibernate.ejb.entitymanager_factory_name";

    public static final String DATASOURCE = "dataSource";
    public static final String TRANSACTION_MANAGER = "transactionManager";
    public static final String ENTITY_MANAGER_FACTORY = "entityManagerFactory";
    public static final String ENTITY_MANAGER = "entityManager";

    public static final String MODEL_MAPPER = "modelMapper";
    public static final String MAPPER_SERVICE = "mapperService";
}
