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
import ffse1704.jsfstaff.entity.province;
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
		String query = "SELECT * FROM `QuanLiNhanVien`";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				Staff list = new Staff(
						result.getInt("id"),
						result.getString("name"),
						result.getInt("namsinh"),
						result.getInt("gender"),
						result.getInt("provinceid"),
						result.getString("image"));
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
		String query = "INSERT INTO `QuanLiNhanVien`(`name`, `namsinh`, `provinceid`, `gender`) VALUES (?,?,?,?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoTen());
			preparedStatement.setInt(2, st.getNamSinh());
			preparedStatement.setInt(3, st.getDiaChi());
			preparedStatement.setInt(4, st.getGender());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}
	public void editStaff(Staff st) {
		String query = "UPDATE `QuanLiNhanVien` SET `name`=?,`namsinh`=?,`provinceid`=?,`gender`=? WHERE id=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoTen());
			preparedStatement.setInt(2, st.getNamSinh());
			preparedStatement.setInt(3, st.getDiaChi());
			preparedStatement.setInt(4, st.getGender());
			preparedStatement.setInt(5, st.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}
	public Staff getNhanVienById(int id) {
		String query = "SELECT * FROM QuanLiNhanVien WHERE id=?";
		Staff nhanVien = new Staff();

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setHoTen(rs.getString("name"));
				nhanVien.setNamSinh(rs.getInt("namsinh"));
				nhanVien.setGender(rs.getInt("gender"));
				nhanVien.setDiaChi(rs.getInt("provinceid"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}

		return nhanVien;
	}
	public void deleteNhanVien(int id) {
		String query = "DELETE FROM QuanLiNhanVien WHERE id=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}
	public List<province> getListTinhThanh() {
		List<province> dsTinhThanh = new ArrayList<province>();
		String query = "SELECT * FROM province";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				province dsTinh = new province(
				rs.getString("provinceid"),
				rs.getString("name"));
				dsTinhThanh.add(dsTinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}

		return dsTinhThanh;
	}
	public List<Staff> getListNhanVienByPage(int currPage, int perPage) {
		int start = (currPage - 1) * perPage;
		List<Staff> dsNhanVien = new ArrayList<Staff>();
		String query = "SELECT id, QuanLiNhanVien.name, namsinh, gender, province.name FROM QuanLiNhanVien LEFT JOIN province ON province.provinceid = QuanLiNhanVien.provinceid LIMIT " + start + "," + perPage;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Staff nhanVien = new Staff();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setHoTen(rs.getString("QuanLiNhanVien.name"));
				nhanVien.setNamSinh(rs.getInt("namsinh"));
				nhanVien.setGender(rs.getInt("gender"));
				nhanVien.setTenTinh(rs.getString("province.name"));
				dsNhanVien.add(nhanVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}

		return dsNhanVien;
	}
	public int countNhanVien() {
		String query = "SELECT count(*) as totalStaff FROM QuanLiNhanVien";
		int totalStaff = 0;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				totalStaff = rs.getInt("totalStaff");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}

		return totalStaff;
	}
}
