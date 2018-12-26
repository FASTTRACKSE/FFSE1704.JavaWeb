package fasttrackse.ffse1704.fbms.service.quanlythoigian;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1704.fbms.entity.quanlythoigian.DuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.NhanVienLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.PhongBanLogwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.VaiTroDuAnLogwork;

public interface LogworkService {
	public List<Logwork> findAll();
	
	public List<Logwork> findAllForPaging(int star, int total);
	
	public List<PhongBanLogwork> listPhongBan();
	
	public List<DuAnLogwork> listDuAn();
	
	public List<Logwork> listMonth(int start, int total, String month);
	
	public List<Logwork> listAllMonth(String month);
	
	public List<VaiTroDuAnLogwork> listVaiTroDuAn();
	
	public List<NhanVienLogwork> listNhanVien();

	public void addNew(Logwork logwork);

	public void update(Logwork logwork);

	public void delete(int id);

	public Logwork findByIdLogwork(int id);

	public List<Logwork> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);

	public String getSQL(HttpServletRequest request);

	/*public String toJson(Logwork logwork);*/
}
