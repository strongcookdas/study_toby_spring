package tody_spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
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
    UserDao userDao;

    @BeforeEach
    void setUp(){
        this.userDao=context.getBean("awsUserDao", UserDao.class);
    }

    @Test
    @DisplayName("addAndGet 테스트")
    void addAndGet()throws SQLException {
        userDao.deleteAll();
        User insert = new User("1","kim","0000");
        userDao.add(insert);
        User select = userDao.findById(insert.getId());
        assertEquals(insert.getId(),select.getId());
    }

    @Test
    @DisplayName("getCount 테스트")
    void getCount()throws SQLException {
        User user1 = new User("1","kim1","1111");
        User user2 = new User("2","kim2","2222");
        User user3 = new User("3","kim3","3333");

        userDao.deleteAll();
        assertEquals(0,userDao.getCount());

        userDao.add(user1);
        assertEquals(1,userDao.getCount());
        userDao.add(user2);
        assertEquals(2,userDao.getCount());
        userDao.add(user3);
        assertEquals(3,userDao.getCount());
    }

    @Test
    @DisplayName("findById 테스트")
    void findById(){
        assertThrows(EmptyResultDataAccessException.class,()->{
            userDao.findById("30");
        });
    }
}