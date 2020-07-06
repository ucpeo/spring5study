package com.ucpeo.tx;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;

@Configuration
@Import(com.ucpeo.jdbc.conf.Config.class)
@ComponentScan("com.ucpeo")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Config {
    @Bean
    DataSourceTransactionManager transactionDataSource(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new MyDataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}

class  MyDataSourceTransactionManager extends DataSourceTransactionManager{
    @Override
    protected void doCommit(DefaultTransactionStatus status) {
        super.doCommit(status);
        System.out.println("提交");
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status) {
        super.doRollback(status);
        System.out.println("回滚");
    }
}
