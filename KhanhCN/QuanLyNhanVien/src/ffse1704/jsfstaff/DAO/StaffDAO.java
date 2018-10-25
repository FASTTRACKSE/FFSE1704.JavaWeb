package ffse1704.jsfstaff.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.jsfstaff.database.ConnectionFactory;
import ffse1704.jsfstaff.entity.NhanVien;
import ffse1704.jsfstaff.entity.TinhThanh;

@ManagedBean
@SessionScoped
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

	public void addNewNhanVien(NhanVien st) {
		String query = "INSERT INTO nhanvien(tenNhanVien,namSinh, gioiTinh, hoKhau, hinhAnh) VALUES(?, ?, ?, ?, ?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, st.getTenNhanVien());
			preparedStatement.setInt(2, st.getNamSinh());
			preparedStatement.setInt(3, st.getGioiTinh());
			preparedStatement.setString(4, st.getHoKhau());
			preparedStatement.setString(5, st.getHinhAnh());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	public void updateNhanVien(NhanVien st) {
		String query = "UPDATE nhanvien SET tenNhanVien=?,namSinh=?, gioiTinh=?, hoKhau=?, hinhAnh=? WHERE id=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, st.getTenNhanVien());
			preparedStatement.setInt(2, st.getNamSinh());
			preparedStatement.setInt(3, st.getGioiTinh());
			preparedStatement.setString(4, st.getHoKhau());
			preparedStatement.setString(5, st.getHinhAnh());
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

	public List<NhanVien> getListNhanVien() {
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();

		String query = "SELECT * FROM nhanvien";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setNamSinh(rs.getInt("namSinh"));
				nhanVien.setGioiTinh(rs.getInt("gioiTinh"));
				nhanVien.setHoKhau(rs.getString("hoKhau"));
				nhanVien.setHinhAnh(rs.getString("hinhAnh"));

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
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setNamSinh(rs.getInt("namSinh"));
				nhanVien.setGioiTinh(rs.getInt("gioiTinh"));
				nhanVien.setHoKhau(rs.getString("hoKhau"));
				nhanVien.setHinhAnh(rs.getString("hinhAnh"));
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

	public List<TinhThanh> getListTinhThanh() {
		List<TinhThanh> dsTinhThanh = new ArrayList<TinhThanh>();

		String query = "SELECT * FROM tinhthanh";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				TinhThanh tinhThanh = new TinhThanh();
				tinhThanh.setMaTinh(rs.getInt("matinh"));
				tinhThanh.setTenTinh(rs.getString("tentinh"));
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

	public List<NhanVien> getListNhanVienByPage(int currPage, int perPage) {
		int start = (currPage - 1) * perPage;
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		String query = "SELECT nhanvien.id , nhanvien.tenNhanVien , nhanvien.namSinh , nhanvien.gioiTinh , tinhthanh.tentinh AS hoKhau , nhanvien.hinhAnh FROM nhanvien INNER JOIN tinhthanh ON nhanvien.hoKhau = tinhthanh.matinh LIMIT " + start + "," + perPage;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setId(rs.getInt("id"));
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setNamSinh(rs.getInt("namSinh"));
				nhanVien.setGioiTinh(rs.getInt("gioiTinh"));
				nhanVien.setHoKhau(rs.getString("hoKhau"));
				nhanVien.setHinhAnh(rs.getString("hinhAnh"));

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

	
}
