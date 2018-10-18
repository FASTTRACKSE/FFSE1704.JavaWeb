package ffse1704.jsfstaff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.jsfstaff.entity.Staff;
import ffse1704.jsfstaff.util.ConnectionFactory;

@ManagedBean
@SessionScoped
public class StaffDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;

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

	public List<Staff> getAllStaff() {
		List<Staff> listResult = new ArrayList<Staff>();
		String query = "SELECT QuanLiNhanVien.name, namsinh, province.name, gender, image FROM `QuanLiNhanVien` INNER JOIN province ON province.provinceid = QuanLiNhanVien.provinceid";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				Staff list = new Staff(result.getString("QuanLiNhanVien.name"), result.getInt("namsinh"),
						result.getString("province.name"), result.getString("gender"), result.getString("image"));
				listResult.add(list);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listResult;

	}

	public void addNewStaff(Staff st) {
		String query = "INSERT INTO `QuanLiNhanVien`(`name`, `namsinh`, `dia_chi`, `gender`, `image`) VALUES (?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoTen());
			preparedStatement.setInt(2, st.getNamSinh());
			preparedStatement.setString(3, st.getDiaChi());
			preparedStatement.setString(4, st.getGender());
			preparedStatement.setString(5, st.getImage());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

}
