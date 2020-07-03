package com.ucpeo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dataSource.xml");
        DataSource dataSource = applicationContext.getBean(DataSource.class);
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
