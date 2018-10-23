package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.NhanVien;
import model.entity.TinhThanhPho;
import model.util.ConnectionFactory;

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

	public void addNewNhanVien(NhanVien nv) {
		String query = "INSERT INTO nhanvien(name, date, gender, address, images) VALUES(?, ?, ?, ?, ?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nv.getName());
			preparedStatement.setInt(2, nv.getDate());
			preparedStatement.setString(3, nv.getGender());
			preparedStatement.setInt(4, nv.getAddress());
			preparedStatement.setString(5, nv.getImages());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	public void updateNhanVien(NhanVien nv) {
		String query = "UPDATE nhanvien set name=?, date=?, gender=?, address=?, images=? WHERE id=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nv.getName());
			preparedStatement.setInt(2, nv.getDate());
			preparedStatement.setString(3, nv.getGender());
			preparedStatement.setInt(4, nv.getAddress());
			preparedStatement.setString(5, nv.getImages());
			preparedStatement.setInt(6, nv.getId());

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

	public NhanVien getNhanVienById(int id) {
		String query = "SELECT * FROM nhanvien WHERE id=?";
		NhanVien nhanVien = new NhanVien();

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setName(rs.getString("name"));
				nhanVien.setDate(rs.getInt("date"));
				nhanVien.setGender(rs.getString("gender"));
				nhanVien.setAddress(rs.getInt("address"));
				nhanVien.setImages(rs.getString("images"));
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

	public List<NhanVien> getAllStaff() {
		List<NhanVien> arrNV = new ArrayList<NhanVien>();
		String query = "SELECT * FROM nhanvien";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				NhanVien nhanVien = new NhanVien();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setName(rs.getString("name"));
				nhanVien.setDate(rs.getInt("date"));
				nhanVien.setGender(rs.getString("gender"));
				nhanVien.setAddress(rs.getInt("address"));
				
				nhanVien.setImages(rs.getString("images"));

				arrNV.add(nhanVien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
		return arrNV;
	}

	public int countNhanVien() {
		String query = "SELECT count(*) as totalNhanVien FROM nhanvien";
		int totalNhanVien = 0;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				totalNhanVien = rs.getInt("totalNhanVien");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}

		return totalNhanVien;
	}

	public List<NhanVien> getListNhanVienByPage(int currPage, int perPage) {
		int start = (currPage - 1) * perPage;
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		String query = "SELECT nhanvien.id, nhanvien.name, nhanvien.date, nhanvien.gender, nhanvien.address, devvn_tinhthanhpho.name AS addressname, nhanvien.images "
				+ "FROM nhanvien "
				+ "LEFT JOIN devvn_tinhthanhpho "
				+ "ON nhanvien.address=devvn_tinhthanhpho.matp "
				+ "LIMIT " + start + "," + perPage;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setName(rs.getString("name"));
				nhanVien.setDate(rs.getInt("date"));
				nhanVien.setGender(rs.getString("gender"));
				nhanVien.setAddress(rs.getInt("address"));
				nhanVien.setAddressname(rs.getString("addressname"));
				nhanVien.setImages(rs.getString("images"));

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
		List<TinhThanhPho> arrTp = new ArrayList<TinhThanhPho>();
		String query = "SELECT * FROM devvn_tinhthanhpho";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				TinhThanhPho tinhThanh = new TinhThanhPho();
				tinhThanh.setCode(rs.getInt("matp"));
				tinhThanh.setName(rs.getString("name"));

				arrTp.add(tinhThanh);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
		return arrTp;
	}
}