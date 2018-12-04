package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.khoann;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.khoann.DonNghiPhepDaoKhoann;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhepKhoann;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.LoaiHinhNghiPhepKhoann;

@Service
public class DonNghiPhepServiceImplKhoann implements DonNghiPhepServiceKhoann {

	@Autowired

	DonNghiPhepDaoKhoann donNghiPhepDao;

	public DonNghiPhepDaoKhoann getDonNghiPhepDao() {
		return donNghiPhepDao;
	}

	public void setDonNghiPhepDao(DonNghiPhepDaoKhoann donNghiPhepDao) {
		this.donNghiPhepDao = donNghiPhepDao;
	}

	
	
	
	@Override
	@Transactional
	public List<DonNghiPhepKhoann> listDonNghiPhep() {
		return donNghiPhepDao.listDonNghiPhep();
	}

	@Override
	@Transactional
	public void themDon(DonNghiPhepKhoann hs) {
		// TODO Auto-generated method stub
		donNghiPhepDao.themDon(hs);
	}

	@Override
	@Transactional
	public DonNghiPhepKhoann getNhanVienByID(int maNhanVien) {
		// TODO Auto-generated method stub
		return donNghiPhepDao.getNhanVienByID(maNhanVien);
	}

	@Override
	@Transactional
	public void suaDon(DonNghiPhepKhoann hs) {
		// TODO Auto-generated method stub
		donNghiPhepDao.suaDon(hs);
	}

	@Override
	@Transactional
	public List<LoaiHinhNghiPhepKhoann> danhSachLyDo() {
		// TODO Auto-generated method stub
		return this.donNghiPhepDao.danhSachLyDo();
	}

	
	

}
