package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.tuanpt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.tuanpt.QuanLyVangNghiDao;
import fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn.DonNghi;

@Service
public class DonNghiServiceImpl implements DonNghiService{

	@Autowired
	private QuanLyVangNghiDao quanLyVangNghiDao;
	
	public QuanLyVangNghiDao getQuanLyVangNghiDao() {
		return quanLyVangNghiDao;
	}

	public void setQuanLyVangNghiDao(QuanLyVangNghiDao quanLyVangNghiDao) {
		this.quanLyVangNghiDao = quanLyVangNghiDao;
	}
	
	@Override
	public List<DonNghi> getAllDonNghi(){
		return quanLyVangNghiDao.listDonNghi();
	}
}
