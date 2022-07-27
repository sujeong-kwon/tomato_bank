package com.varxyz.banking.jdbc;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSource.class)
@ComponentScan(basePackages = "com.varxyz.banking")
public class BankingConfig {

}
