package ffse1704.JSFStaff.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Execute query database
 * 
 * @author Chicken VIP
 *
 */
public class DatabaseUltil {

	/**
	 * Database config info
	 */
	private static final String HOST_NAME = "localhost";
	private static final String PORT = "3306";
	private static final String DATABASE_NAME = "student_manager";
	private static final String URL_CONNECT = "jdbc:mysql://" + HOST_NAME + ":" + PORT + "/" + DATABASE_NAME;
	private static final String USER = "root";
	private static final String PASS = "";

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
	 * @return 1 if execute success and else
	 */
	public static <E> int executeUpdate(String sql, IPrePareStatementSetParam iPareStatement) {
		int statusExecute = 0;
		Connection conn = getConnect();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			if (iPareStatement != null) {
				iPareStatement.setParameterQuery(statement);
			}

			statusExecute = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect(conn);
		}
		return statusExecute;
	}

	/**
	 * Execute Insert/Update/Delete query
	 * 
	 * @param sql
	 *            Statement query
	 * @return 1 if execute success and else
	 */
	public static <E> int executeUpdate(String sql) {
		return executeUpdate(sql, null);
	}

	/**
	 * Execute Insert/Update/Delete query
	 * 
	 * @param sql
	 *            Statement query
	 * @param iPareStatement
	 * @return true if execute success and else
	 */
	public static <E> boolean execute(String sql, IPrePareStatementSetParam iPareStatement) {
		return executeUpdate(sql, iPareStatement) > 0 ? true : false;
	}

	/**
	 * Execute Insert/Update/Delete query
	 * 
	 * @param sql
	 *            Statement query
	 * @return true if execute success and else
	 */
	public static <E> boolean execute(String sql) {
		return executeUpdate(sql, null) > 0 ? true : false;
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
	 * @return List<E> list entity <E>
	 */
	public static <E> List<E> selectForList(String sql, IPrePareStatementSetParam iPareStatement,
			IPareEntity<E> pareEntity) {
		List<E> listResult = new ArrayList<E>();
		Connection conn = getConnect();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			if (iPareStatement != null) {
				iPareStatement.setParameterQuery(statement);
			}
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				listResult.add(pareEntity.pare(result));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnect(conn);
		}

		return listResult;
	}

	/**
	 * Execute Select query not where condition
	 * 
	 * @param sql
	 *            Statement query
	 * @param mapParam
	 *            Map value for set data to PrePareStatement
	 * @param iPareStatement
	 *            Callback for process set value to statement query
	 * @param pareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @return <E> list entity <E>
	 */
	public static <E> List<E> selectForList(String sql, IPareEntity<E> pareEntity) {
		return selectForList(sql, null, pareEntity);
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
	 * @return <E> Entity <E>
	 */
	public static <E> E selectForObject(String sql, IPrePareStatementSetParam iPareStatement,
			IPareEntity<E> pareEntity) {
		List<E> result = selectForList(sql, iPareStatement, pareEntity);
		return result.size() == 0 ? null : result.get(0);
	}

	/**
	 * Execute Select query not where condition
	 * 
	 * @param sql
	 *            Statement query
	 * @param mapParam
	 *            Map value for set data to PrePareStatement
	 * @param iPareStatement
	 *            Callback for process set value to statement query
	 * @param pareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @return <E> Entity <E>
	 */
	public static <E> E selectForObject(String sql, IPareEntity<E> pareEntity) {
		List<E> result = selectForList(sql, null, pareEntity);
		return result.size() == 0 ? null : result.get(0);
	}

	/**
	 * Callback for set ? of statement sql query
	 * 
	 * @author GaLonTon
	 *
	 */
	public static interface IPrePareStatementSetParam {
		void setParameterQuery(PreparedStatement statement) throws SQLException;
	}

	/**
	 * Callback for pare Resultset to Entity
	 * 
	 * @author GaLonTon
	 *
	 * @param <E>
	 */
	public static interface IPareEntity<E> {
		E pare(ResultSet result) throws SQLException;
	}
}
