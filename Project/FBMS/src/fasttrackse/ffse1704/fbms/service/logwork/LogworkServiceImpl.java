package fasttrackse.ffse1704.fbms.service.logwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.logwork.QuanLiThoiGianDao;
import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;

@Service
public class LogworkServiceImpl implements LogworkService{
	@Autowired
	private QuanLiThoiGianDao quanLiThoiGianDAO;
	

	public QuanLiThoiGianDao getQuanLiThoiGianDAO() {
		return quanLiThoiGianDAO;
	}


	public void setQuanLiThoiGianDAO(QuanLiThoiGianDao quanLiThoiGianDAO) {
		this.quanLiThoiGianDAO = quanLiThoiGianDAO;
	}


	@Override
	public void create(ThoiGianLamViec thoiGianLamViec) {
		quanLiThoiGianDAO.addNew(thoiGianLamViec);
	}
}
