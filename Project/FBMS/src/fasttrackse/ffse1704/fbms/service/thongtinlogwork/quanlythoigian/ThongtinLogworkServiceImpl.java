package fasttrackse.ffse1704.fbms.service.thongtinlogwork.quanlythoigian;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.thongtinlogwork.quanlythoigian.ThongTinLogworkDAO;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinPhongBan;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.TrangThaiThongTinLogwork;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ListTenDuAn;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinLogwork;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinNhanVienPhuongNH;
import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.VaiTroDuAn;
import fasttrackse.ffse1704.fbms.service.security.DatatableService;

@Service
public class ThongtinLogworkServiceImpl implements ThongTinLogworkService {

	@Autowired
	private ThongTinLogworkDAO logworkDao;
	@Autowired
	private DatatableService datatableService;

	@Override
	public List<ThongTinLogwork> findAll() {
		return logworkDao.findAll();
	}

	@Override
	public List<ThongTinPhongBan> listDSPhongBan() {
		return logworkDao.listDSPhongBan();
	}

	@Override
	public List<VaiTroDuAn> listVaiTro() {
		return logworkDao.listVaiTro();
	}
	@Override
	public List<ListTenDuAn> listTenDuAn() {
		return logworkDao.listTenDuAn();
	}

	@Override
	public void addNew(ThongTinLogwork lw) {
		logworkDao.addNew(lw);
	}

	@Override
	public void update(ThongTinLogwork lw) {
		logworkDao.update(lw);
	}

	@Override
	public void delete(String id) {
		logworkDao.delete(id);
	}

	@Override
	public ThongTinLogwork findByIdLogwork(int id) {
		return logworkDao.findByIdLogwork(id);
	}

	@Override
	public List<ThongTinLogwork> findAll(int iDisplayStart, int iDisplayLength, String sql) {
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
		String selectQuery = "select pb from PhongBan pb ";
		String[] columnNames = { "pb.maPhongBan", "pb.tenPhongBan" };
		String customCondition = "1=1";
		String sql = datatableService.getSqlQuery(selectQuery, request, columnNames, customCondition);
		return sql;
	}

	/*
	 * @Override public String toJson(ThongTinLogwork pb) { String maPhongBan =
	 * pb.getMaPhongBan(); String tenPhongBan = pb.getTenPhongBan(); String action =
	 * "<a href='/ffse-fbms/QuanTriHeThong/phong_ban/view/" + maPhongBan +
	 * "'><i class='fa fa-eye'></i></a>" +
	 * "<a href='/ffse-fbms/QuanTriHeThong/phong_ban/edit/" + maPhongBan +
	 * "'><i class='fa fa-pencil'></i></a>" +
	 * "<a href='javascript:void(0);' data-toggle='modal' data-target='#confirm-delete' data-href='/ffse-fbms/QuanTriHeThong/phong_ban/delete/"
	 * +maPhongBan + "'><i class='fa fa-trash'></i></a>";
	 * 
	 * return "[\"" + maPhongBan + "\",\"" + tenPhongBan + "\",\"" + action + "\"]";
	 * }
	 */

}
