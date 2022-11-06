package tody_spring.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionDB {
    Connection makeConnection()throws SQLException;
}
