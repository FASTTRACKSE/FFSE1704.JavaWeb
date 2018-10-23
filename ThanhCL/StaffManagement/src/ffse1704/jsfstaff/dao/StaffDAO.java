package ffse1704.jsfstaff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ffse1704.jsfstaff.entity.Staff;
import ffse1704.jsfstaff.entity.TinhThanhPho;
import ffse1704.jsfstaff.util.ConnectionFactory;

public class StaffDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;

	public StaffDAO() {
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

	public void addNewNhanVien(Staff st) {
		String query = "INSERT INTO staff(hoten, namsinh, gioitinh, hokhau, anhthe) VALUES(?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoTen());
			preparedStatement.setInt(2, st.getNamSinh());
			preparedStatement.setInt(3, st.getGioiTinh());
			preparedStatement.setInt(4, st.getHoKhauId());
			preparedStatement.setString(5, st.getAnhThe());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	public void updateNhanVien(Staff st) {
		String query = "UPDATE staff set hoten=?, namsinh=?, gioitinh=?, hokhau=?, anhthe=? WHERE id=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoTen());
			preparedStatement.setInt(2, st.getNamSinh());
			preparedStatement.setInt(3, st.getGioiTinh());
			preparedStatement.setInt(4, st.getHoKhauId());
			preparedStatement.setString(5, st.getAnhThe());
			preparedStatement.setInt(6, st.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	public void deleteNhanVien(int id) {
		String query = "DELETE FROM staff WHERE id=?";
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

	public Staff getNhanVienById(int id) {
		String query = "SELECT * FROM staff WHERE id=?";
		Staff nhanVien = new Staff();

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setHoTen(rs.getString("hoten"));
				nhanVien.setNamSinh(rs.getInt("namsinh"));
				nhanVien.setGioiTinh(rs.getInt("gioitinh"));
				nhanVien.setHoKhauId(rs.getInt("hokhau"));
				nhanVien.setAnhThe(rs.getString("anhthe"));
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

	public List<Staff> getListNhanVien() {
		List<Staff> dsNhanVien = new ArrayList<Staff>();
		String query = "SELECT * FROM staff";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Staff nhanVien = new Staff();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setHoTen(rs.getString("hoten"));
				nhanVien.setNamSinh(rs.getInt("namsinh"));
				nhanVien.setGioiTinh(rs.getInt("gioitinh"));
				nhanVien.setHoKhauId(rs.getInt("hokhau"));
				nhanVien.setAnhThe(rs.getString("anhthe"));

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
		String query = "SELECT count(*) as totalStaff FROM staff";
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

	public List<Staff> getListNhanVienByPage(int currPage, int perPage) {
		int start = (currPage - 1) * perPage;
		List<Staff> dsNhanVien = new ArrayList<Staff>();
		String query = "SELECT * FROM staff LIMIT " + start + "," + perPage;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Staff nhanVien = new Staff();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setHoTen(rs.getString("hoten"));
				nhanVien.setNamSinh(rs.getInt("namsinh"));
				nhanVien.setGioiTinh(rs.getInt("gioitinh"));
				nhanVien.setHoKhauId(rs.getInt("hokhau"));
				nhanVien.setAnhThe(rs.getString("anhthe"));

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

	public List<TinhThanhPho> getListTinhThanh() {
		List<TinhThanhPho> dsTinhThanh = new ArrayList<TinhThanhPho>();
		String query = "SELECT * FROM tinhthanhpho";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				TinhThanhPho tinhThanh = new TinhThanhPho();
				tinhThanh.setId(rs.getInt("matp"));
				tinhThanh.setTenTinhThanh(rs.getString("name"));

				dsTinhThanh.add(tinhThanh);
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
}
