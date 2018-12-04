package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.thachmh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.thachmh.DonXinNghiPhepDao;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh.DonXinNghiPhep;

@Service
public class DonXinNghiPhepServiceImpl implements DonXinNghiPhepService {

	@Autowired
	private DonXinNghiPhepDao donXinNghiPhepDao;

	@Override
	@Transactional
	public List<DonXinNghiPhep> getAllDonXinNghiPhep() {
		return donXinNghiPhepDao.getAllDonXinNghiPhep();
	}

	@Override
	@Transactional
	public void addNew(DonXinNghiPhep dx) {
		donXinNghiPhepDao.addNew(dx);

	}

	@Override
	@Transactional
	public void update(DonXinNghiPhep dx) {
		donXinNghiPhepDao.update(dx);
	}

	@Override
	@Transactional
	public DonXinNghiPhep findByidDon(int idDon) {
		return donXinNghiPhepDao.findByidDon(idDon);
	}

}
