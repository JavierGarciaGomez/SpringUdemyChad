package com.JGG.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

//380, 432

@Configuration
@EnableWebMvc//similar support to <mvc:annotation-driven>
@ComponentScan(basePackages = "com.JGG.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties") //432
public class DemoAppConfig {
    //433¡2 set up variable to hold the properties
    @Autowired
    private Environment environment; // hold the data read from properties files

    // set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());


    //380 Define a bean for View Resolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //432 Define a bean for our security datasource
    @Bean
    public DataSource securityDataSource(){
        //432 create connection pool
        ComboPooledDataSource securityDataDource = new ComboPooledDataSource();
        // 432 set the jdbc  driver class
        try {
            securityDataDource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        //432 log the connection props
        logger.info("432 >>> jdbc.url "+environment.getProperty("jdbc.url"));
        logger.info("432 >>> jdbc.user "+environment.getProperty("jdbc.user"));
        //434set database connection props
        securityDataDource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataDource.setUser(environment.getProperty("jdbc.user"));
        securityDataDource.setPassword(environment.getProperty("jdbc.password"));
        //434set connection pool props (READ IT FROM PROPERTIES)
        securityDataDource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataDource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataDource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataDource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
        return securityDataDource;
    }

    //need a helper method to read environment property and convert to int
    private int getIntProperty(String propName){
        String propVal= environment.getProperty(propName);
        //convert to Int
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }



}
