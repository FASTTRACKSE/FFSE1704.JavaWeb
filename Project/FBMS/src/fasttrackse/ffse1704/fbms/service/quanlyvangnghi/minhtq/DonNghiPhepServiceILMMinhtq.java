package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq.DonNghiPhepDaoMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;

@Service
@Transactional
public class DonNghiPhepServiceILMMinhtq implements DonNghiPhepServiceMinhtq {

	@Autowired
	DonNghiPhepDaoMinhtq donNghiPhepDao;

	public DonNghiPhepDaoMinhtq getDonNghiPhepDao() {
		return donNghiPhepDao;
	}

	public void setDonNghiPhepDao(DonNghiPhepDaoMinhtq donNghiPhepDao) {
		this.donNghiPhepDao = donNghiPhepDao;
	}

	
	
	
	@Override
	public List<DonNghiPhepMinhtq> listDonNghiPhepNhap(String trangthai) {
		return donNghiPhepDao.listDonNghiPhepNhap(trangthai);
	}

	@Override
	public DonNghiPhepMinhtq getByIdDonNghiPhep(int id) {
		// TODO Auto-generated method stub
		return donNghiPhepDao.getByIdDonNghiPhep(id);
	}
	
	@Override
	public void deleteDonNghiPhepNhap(int id) {
		donNghiPhepDao.deleteDonNghiPhepNhap(id);
	}


	@Override
	public void editDonNghiPhepNhap(DonNghiPhepMinhtq donnghiphepnhap) {
		donNghiPhepDao.editDonNghiPhepNhap(donnghiphepnhap);
		
	}

	@Override
	public void addDonNghiPhepNhap(DonNghiPhepMinhtq donnghiphepnhap) {
		donNghiPhepDao.addDonNghiPhepNhap(donnghiphepnhap);
		
	}

	@Override
	public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi() {
	
		return donNghiPhepDao.listLoaiNgayNghi();
	}

	

}