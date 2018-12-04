package fasttrackse.ffse1704.fbms.service.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.security.PhongBanDao;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Service
public class PhongBanServiceImpl implements PhongBanService {

	@Autowired
	private PhongBanDao phongBanDao;
	@Autowired
	private DatatableService datatableService;

	@Override
	public List<PhongBan> findAll() {
		return phongBanDao.findAll();
	}

	@Override
	public void addNew(PhongBan pb) {
		phongBanDao.addNew(pb);
	}

	@Override
	public void update(PhongBan pb) {
		phongBanDao.update(pb);
	}

	@Override
	public void delete(String maPhongBan) {
		phongBanDao.delete(maPhongBan);
	}

	@Override
	public PhongBan findByMaPhongBan(String maPhongBan) {
		return phongBanDao.findByMaPhongBan(maPhongBan);
	}

	@Override
	public List<PhongBan> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		return phongBanDao.findAll(iDisplayStart, iDisplayLength, sql);
	}

	@Override
	public String getRecordsTotal() {
		return phongBanDao.getRecordsTotal();
	}

	@Override
	public String getRecordsFiltered(String sql) {
		return phongBanDao.getRecordsFiltered(sql);
	}

	@Override
	public String getSQL(HttpServletRequest request) {
		String selectQuery = "select pb from PhongBan pb ";
		String[] columnNames = { "pb.maPhongBan", "pb.tenPhongBan" };
		String customCondition = "1=1";
		String sql = datatableService.getSqlQuery(selectQuery, request, columnNames, customCondition);
		return sql;
	}

	@Override
	public String toJson(PhongBan pb) {
		String maPhongBan = pb.getMaPhongBan();
		String tenPhongBan = pb.getTenPhongBan();
		String action = "<a href='/FBMS/QuanTriHeThong/phong_ban/view/" 
				+ maPhongBan + "'><i class='fa fa-eye'></i></a>"
				+ "<a href='/FBMS/QuanTriHeThong/phong_ban/edit/"
				+ maPhongBan + "'><i class='fa fa-pencil'></i></a>"
				+ "<a href='javascript:void(0);' data-toggle='modal' data-target='#confirm-delete' data-href='/FBMS/QuanTriHeThong/phong_ban/delete/"
				+maPhongBan + "'><i class='fa fa-trash'></i></a>";

		return "[\"" + maPhongBan + "\",\"" + tenPhongBan + "\",\"" + action + "\"]";
	}

}
