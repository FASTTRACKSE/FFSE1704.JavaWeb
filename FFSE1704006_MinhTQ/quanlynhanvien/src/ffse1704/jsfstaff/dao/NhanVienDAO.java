package ffse1704.jsfstaff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.jsfsatff.entity.NhanVien;
import ffse1704.jsfsatff.entity.TinhThanh;
import ffse1704.jsfstaff.databasse.ConnectionFactory;

@ManagedBean
@SessionScoped
public class NhanVienDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;

	public NhanVienDAO() {
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

	public void add(NhanVien nv) {
		String query = "INSERT INTO danhsachnhanvien(maNhanVien, tenNhanVien, namSinh, gioiTinh, hoKhau,images) VALUES(?,?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nv.getMaNhanVien());
			preparedStatement.setString(2, nv.getTenNhanVien());
			preparedStatement.setString(3, nv.getNamSinh());
			preparedStatement.setString(4, nv.getGioiTinh());
			preparedStatement.setString(5, nv.getHoKhau());
			preparedStatement.setString(6, nv.getImages());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	public void update(NhanVien nv) {
		String query = "UPDATE danhsachnhanvien SET  tenNhanVien=? , namSinh=? , gioiTinh=? , hoKhau=? ,images=? WHERE  maNhanVien=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, nv.getTenNhanVien());
			preparedStatement.setString(2, nv.getNamSinh());
			preparedStatement.setString(3, nv.getGioiTinh());
			preparedStatement.setString(4, nv.getHoKhau());
			preparedStatement.setString(5, nv.getImages());
			preparedStatement.setString(6, nv.getMaNhanVien());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	public void delete(String manhanvien) {
		String query = "DELETE FROM danhsachnhanvien WHERE maNhanVien=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, manhanvien);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	public List<NhanVien> ListNhanVien() {
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		String query = "SELECT danhsachnhanvien.maNhanVien,danhsachnhanvien.tenNhanVien,danhsachnhanvien.namSinh,danhsachnhanvien.gioiTinh,tinhthanh.tentinh AS hoKhau,danhsachnhanvien.images\\r\\n\" + \r\n"
				+ "				\"FROM danhsachnhanvien\\r\\n\" + \r\n"
				+ "				\"INNER JOIN tinhthanh\\r\\n\" + \r\n"
				+ "				\"ON  danhsachnhanvien.hoKhau=tinhthanh.matinh ";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setNamSinh(rs.getString("namSinh"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setHoKhau(rs.getString("hoKhau"));
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

	public NhanVien seachEdit(String id) {
		String query = "SELECT danhsachnhanvien.maNhanVien, danhsachnhanvien.tenNhanVien, danhsachnhanvien.namSinh, danhsachnhanvien.gioiTinh,danhsachnhanvien.hoKhau, danhsachnhanvien.images FROM danhsachnhanvien WHERE maNhanVien=? ";
		NhanVien nhanVien = new NhanVien();

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setNamSinh(rs.getString("namSinh"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setHoKhau(rs.getString("hoKhau"));
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
	
	public NhanVien seachDelete(String id) {
		String query = "SELECT danhsachnhanvien.maNhanVien, danhsachnhanvien.tenNhanVien, danhsachnhanvien.namSinh, danhsachnhanvien.gioiTinh,danhsachnhanvien.hoKhau, danhsachnhanvien.images FROM danhsachnhanvien WHERE maNhanVien=? ";
		NhanVien nhanVien = new NhanVien();

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setNamSinh(rs.getString("namSinh"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setHoKhau(rs.getString("hoKhau"));
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

	public List<TinhThanh> getListTinhThanh() {
		List<TinhThanh> dsTinhThanh = new ArrayList<TinhThanh>();
		String query = "SELECT * FROM tinhthanh";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				TinhThanh tinhThanh = new TinhThanh();
				tinhThanh.setMaTinh(rs.getString("matinh"));
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

	// phân trang

	public int countNhanVien() {
		String query = "SELECT count(*) as totalStaff FROM danhsachnhanvien";
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
		String query = "SELECT danhsachnhanvien.maNhanVien,danhsachnhanvien.tenNhanVien,danhsachnhanvien.namSinh,danhsachnhanvien.gioiTinh,tinhthanh.tentinh AS hoKhau,danhsachnhanvien.images FROM danhsachnhanvien INNER JOIN tinhthanh ON danhsachnhanvien.hoKhau=tinhthanh.matinh LIMIT "
				+ start + "," + perPage;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setNamSinh(rs.getString("namSinh"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setHoKhau(rs.getString("hoKhau"));
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
}
