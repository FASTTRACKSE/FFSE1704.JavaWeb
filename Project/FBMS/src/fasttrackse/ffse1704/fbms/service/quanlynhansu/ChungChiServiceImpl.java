package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.ChungChiDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrinhDo;

@Service
@Transactional
public class ChungChiServiceImpl implements ChungChiService {
	@Autowired
	ChungChiDao chungChiDao;

	public void setChungChiDao(ChungChiDao chungChiDao) {
		this.chungChiDao = chungChiDao;
	}

	@Override
	public List<ChungChi> viewAll() {
		return this.chungChiDao.viewAll();
	}

	@Override
	public void addChungChi(ChungChi cc) {
		this.chungChiDao.addChungChi(cc);
	}

	@Override
	public List<ChungChi> GetListChungChiByPage(int start, int total) {
		return this.chungChiDao.GetListChungChiByPage(start, total);
	}

	@Override
	public long CountChungChi() {
		return this.chungChiDao.CountChungChi();
	}

	@Override
	public NhanSu getChungChiByID(String id) {
		return this.chungChiDao.getChungChiByID(id);
	}

	@Override
	public void update(ChungChi cc) {
		this.chungChiDao.update(cc);
	}

	@Override
	public void delete(int id) {
		this.chungChiDao.delete(id);
	}

	@Override
	public boolean checkExistMa(String maNS) {
		return this.chungChiDao.checkExistMa(maNS);
	}

	@Override
	public ChungChi getChungChiUpdate(int id) {
		return this.chungChiDao.getChungChiUpdate(id);
	}

	@Override
	public List<TrinhDo> listTrinhDo() {
		return chungChiDao.listTrinhDo();
	}

	@Override
	public List<BangCap> findMaBangByMaTrinhDo(int IdtrinhDo) {
		return chungChiDao.findMaBangByMaTrinhDo(IdtrinhDo);
	}

	@Override
	public TrinhDo findTenTrinhDoByMaTrinhDo(int maTrinhDo) {
		return chungChiDao.findTenTrinhDoByMaTrinhDo(maTrinhDo);
	}


	

}
