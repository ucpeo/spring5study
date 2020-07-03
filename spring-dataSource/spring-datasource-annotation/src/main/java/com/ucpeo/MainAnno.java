package com.ucpeo;


import com.ucpeo.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainAnno {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DataSource dataSource = context.getBean(DataSource.class);
        try {
            Connection connection =dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("insert into users(username,sex,age) values ('admin','男',20)");
            ResultSet resultSet = statement.executeQuery("select * from users ");

            while (resultSet.next()){
                System.out.println("id:"+resultSet.getInt(1) + "  username:"+ resultSet.getString(2)+"  sex:"+resultSet.getString(3) +"   age:"+ resultSet.getInt(4) );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
