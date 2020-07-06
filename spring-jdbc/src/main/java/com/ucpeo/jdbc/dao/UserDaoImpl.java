package com.ucpeo.jdbc.dao;

import com.ucpeo.jdbc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(final User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "insert  into users(username,sex,age) values(?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getSex());
                preparedStatement.setInt(3, user.getAge());
                return preparedStatement;
            }
        }, keyHolder);
        if (keyHolder.getKey() != null)
            user.setId(keyHolder.getKey().intValue());
    }

    public void delete(final Integer id) {
        jdbcTemplate.execute("delete  from uses where id = ?", new PreparedStatementCallback<Object>() {
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                return null;
            }
        });
    }

    public void update(User user) {
        jdbcTemplate.update("update  users set username = ?,sex=?,age=? where id = ?", user.getUsername(), user.getSex(), user.getAge(), user.getId());
    }

    public User get(Integer id) {
        return jdbcTemplate.queryForObject("select  * from users where id = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user  = new User();
                user.setUsername(resultSet.getString("username"));
                user.setSex(resultSet.getString("sex"));
                user.setId(resultSet.getInt("id"));
                user.setAge(resultSet.getInt("age"));
                return user;
            }
        },id);
    }

    public List<User> list() {
        List<User> userList = new ArrayList<>();
      jdbcTemplate.queryForList("select  * from users ").forEach(u -> {
            User user = new User();
            user.setId((Integer) u.get("id"));
            user.setUsername((String) u.get("username"));
            user.setAge((Integer) u.get("age"));
            user.setSex((String) u.get("sex"));
            userList.add(user);
        });
        return userList;
    }
}
