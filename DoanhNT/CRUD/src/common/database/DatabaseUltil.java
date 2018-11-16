package common.database;

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
 * @author ChickenDance
 *
 */
public class DatabaseUltil {

	/**
	 * Database config info
	 */
	private static final String HOST_NAME = "localhost";
	private static final String PORT = "3306";
	private static final String DATABASE_NAME = "quanly_sinhvien";
	private static final String URL_CONNECT = "jdbc:mysql://" + HOST_NAME + ":" + PORT + "/" + DATABASE_NAME;
	private static final String USER = "root";
	private static final String PASS = "";

	/**
	 * Config properties for get connection
	 */
	private static Properties properties;
	static {
		properties = new Properties();
		properties.setProperty("user", USER);
		properties.setProperty("password", PASS);
		properties.setProperty("characterEncoding", "UTF-8");
	}

	/**
	 * New connection to database
	 * 
	 * @return Connection
	 */
	private static Connection getConnect() {
		Connection conn = null;
		try {
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
	 * @param iPareStatement
	 *            Callback for process set value to statement query
	 * @return 1 if execute success and else
	 */
	public static int executeUpdate(String sql, IPrePareStatementSetParam iPareStatement) {
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
	public static int executeUpdate(String sql) {
		return executeUpdate(sql, null);
	}

	/**
	 * Execute Insert/Update/Delete query
	 * 
	 * @param sql
	 *            Statement query
	 * @param values
	 *            Array parameter for set ? to sql
	 * @return 1 if execute success and else
	 */
	public static int executeUpdateWithValues(String sql, final Object... values) {
		return executeUpdate(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				for (int i = 0; i < values.length; i++) {
					statement.setObject(i + 1, values[i]);
				}
			}
		});
	}

	/**
	 * Execute Insert/Update/Delete query
	 * 
	 * @param sql
	 *            Statement query
	 * @param iPareStatement
	 *            Callback for process set value to statement query
	 * @return true if execute success and else
	 */
	public static boolean update(String sql, IPrePareStatementSetParam iPareStatement) {
		return executeUpdate(sql, iPareStatement) > 0 ? true : false;
	}

	/**
	 * Execute Insert/Update/Delete query
	 * 
	 * @param sql
	 *            Statement query
	 * @return true if execute success and else
	 */
	public static boolean update(String sql) {
		return executeUpdate(sql, null) > 0 ? true : false;
	}

	/**
	 * Execute Insert/Update/Delete query
	 * 
	 * @param sql
	 *            Statement query
	 * @param values
	 *            Array parameter for set ? to sql
	 * @return true if execute success and else
	 */
	public static boolean updateWithValue(String sql, final Object... values) {
		return executeUpdate(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				for (int i = 0; i < values.length; i++) {
					statement.setObject(i + 1, values[i]);
				}
			}
		}) > 0 ? true : false;
	}

	/**
	 * Execute Select query
	 * 
	 * @param sql
	 *            Statement query
	 * @param iPareStatement
	 *            Callback for process set value to statement query
	 * @param iPareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @return List<E> list entity <E>
	 */
	public static <E> List<E> selectForList(String sql, IPrePareStatementSetParam iPareStatement,
			IPareEntity<E> iPareEntity) {
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
				listResult.add(iPareEntity.pare(result));
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
	 * @param iPareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @return <E> list entity <E>
	 */
	public static <E> List<E> selectForList(String sql, IPareEntity<E> iPareEntity) {
		return selectForList(sql, null, iPareEntity);
	}

	/**
	 * Execute Select query not where condition
	 * 
	 * @param sql
	 *            Statement query
	 * @param iPareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @param values
	 *            Array parameter for set ? to sql
	 * @return <E> list entity <E>
	 */
	public static <E> List<E> selectForList(String sql, IPareEntity<E> iPareEntity, final Object... values) {
		return selectForList(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				for (int i = 0; i < values.length; i++) {
					statement.setObject(i + 1, values[i]);
				}
			}
		}, iPareEntity);
	}

	/**
	 * Execute Select query
	 * 
	 * @param sql
	 *            Statement query
	 * @param iPareStatement
	 *            Callback for process set value to statement query
	 * @param iPareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @return <E> Entity <E>
	 */
	public static <E> E selectForObject(String sql, IPrePareStatementSetParam iPareStatement,
			IPareEntity<E> iPareEntity) {
		List<E> result = selectForList(sql, iPareStatement, iPareEntity);
		return result.size() == 0 ? null : result.get(0);
	}

	/**
	 * Execute Select query not where condition
	 * 
	 * @param sql
	 *            Statement query
	 * @param iPareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @return <E> Entity <E>
	 */
	public static <E> E selectForObject(String sql, IPareEntity<E> iPareEntity) {
		List<E> result = selectForList(sql, null, iPareEntity);
		return result.size() == 0 ? null : result.get(0);
	}

	/**
	 * Execute Select query not where condition
	 * 
	 * @param sql
	 *            Statement query
	 * @param iPareEntity
	 *            Callback for process pare ResultSet to Entity <E>
	 * @return <E> Entity <E>
	 */
	public static <E> E selectForObject(String sql, IPareEntity<E> iPareEntity, final Object... values) {
		List<E> result = selectForList(sql, new IPrePareStatementSetParam() {
			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				for (int i = 0; i < values.length; i++) {
					statement.setObject(i + 1, values[i]);
				}
			}
		}, iPareEntity);
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
