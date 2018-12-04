package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.ChungChiDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;

@Service
@Transactional
public class ChungChiServiceImpl implements ChungChiService {
	@Autowired
	ChungChiDao chungChiDao;

	public void setChungChiDao(ChungChiDao chungChiDao) {
		this.chungChiDao = chungChiDao;
	}

	@Override
	public List<ChungChi> allCC() {
		return chungChiDao.allCC();
	}

	@Override
	@Transactional
	public void addCC(ChungChi cc) {
		this.chungChiDao.addCC(cc);
	}

	@Override
	public void updateCC(ChungChi cc) {
		this.chungChiDao.updateCC(cc);
	}
	
	@Override
	public void deleteCC(ChungChi cc) {
		this.chungChiDao.deleteCC(cc);
	}

	@Override
	public ChungChi getChungChiById(int id) {
		return this.chungChiDao.getChungChiById(id);
	}

	@Override
	public List<ChungChi> getEmployeesByPage(int pageid, int total) {
		return this.chungChiDao.getEmployeesByPage(pageid, total);
	}

	@Override
	public long countSV() {
		return this.chungChiDao.countSV();
	}
}
