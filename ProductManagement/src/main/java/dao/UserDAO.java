package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbcutils.JDBCUtils;
import model.User;

public class UserDAO {
	public int registerEmployee(User employee) throws ClassNotFoundException, SQLException{
	    String INSERT_USERS_SQL="INSERT INTO users (first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
			
	    int result=0;
	    Connection connection=null;
			
	    try {
	        connection = JDBCUtils.getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
	        preparedStatement.setString(1, employee.getFirstName());
	        preparedStatement.setString(2, employee.getLastName());
	        preparedStatement.setString(3, employee.getUserName());
	        preparedStatement.setString(4, employee.getPassword());
	        result = preparedStatement.executeUpdate();
	    }
	    catch (SQLException e) {
	        JDBCUtils.printSQLException(e);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	    finally {
	        if(connection != null) {
	            connection.close();
	        }
	    }
	    return result;
	}


}

