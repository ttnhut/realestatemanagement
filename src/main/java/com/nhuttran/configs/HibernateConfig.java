/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.configs;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
/**
 *
 * @author Asus
 */
@Configuration
@PropertySource("classpath:database.properties")
public class HibernateConfig {
    @Autowired
    private Environment env;
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.nhuttran.pojos");
        factory.setHibernateProperties(hibernateProperties());
        return factory;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
        d.setUrl(env.getProperty("hibernate.connection.url"));
        d.setUsername(env.getProperty("hibernate.connection.username"));
        d.setPassword(env.getProperty("hibernate.connection.password"));
        return d;
    }
    
    private Properties hibernateProperties(){
        Properties p = new Properties();
        p.setProperty(DIALECT, env.getProperty("hibernate.dialect"));
        p.setProperty(SHOW_SQL, env.getProperty("hibernate.showSql"));
        return p;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager h = new HibernateTransactionManager();
        h.setSessionFactory(getSessionFactory().getObject());
        return h;
    }
}
