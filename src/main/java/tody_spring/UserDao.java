package tody_spring;

import tody_spring.domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao {
    public void add(User user) throws SQLException {
        Map<String, String> env = System.getenv();
        Connection connection = DriverManager.getConnection(
                env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD")
        );

        PreparedStatement p = connection.prepareStatement(
                "insert into users(id,name,password) values(?,?,?);"
        );
        p.setString(1, user.getId());
        p.setString(2, user.getName());
        p.setString(3, user.getPassword());
        p.executeUpdate();

        p.close();
        connection.close();
    }

    public User findById(String id) throws SQLException {
        Map<String, String> env = System.getenv();
        Connection connection = DriverManager.getConnection(
                env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD")
        );

        PreparedStatement p = connection.prepareStatement(
                "select * from users where id =?;"
        );
        p.setString(1, id);

        ResultSet r = p.executeQuery();
        r.next();
        User user = new User(r.getString("id"), r.getString("name"), r.getString("password"));
        return user;
    }
}