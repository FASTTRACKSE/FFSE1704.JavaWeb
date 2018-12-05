package fasttrackse.ffse1704.fbms.dao.quanlythoigian;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.PhongBanLogwork;

public interface LogworkDao {
	public List<Logwork> findAll();
	public List<PhongBanLogwork> listPhongBan();

	public void addNew(Logwork logwork);

	public void update(Logwork logwork);

	public void delete(String id);

	public Logwork findByIdLogwork(String id);

	public List<Logwork> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);
}
