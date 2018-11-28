package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq.DonNghiPhepDao;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhep;

@Service
@Transactional
public class DonNghiPhepServiceILM implements DonNghiPhepService {

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
