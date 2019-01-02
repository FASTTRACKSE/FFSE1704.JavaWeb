package fasttrackse.ffse1704.fbms.service.logwork;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.logwork.QuanLiThoiGianDao;
import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;
import fasttrackse.ffse1704.fbms.entity.logwork.VuDuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.logwork.VuPhongBan;
import fasttrackse.ffse1704.fbms.entity.logwork.VuVaiTroDuAn;

@Service
@Transactional
public class VuLogworkServiceImpl implements VuLogworkService {
	@Autowired
	private QuanLiThoiGianDao quanLiThoiGianDAO;

	public QuanLiThoiGianDao getQuanLiThoiGianDAO() {
		return quanLiThoiGianDAO;
	}

	@Override
	public List<ThoiGianLamViec> findAll() {
		return quanLiThoiGianDAO.findAll();
	}

	@Override
	public void addNew(ThoiGianLamViec logwork) {
		quanLiThoiGianDAO.addNew(logwork);
	}

	@Override
	public void update(ThoiGianLamViec logwork) {
		quanLiThoiGianDAO.update(logwork);
	}

	@Override
	public void delete(int id) {
		quanLiThoiGianDAO.delete(id);
	}

	@Override
	public ThoiGianLamViec findByIdLogwork(int id) {
		return quanLiThoiGianDAO.findByIdLogwork(id);
	}

	@Override
	public List<ThoiGianLamViec> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		return quanLiThoiGianDAO.findAll(iDisplayStart, iDisplayLength, sql);
	}

	@Override
	public String getRecordsTotal() {
		return quanLiThoiGianDAO.getRecordsTotal();
	}

	@Override
	public String getRecordsFiltered(String sql) {
		return quanLiThoiGianDAO.getRecordsFiltered(sql);
	}

	public void setQuanLiThoiGianDAO(QuanLiThoiGianDao quanLiThoiGianDAO) {
		this.quanLiThoiGianDAO = quanLiThoiGianDAO;
	}

	@Override
	public void create(ThoiGianLamViec thoiGianLamViec) {
		quanLiThoiGianDAO.addNew(thoiGianLamViec);
	}

	@Override
	public List<VuPhongBan> listPhongBan() {
		return quanLiThoiGianDAO.listPhongBan();
	}

	@Override
	public List<VuDuAnLogwork> listDuAn() {
		return quanLiThoiGianDAO.listDuAn();
	}

	@Override
	public List<VuVaiTroDuAn> listVaiTroDuAn() {
		return quanLiThoiGianDAO.listVaiTroDuAn();
	}
	@Override
	public List<ThoiGianLamViec> listOneMonth(String month) {
		return quanLiThoiGianDAO.listOneMonth(month);
	}
	@Override
	public List<ThoiGianLamViec> listTheoTrangThai(int maTrangThai) {
		return quanLiThoiGianDAO.listTheoTrangThai(maTrangThai);
	}
}
