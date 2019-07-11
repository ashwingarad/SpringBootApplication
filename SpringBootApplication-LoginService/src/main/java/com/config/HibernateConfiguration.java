package com.config;


import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
    @Value("${db.driver_class}")
    private String DRIVER_CLASS;

    @Value("${db.url}")
    private String URL;

    @Value("${db.username}")
    private String USER_NAME;

    @Value("${db.password}")
    private String PASSWORD;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${hibernate.format_sql}")
    private String HIBERNATE_FORMAT_SQL;

    @Value("${hibernate.generate_statistics}")
    private String GENERATE_STATISTICS;

    @Value("${hibernate.jdbc.batch_size}")
    private String BATCH_SIZE;

    @Bean(name = "dataSource")
    @Primary
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(this.getDataSource());
        sessionFactory.setPackagesToScan("com.dao.model");
        sessionFactory.setHibernateProperties(this.hibernateProp());
        try {
            sessionFactory.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public Properties hibernateProp() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", HIBERNATE_DIALECT);
        properties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
        properties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        properties.put("hibernate.format_sql", HIBERNATE_FORMAT_SQL);
        properties.put("hibernate.jdbc.batch_size", BATCH_SIZE);
        properties.put("hibernate.generate_statistics", GENERATE_STATISTICS);
        properties.put("hibernate.c3p0.min_size", "5");
        properties.put("hibernate.c3p0.max_size", "20");
        properties.put("hibernate.c3p0.timeout", "1800");
        properties.put("hibernate.c3p0.max_statements", "50");
        properties.put("hibernate.cache.use_second_level_cache", "true");
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.jcache.internal.JCacheRegionFactory");
        properties.put("hibernate.cache.use_query_cache", "true");
        properties.put("hibernate.cache.ehcache.missing_cache_strategy", "create");
        return properties;
    }
}
