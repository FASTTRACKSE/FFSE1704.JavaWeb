package ffse1704.jsfstaff.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import ffse1704.jsfstaff.entity.*;
import ffse1704.jsfstaff.util.ConnectionFactory;

@ManagedBean
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

	public void addNewSinhVien(Staff st) {
		String query = "INSERT INTO quanly_nhanvien(hoTen, gioiTinh, namSinh, hoKhau, anh) VALUES(?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoTen());
			preparedStatement.setString(2, st.getGioiTinh());
			preparedStatement.setInt(3, st.getNamSinh());
			preparedStatement.setInt(4, st.getHoKhau());
			preparedStatement.setString(5, st.getAnh());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	public void updateNewSinhVien(Staff st) {
		String query = "UPDATE quanly_nhanvien SET  hoTen = ?, gioiTinh = ?, namSinh = ?, hoKhau = ?, anh = ? WHERE id=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoTen());
			preparedStatement.setString(2, st.getGioiTinh());
			preparedStatement.setInt(3, st.getNamSinh());
			preparedStatement.setInt(4, st.getHoKhau());
			preparedStatement.setString(5, st.getAnh());
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
		String query = "DELETE FROM quanly_nhanvien WHERE id=?";
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

	public List<Staff> getAllNhanVien() {

		String query = "SELECT * FROM quanly_nhanvien";
		List<Staff> dsnhanvien = new ArrayList<Staff>();
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Staff list = new Staff(rs.getInt("id"), rs.getString("hoTen"), rs.getString("gioiTinh"),
						rs.getInt("namSinh"), rs.getInt("hoKhau"), rs.getString("anh"));
				dsnhanvien.add(list);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
		return dsnhanvien;

	}

	public List<TinhThanh> getListTinhThanh() {
		List<TinhThanh> dsTinhThanh = new ArrayList<TinhThanh>();
		String query = "SELECT * FROM quanly_thanhpho";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				TinhThanh tinhThanh = new TinhThanh();
				tinhThanh.setId(rs.getInt("id"));
				tinhThanh.setThanhPho(rs.getString("thanhPho"));

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

	public Staff getNhanVienById(int id) {
		String query = "SELECT * FROM quanly_nhanvien WHERE id=?";
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
				nhanVien.setGioiTinh(rs.getString("gioitinh"));
				nhanVien.setHoKhau(rs.getInt("hokhau"));
				nhanVien.setAnh(rs.getString("anh"));
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

}
