package codemaster.servlet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Quan_Ly_ATM";
	String userName = "sa";
	String password = "123456";
	Connection connection;

	public Connection connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		return connection;
	}
}
