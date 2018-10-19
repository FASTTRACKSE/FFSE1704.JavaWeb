package ffse1704.jsfstaff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ffse1704.jsfstaff.entity.nhanVien;
import ffse1704.jsfstaff.util.ConnectionFactory;


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
	
	public ArrayList<nhanVien> getAllNhanVien() throws Throwable, SQLException{
		String sql = "SELECT nhanvien.hovaten, nhanvien.namsinh, nhanvien.gioitinh, hokhau.thanhpho, nhanvien.image FROM nhanvien INNER JOIN hokhau WHERE nhanvien.hokhau = hokhau.matp";
		ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
		return getAllNhanVien();
	}
	
	public void addNewNhanVien(nhanVien st) {
		String query = "INSERT INTO nhanvien(hovaten, namsinh, gioitinh, hokhau, image) VALUES(?, ?, ?, ?, ?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoVaTen());
			preparedStatement.setString(2, st.getNamSinh());
			preparedStatement.setString(3, st.getGioiTinh());
			preparedStatement.setString(4, st.getHoKhau());
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

	public void updateNhanVien(nhanVien st) {
		String query = "UPDATE nhanvien SET hovaten=?, namsinh=?, gioitinh=?, hokhau=?, image=? WHERE id=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, st.getHoVaTen());
			preparedStatement.setString(2, st.getNamSinh());
			preparedStatement.setString(3, st.getGioiTinh());
			preparedStatement.setString(4, st.getHoKhau());
			preparedStatement.setString(5, st.getImage());
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
		String query = "DELETE FROM nhanvien WHERE id=?";
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
}
