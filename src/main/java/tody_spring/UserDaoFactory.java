package tody_spring;

import tody_spring.connection.AWSConnectionMaker;

public class UserDaoFactory {
    public UserDao awsUserDao(){
        return new UserDao(new AWSConnectionMaker());
    }
}
