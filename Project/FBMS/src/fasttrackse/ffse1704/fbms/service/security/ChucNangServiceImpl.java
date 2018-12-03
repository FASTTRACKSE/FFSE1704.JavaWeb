package fasttrackse.ffse1704.fbms.service.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.security.ChucNangDao;
import fasttrackse.ffse1704.fbms.entity.security.ChucNang;

@Service
public class ChucNangServiceImpl implements ChucNangService {

	@Autowired
	private ChucNangDao chucNangDao;
	@Autowired
	private DatatableService datatableService;

	@Override
	public void save(ChucNang cn) {
		chucNangDao.save(cn);
	}

	@Override
	public void update(ChucNang cn) {
		chucNangDao.update(cn);
	}

	@Override
	public void delete(String ma_chuc_nang) {
		chucNangDao.delete(ma_chuc_nang);
	}

	@Override
	public void active(String ma_chuc_nang) {
		chucNangDao.active(ma_chuc_nang);
	}

	@Override
	public ChucNang getChucNangByCode(String ma_chuc_nang) {
		ChucNang cn = chucNangDao.getChucNangByCode(ma_chuc_nang);
		return cn;
	}
	
	@Override
	public ChucNang findByMaChucNang(String ma_chuc_nang) {
		return chucNangDao.findByMaChucNang(ma_chuc_nang);
	}

	@Override
	public List<ChucNang> findAll() {
		return chucNangDao.findAll();
	}
	
	@Override
	public List<ChucNang> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		return chucNangDao.findAll(iDisplayStart, iDisplayLength, sql);
	}

	@Override
	public String getRecordsTotal() {
		return chucNangDao.getRecordsTotal();
	}

	@Override
	public String getRecordsFiltered(String sql) {
		return chucNangDao.getRecordsFiltered(sql);
	}

	@Override
	public String getSQL(HttpServletRequest request) {
		String selectQuery = "select cn from ChucNang cn ";
		String[] columnNames = { "cn.ma_chuc_nang", "cn.ten_chuc_nang" };
		String customCondition = "1 = 1";
		String sql = datatableService.getSqlQuery(selectQuery, request, columnNames, customCondition);
		return sql;
	}

	@Override
	public String toJson(ChucNang cn) {
		String maChucNang = cn.getMa_chuc_nang();
		String tenChucNang = cn.getTen_chuc_nang();
		int trangThai = cn.getTrang_thai();
		String enable;
		if(trangThai == 1) {
			enable = "<a href='/FBMS/QuanTriHeThong/chuc_nang/active/"+ maChucNang + "'>Đang kích hoạt</a>";
		}else {
			enable = "<a href='/FBMS/QuanTriHeThong/chuc_nang/active/"+ maChucNang + "'>Chưa kích hoạt</a>";
		}
		String action = "<a href='/FBMS/QuanTriHeThong/chuc_nang/view/" 
				+ maChucNang + "'><i class='fa fa-eye'></i></a>"
				+ "<a href='/FBMS/QuanTriHeThong/chuc_nang/edit/"
				+ maChucNang + "'><i class='fa fa-pencil'></i></a>"
				+ "<a href='javascript:void(0);' data-toggle='modal' data-target='#confirm-delete' data-href='/FBMS/QuanTriHeThong/chuc_nang/delete/"
				+maChucNang + "'><i class='fa fa-trash'></i></a>";

		return "[\"" + maChucNang + "\",\"" + tenChucNang + "\",\"" + enable + "\",\"" + action + "\"]";
	}
}
