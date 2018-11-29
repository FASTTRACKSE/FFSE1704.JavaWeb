package fasttrackse.ffse1704.fbms.service.quanlythoigian;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlythoigian.LogworkDao;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.service.security.DatatableService;

@Service
public class LogworkServicelmpl implements LogworkService {
	@Autowired
	private LogworkDao logworkDao;
	@Autowired
	private DatatableService datatableService;

	@Override
	public List<Logwork> findAll() {
		return logworkDao.findAll();
	}

	@Override
	public void addNew(Logwork logwork) {
		logworkDao.addNew(logwork);
	}

	@Override
	public void update(Logwork logwork) {
		logworkDao.update(logwork);
	}

	@Override
	public void delete(String id) {
		logworkDao.delete(id);
	}

	@Override
	public Logwork findByIdLogwork(String id) {
		return logworkDao.findByIdLogwork(id);
	}

	@Override
	public List<Logwork> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		return logworkDao.findAll(iDisplayStart, iDisplayLength, sql);
	}

	@Override
	public String getRecordsTotal() {
		return logworkDao.getRecordsTotal();
	}

	@Override
	public String getRecordsFiltered(String sql) {
		return logworkDao.getRecordsFiltered(sql);
	}

	@Override
	public String getSQL(HttpServletRequest request) {
		String selectQuery = "select logwork from Logwork logwork ";
		String[] columnNames = { "logwork.id", "logwork.ma_du_an", "logwork.ma_nhan_vien", "logwork.ma_vai_tro",
				"logwork.ma_phong_ban", "logwork.ten_cong_viec", "logwork.mo_ta", "logwork.trang_thai",
				"logwork.thoi_gian_bat_dau", "logwork.thoi_gian_ket_thuc", "logwork.nhan_xet_PM",
				"logwork.nhan_xet_tpp" };
		String customCondition = "1=1";
		String sql = datatableService.getSqlQuery(selectQuery, request, columnNames, customCondition);
		return sql;
	}

	/*@Override
	public String toJson(Logwork logwork) {
		int id = logwork.getId();
		int maDuAn = logwork.getMaDuAn();
		String action = "<a href='/ffse-fbms/QuanTriHeThong/chuc_danh/view/" + maChucDanh
				+ "'><i class='fa fa-eye'></i></a>" + "<a href='/ffse-fbms/QuanTriHeThong/chuc_danh/edit/" + maChucDanh
				+ "'><i class='fa fa-pencil'></i></a>"
				+ "<a href='javascript:void(0);' data-toggle='modal' data-target='#confirm-delete' data-href='/ffse-fbms/QuanTriHeThong/chuc_danh/delete/"
				+ maChucDanh + "'><i class='fa fa-trash'></i></a>";

		return "[\"" + maChucDanh + "\",\"" + tenChucDanh + "\",\"" + action + "\"]";
	}*/

}
