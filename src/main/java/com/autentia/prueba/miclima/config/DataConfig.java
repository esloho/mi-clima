package com.autentia.prueba.miclima.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration of the data source.
 * 
 * @author esloho
 *
 */
@Configuration
@MapperScan("com.autentia.prueba.miclima.mapper")
@EnableTransactionManagement
public class DataConfig {

    /**
     * Sets parameters for data source access.
     * 
     * @return
     */
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/climate");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    /**
     * For scoping/controlling the transactions
     * 
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * Sets the sql session factory with the data source and alias package.
     * 
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory
                .setTypeAliasesPackage("com.autentia.prueba.miclima.model");

        return sqlSessionFactory;
    }
}
