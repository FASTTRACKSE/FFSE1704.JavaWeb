package ffse1704.JSFStaff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ffse1704.JSFStaff.entity.NhanVien;
import ffse1704.JSFStaff.until.ConnectionFactory;

public class StaffDAO {
	private  Connection connection;
	private  PreparedStatement preparedStatement;

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

	public void addNewSinhVien(NhanVien nv) {
		String query = "INSERT INTO nhanvien(name,birthday,gender,address,images) VALUES(?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, nv.getName());
			preparedStatement.setString(2, nv.getBirthDay());
			preparedStatement.setString(3, nv.getGenDer());
			preparedStatement.setString(4, nv.getAddress());
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
	
	public ArrayList<NhanVien> getAllStaff() {
		ArrayList<NhanVien> arrNV = new ArrayList<NhanVien>();
		String query = "SELECT * FROM nhanvien";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			Statement statement= connection.create(query);
			
			ResultSet rs = preparedStatement.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("id");
				String birthday = rs.getString("birthday");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String images = rs.getString("images");
				NhanVien nv = new NhanVien(id,birthday,gender,address,images);
				
				
				arrNV.add(nv);
			}
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
		return arrNV;
	}
}
