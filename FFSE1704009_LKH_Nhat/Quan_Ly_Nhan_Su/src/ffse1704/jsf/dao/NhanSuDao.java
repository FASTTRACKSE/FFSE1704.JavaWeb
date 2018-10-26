package ffse1704.jsf.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.jsf.common.database.DatabaseUltil;
import ffse1704.jsf.common.database.DatabaseUltil.IPareEntity;
import ffse1704.jsf.common.database.DatabaseUltil.IPrePareStatementSetParam;
import ffse1704.jsf.entity.NhanSu;
import ffse1704.jsf.entity.TinhThanh;

@ManagedBean
@SessionScoped
public class NhanSuDao {
	private IPareEntity<NhanSu> iPareEntityNhanSu = new IPareEntity<NhanSu>() {
		public NhanSu pare(ResultSet result) throws SQLException {
			return new NhanSu(result.getString("id"), result.getString("hotennhanvien"), result.getString("namsinh"),
					result.getString("gioitinh"), result.getString("tinhthanh.ten_tinh"), result.getString("avatar"));
		}
	};
	private IPareEntity<NhanSu> iPareEntitySeachNhansu= new IPareEntity<NhanSu>() {
		public NhanSu pare(ResultSet result) throws SQLException {
			return new NhanSu(result.getString("id"), result.getString("hotennhanvien"), result.getString("namsinh"),
					result.getString("gioitinh"), result.getString("hokhau"), result.getString("avatar"));
		}
	};
	
	private IPareEntity<NhanSu> iPareEntityCountMaxID = new IPareEntity<NhanSu>() {
		public NhanSu pare(ResultSet result) throws SQLException {
			return new NhanSu(result.getString("MAX(id)"));
		}
	};
	

	private IPareEntity<TinhThanh> iPareEntityTinhThanh = new IPareEntity<TinhThanh>() {
		public TinhThanh pare(ResultSet result) throws SQLException {
			return new TinhThanh(result.getString("id"), result.getString("ma_tinh"), result.getString("ten_tinh"));
		}
	};
	
	

	public List<TinhThanh> getAllTinhThanh() {
		String sql = "SELECT * FROM tinhthanh";
		List<TinhThanh> arrList = DatabaseUltil.selectForList(sql, iPareEntityTinhThanh);
		return arrList;
	}
	
	public List<NhanSu> getAllNhanSu() {
		String sql = "SELECT nhansu.id, nhansu.hotennhanvien, nhansu.namsinh, nhansu.gioitinh, tinhthanh.ten_tinh, nhansu.avatar FROM nhansu inner join tinhthanh on nhansu.hokhau = tinhthanh.ma_tinh";
		List<NhanSu> arrList = DatabaseUltil.selectForList(sql, iPareEntityNhanSu);
		return arrList;
	}

	public List<NhanSu> ListPageNhanSu(int start, String KT) {
		String sql = "SELECT nhansu.id, nhansu.hotennhanvien, nhansu.namsinh, nhansu.gioitinh, tinhthanh.ten_tinh, nhansu.avatar FROM nhansu inner join tinhthanh on nhansu.hokhau = tinhthanh.ma_tinh  order by id ASC  LIMIT ?,?";
		List<NhanSu> pageNhanSu = DatabaseUltil.selectForList(sql, new IPrePareStatementSetParam() {

			public void setParameterQuery(PreparedStatement statement) throws SQLException {
				statement.setInt(1, start);
				statement.setInt(2, Integer.parseInt(KT));
			}
		}, iPareEntityNhanSu);
		return pageNhanSu;

	}

	public int addNhanSu(final NhanSu nhansu) {
		String sql = "INSERT INTO nhansu(id,hotennhanvien,namsinh,gioitinh,hokhau,avatar) VALUES (?,?,?,?,?,?)";
		return DatabaseUltil.executeUpdateWithValues(sql, nhansu.getId(), nhansu.getHoTen(), nhansu.getNamSinh(),
				nhansu.getGioiTinh(), nhansu.getHoKhau(), nhansu.getAvatar());

	}

	public NhanSu searchNhanSuEdit(final String id) {
		String sql = "SELECT * FROM nhansu  WHERE id=?";
		return DatabaseUltil.selectForObject(sql, iPareEntitySeachNhansu, id);

	}
	
	public NhanSu searchNhanSuDelete(final String id) {
		String sql = "SELECT nhansu.id, nhansu.hotennhanvien, nhansu.namsinh, nhansu.gioitinh, tinhthanh.ten_tinh, nhansu.avatar FROM nhansu inner join tinhthanh on nhansu.hokhau = tinhthanh.ma_tinh   WHERE nhansu.id=?";
		return DatabaseUltil.selectForObject(sql, iPareEntityNhanSu, id);

	}
	
	public NhanSu checkIDMax() {
		String sql = "SELECT MAX(id) FROM nhansu";
		return DatabaseUltil.selectForObject(sql, iPareEntityCountMaxID);
	}

	public int editNhanSu(final NhanSu nhansu) {
		String sql = "UPDATE nhansu SET hotennhanvien=?, namsinh=?, gioitinh=?, hokhau=?, avatar=? WHERE id=?";
		return DatabaseUltil.executeUpdateWithValues(sql, nhansu.getHoTen(), nhansu.getNamSinh(), nhansu.getGioiTinh(),
				nhansu.getHoKhau(), nhansu.getAvatar(), nhansu.getId());

	}

	public int deleteNhanSu(final String id) {
		String sql = "DELETE FROM nhansu WHERE id=? ";
		return DatabaseUltil.executeUpdateWithValues(sql, id);

	}
}
