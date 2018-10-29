package ffse1704.jsfstaff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ffse1704.jsfstaff.entity.User;

import ffse1704.jsfstaff.util.ConnectionFactory;

public class LoginDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public LoginDAO() {
		super();
	}
	
	private void close(Connection connection, PreparedStatement preparedStatement) {
		close(connection, preparedStatement, null);
	}

	private void close(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connection != null) {
				connection.close();
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public int checkLogin(String userName, String passWord) {
		int log = 0;
		String query = "SELECT COUNT(*) as totalmember FROM user WHERE user=? and password=?";
		
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				log=rs.getInt("totalmember");
				}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
		
		return log;
	}
}
