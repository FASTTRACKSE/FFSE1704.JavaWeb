package fasttrackse.ffse1704.fbms.dao.thongtinlogwork.quanlythoigian;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinPhongBan;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.TrangThaiThongTinLogwork;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ListTenDuAn;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinLogwork;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinNhanVienPhuongNH;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.VaiTroDuAn;

public interface ThongTinLogworkDAO {
	public List<ThongTinLogwork> findAll();

	public List<ThongTinPhongBan> listDSPhongBan();
	
	public List<ListTenDuAn> listTenDuAn();

	public List<VaiTroDuAn> listVaiTro();
	
	public void addNew(ThongTinLogwork logwork);

	public void update(ThongTinLogwork logwork);

	public void delete(String id);

	public ThongTinLogwork findByIdLogwork(int id);

	public List<ThongTinLogwork> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);
}
