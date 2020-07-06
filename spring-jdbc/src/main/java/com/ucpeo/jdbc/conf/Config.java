package com.ucpeo.jdbc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration()
@ComponentScan("com.ucpeo")
@Import(com.ucpeo.config.Config.class)   //导入dataSource 的配置类
public class Config {

    @Bean
    String string(){
        System.out.println("hello");
        return  "hello";
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
