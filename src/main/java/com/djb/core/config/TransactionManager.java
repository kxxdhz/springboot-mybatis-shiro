package com.djb.core.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * 事务配置（未使用该配置）
 * @author lvpeng
 * @date 2016年8月3日下午1:51:33
 */
//@Configuration
//@EnableTransactionManagement
public class TransactionManager implements TransactionManagementConfigurer{

	@Autowired
	DataSource dataSource;
	
//    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
