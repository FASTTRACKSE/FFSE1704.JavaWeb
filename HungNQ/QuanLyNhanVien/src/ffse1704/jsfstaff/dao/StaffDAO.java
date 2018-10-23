package ffse1704.jsfstaff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ffse1704.jsfstaff.entity.hoKhau;
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
	
	public nhanVien getNhanVienById(int id) {
		String query = "SELECT * FROM nhanvien WHERE id=?";
		nhanVien nhanVien = new nhanVien();

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setHoVaTen(rs.getString("hovaten"));
				nhanVien.setNamSinh(rs.getString("namSinh"));
				nhanVien.setGioiTinh(rs.getString("gioitinh"));
				nhanVien.setHoKhau(rs.getString("hokhau"));
				nhanVien.setImage(rs.getString("image"));
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
	
	public List<nhanVien> getListNhanVien() {
		List<nhanVien> dsNhanVien = new ArrayList<nhanVien>();
		String query = "SELECT * FROM nhanvien";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				nhanVien nhanVien = new nhanVien();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setHoVaTen(rs.getString("hovaten"));
				nhanVien.setNamSinh(rs.getString("namSinh"));
				nhanVien.setGioiTinh(rs.getString("gioitinh"));
				nhanVien.setHoKhau(rs.getString("hokhau"));
				nhanVien.setImage(rs.getString("image"));

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
		String query = "SELECT count(*) as totalStaff FROM nhanvien";
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
	
	public List<nhanVien> getListNhanVienByPage(int currPage, int perPage) {
		int start = (currPage - 1) * perPage;
		List<nhanVien> dsNhanVien = new ArrayList<nhanVien>();
		String query = "SELECT * FROM nhanvien LIMIT " + start + "," + perPage;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				nhanVien nhanVien = new nhanVien();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setHoVaTen(rs.getString("hovaten"));
				nhanVien.setNamSinh(rs.getString("namSinh"));
				nhanVien.setGioiTinh(rs.getString("gioitinh"));
				nhanVien.setHoKhau(rs.getString("hokhau"));
				nhanVien.setImage(rs.getString("image"));

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
	public List<hoKhau> getListTinhThanh() {
		List<hoKhau> dsTinhThanh = new ArrayList<hoKhau>();
		String query = "SELECT * FROM hokhau";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				hoKhau tinhThanh = new hoKhau();
				tinhThanh.setMaTP(rs.getString("matp"));
				tinhThanh.setThanhPho(rs.getString("thanhpho"));

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
