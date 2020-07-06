package com.ucpeo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
@Configuration
@ComponentScan("com.ucpeo")
public class Config {
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriver(new Driver());
        dataSource.setUrl("jdbc:mysql:///spring5?serverTimezone=UTC");
        return dataSource;
    }
}
