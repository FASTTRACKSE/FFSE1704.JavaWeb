package fasttrackse.ffse1704.fbms.service.thongtinlogwork.quanlythoigian;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinLogwork;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinPhongBan;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.VaiTroDuAn;

public interface ThongTinLogworkService {
	public List<ThongTinLogwork> findAll();

	public List<ThongTinPhongBan> listDSPhongBan();

	public List<VaiTroDuAn> listVaiTro();
	
	public void addNew(ThongTinLogwork lw);

	public void update(ThongTinLogwork lw);

	public void delete(String id);

	public ThongTinLogwork findByIdLogwork(String id);

	public List<ThongTinLogwork> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);

	public String getSQL(HttpServletRequest request);

	// public String toJson(ThongTinLogwork pb);
}
