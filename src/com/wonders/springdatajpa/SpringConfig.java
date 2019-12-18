package com.wonders.springdatajpa;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;


/**
 * 配置启动类
 * @author zj
 *
 */

@Configuration//声明当前配置类
@ComponentScan(basePackages="com.wonders.springdatajpa.entity")// 扫描当前包 使用 spring 注解
@PropertySource("classpath:datasource.properties")
@EnableJpaRepositories(basePackages="com.wonders.springdatajpa.dao")//扫描 使用 jpa 注解的接口
public class SpringConfig {
	
	//配置数据源
    @Bean
    DataSource dataSource(Environment env) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return  dataSource;
    }
    
    
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //SqlSessionFactory
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){

        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        //加载 实体类
        bean.setPackagesToScan("com.wonders.springdatajpa.entity");
        //设置 适配器
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties properties = new Properties();
        //更新表结构
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        //设置方言
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        bean.setJpaProperties(properties);

        return bean;
    }


}
