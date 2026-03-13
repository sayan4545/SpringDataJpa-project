package com.dev.sayan.algocamp.springdatajpaproject.configs;

import com.zaxxer.hikari.HikariDataSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig {

    @Value("${SPRING_DATASOURCE_URL}")
    private String dbUrl;

    @Value("${SPRING_DATASOURCE_USERNAME}")
    private String dbUsername;

    @Value("${SPRING_DATASOURCE_PASSWORD}")
    private String dbPassword;

    @Value("${SPRING_DATASOURCE_DRIVER-CLASS-NAME}")
    private String dbDriver;

    @Bean
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dbDriver);
        hikariDataSource.setJdbcUrl(dbUrl);
        hikariDataSource.setUsername(dbUsername);
        hikariDataSource.setPassword(dbPassword);
        hikariDataSource.setMaximumPoolSize(10000);
        hikariDataSource.setMaxLifetime(1000000000L);
        return hikariDataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return adapter;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource datasource,
            JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emf1 = new LocalContainerEntityManagerFactoryBean();
        emf1.setDataSource(datasource);
        emf1.setJpaVendorAdapter(jpaVendorAdapter);
        emf1.setPackagesToScan("com.dev.sayan.algocamp.springdatajpaproject");
        emf1.setPersistenceUnitName("persistence1");

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        emf1.setJpaProperties(jpaProperties);

        return emf1;
    }
}