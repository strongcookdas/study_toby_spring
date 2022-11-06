package tody_spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tody_spring.connection.AWSConnectionMaker;
import tody_spring.domain.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    @DisplayName("addAndGet 테스트")
    void addAndGet()throws SQLException {
        UserDao userDao = new UserDao(new AWSConnectionMaker());
        User insert = new User("2","kim","0000");
        userDao.add(insert);
        User select = userDao.findById(insert.getId());
        assertEquals(insert.getId(),select.getId());
    }
}