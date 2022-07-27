package com.varxyz.banking.account.dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSource.class)
@ComponentScan(basePackages = "com.varxyz.banking.account.dao")
public class AccountConfig {

}
