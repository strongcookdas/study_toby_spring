package tody_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tody_spring.connection.AWSConnectionMaker;

@Configuration
public class UserDaoFactory {

    @Bean
    public UserDao awsUserDao(){
        return new UserDao(new AWSConnectionMaker());
    }
}
