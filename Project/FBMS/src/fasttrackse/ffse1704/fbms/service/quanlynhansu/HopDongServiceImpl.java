package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import fasttrackse.ffse1704.fbms.dao.quanlynhansu.HopDongDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;

@Service
@Transactional
public class HopDongServiceImpl implements HopDongService {
	@Autowired
	HopDongDao hopDongDao;

	public HopDongDao getHopDongDao() {
		return hopDongDao;
	}

	public void setHopDongDao(HopDongDao hopDongDao) {
		this.hopDongDao = hopDongDao;
	}

	public List<HopDong> listHopDong() {
		return hopDongDao.listHopDong();
	}

	public List<CheDoHuong> listCheDoHuong() {
		return hopDongDao.listCheDoHuong();
	}
	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong) {
		hopDongDao.saveHopDongCheDo(thongtinhopdong);
	}
	public void editHopDong(ThongTinHopDong thongtinhopdong) {
		hopDongDao.editHopDong(thongtinhopdong);
	}
	public ThongTinHopDong findById(int id) {
		return hopDongDao.findById(id);
	}
	public void deleteHopDong(int id) {
		hopDongDao.deleteHopDong(id);
	}

}
