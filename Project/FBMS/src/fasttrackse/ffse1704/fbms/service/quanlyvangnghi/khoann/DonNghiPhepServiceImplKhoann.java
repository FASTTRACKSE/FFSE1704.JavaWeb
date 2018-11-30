package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.khoann;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.khoann.DonNghiPhepDaoKhoann;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhepKhoann;

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
	public List<DonNghiPhepKhoann> listDonNghiPhep() {
		return donNghiPhepDao.listDonNghiPhep();
	}

	
	

}
