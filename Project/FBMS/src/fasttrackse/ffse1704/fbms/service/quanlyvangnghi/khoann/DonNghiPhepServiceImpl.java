package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.khoann;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.khoann.DonNghiPhepDao;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhep;

@Service
public class DonNghiPhepServiceImpl implements DonNghiPhepService {

	@Autowired
	DonNghiPhepDao donNghiPhepDao;

	public DonNghiPhepDao getDonNghiPhepDao() {
		return donNghiPhepDao;
	}

	public void setDonNghiPhepDao(DonNghiPhepDao donNghiPhepDao) {
		this.donNghiPhepDao = donNghiPhepDao;
	}

	
	
	
	@Override
	public List<DonNghiPhep> listDonNghiPhep() {
		return donNghiPhepDao.listDonNghiPhep();
	}

	
	

}
