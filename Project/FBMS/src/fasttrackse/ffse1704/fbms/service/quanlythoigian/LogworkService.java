package fasttrackse.ffse1704.fbms.service.quanlythoigian;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;

public interface LogworkService {
	public List<Logwork> findAll();

	public void addNew(Logwork logwork);

	public void update(Logwork logwork);

	public void delete(String id);

	public Logwork findByIdLogwork(String id);

	public List<Logwork> findAll(int iDisplayStart, int iDisplayLength, String sql);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);

	public String getSQL(HttpServletRequest request);

	/*public String toJson(Logwork logwork);*/
}
