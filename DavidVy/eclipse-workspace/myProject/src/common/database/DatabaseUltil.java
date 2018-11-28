package common.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * Execute query database
 * 
 * @author GaLonTon
 *
 */
public class DatabaseUltil {

	/**
	 * Database config
	 */
	private static final String HOST_NAME = "localhost";
	private static final String DATABASE_NAME = "vidulp05";
	private static final String URL_CONNECT = "jdbc:mysql://" + HOST_NAME + "/" + DATABASE_NAME;
	private static final String USER = "vidulp05";
	private static final String PASS = "123456";

	/**
	 * New connection to database
	 * 
	 * @return Connection
	 */
	private static Connection getConnect() {
		Connection conn = null;
		try {
			Properties properties = new Properties();
			properties.setProperty("user", USER);
			properties.setProperty("password", PASS);
			properties.setProperty("characterEncoding", "UTF-8");

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL_CONNECT, properties);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Close connection to database
	 * 
	 * @param conn
	 *            Connection need close
	 */
	private static void closeConnect(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Execute Insert/Update/Delete query
	 * 
	 * @param sql
	 *            Statement query
	 * @param mapParam
	 *            Map value for set data to PrePareStatement
	 * @param iPareStatement
	 *            Callback for process set value to statement query
	 * @return true if execute success and else
	 */
	public static <E> boolean executeUpdate(String sql, Map<?, ?> mapParam, IPrePareStatement iPareStatement) {
		boolean statusExecute = false;
		Connection conn = getConnect();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			if (iPareStatement != null) {
				iPareStatement.setParameterQuery(mapParam, statement);
			}
			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect(conn);
		}
		return statusExecute;
	}

	/**
	 * Execute Select query
	 * 
	 * @param sql
	 *            Statement query
	 * @param mapParam
	 *            Map value for set data to PrePareStatement
	 * @param iPareStatement
	 *            Callback for process set value to statement query
	 * @param pareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @return ArrayList<E> list entity <E>
	 */
	public static <E> ArrayList<E> executeSelect(String sql, Map<?, ?> mapParam, IPrePareStatement iPareStatement,
			IPareEntity<E> pareEntity) {
		ArrayList<E> list = new ArrayList<E>();
		Connection conn = getConnect();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			if (iPareStatement != null) {
				iPareStatement.setParameterQuery(mapParam, statement);
			}
			ResultSet result = statement.executeQuery();

			if (pareEntity != null) {
				while (result.next()) {
					list.add(pareEntity.pare(result));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect(conn);
		}

		return list;
	}

	/**
	 * Callback for set ? of statement sql query
	 * @author GaLonTon
	 *
	 */
	public static interface IPrePareStatement {
		void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException;
	}

	/**
	 * Callback for pare Resultset to Entity
	 * @author GaLonTon
	 *
	 * @param <E>
	 */
	public static interface IPareEntity<E> {
		E pare(ResultSet result) throws SQLException;
	}
}
