package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq.SoNgayNghiPhepDaoMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.SoNgayNghiMinhtq;

@Service
@Transactional
public class SoNgayNghiPhepServiceILMMinhtq  implements SoNgayNghiPhepServiceMinhtq{
	@Autowired
	SoNgayNghiPhepDaoMinhtq soNgayNghiPhepDao;

	public SoNgayNghiPhepDaoMinhtq getSoNgayNghiPhepDao() {
		return soNgayNghiPhepDao;
	}

	public void setSoNgayNghiPhepDao(SoNgayNghiPhepDaoMinhtq soNgayNghiPhepDao) {
		this.soNgayNghiPhepDao = soNgayNghiPhepDao;
	}

	@Override
	public void addSoNgayNghiPhep(SoNgayNghiMinhtq songaynghi) {
		soNgayNghiPhepDao.addSoNgayNghiPhep(songaynghi);
		
	}

	@Override
	public SoNgayNghiMinhtq getByIdSoNgayNghi(int id) {
		return soNgayNghiPhepDao.getByIdSoNgayNghi(id);
	}

	@Override
	public List<SoNgayNghiMinhtq> listSoNgayNghi() {
		return soNgayNghiPhepDao.listSoNgayNghi();
	}

	@Override
	public SoNgayNghiMinhtq getNgayNghi(String maNhanVien, String maNgayNghi) {
		return soNgayNghiPhepDao.getNgayNghi(maNhanVien, maNgayNghi);
	}

	@Override
	public void addSNN(String maNhanVien, String maNgayNghi, int soNgayDaNghi) {
		soNgayNghiPhepDao.addSNN(maNhanVien, maNgayNghi, soNgayDaNghi);
		
	}

	@Override
	public boolean chekSongayNghi(String maNhanVien, String maNgayNghi) {
		
		return soNgayNghiPhepDao.chekSongayNghi(maNhanVien, maNgayNghi);
	}

	

	

}
