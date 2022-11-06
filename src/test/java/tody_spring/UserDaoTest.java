package tody_spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tody_spring.connection.AWSConnectionMaker;
import tody_spring.domain.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;
    @Test
    @DisplayName("addAndGet 테스트")
    void addAndGet()throws SQLException {
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        User insert = new User("4","kim","0000");
        userDao.add(insert);
        User select = userDao.findById(insert.getId());
        assertEquals(insert.getId(),select.getId());
    }
}