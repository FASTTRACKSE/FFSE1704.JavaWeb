package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.BangCapDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrinhDo;
@Service
@Transactional
public class BangCapServiceImpl implements BangCapService{
	@Autowired
	BangCapDao bangCapDao;

	public BangCapDao getBangCapDao() {
		return bangCapDao;
	}

	
	@Override
	public List<BangCap> viewAll() {
		// TODO Auto-generated method stub
		return this.bangCapDao.viewAll();
	}

	@Override
	public void addBangCap(BangCap bc) {
		this.bangCapDao.addBangCap(bc);
		
	}

	@Override
	public List<BangCap> GetListBangCapByPage(int start, int total) {
		// TODO Auto-generated method stub
		return this.bangCapDao.GetListBangCapByPage(start, total);
	}

	@Override
	public long CountBangCap() {
		// TODO Auto-generated method stub
		return this.bangCapDao.CountBangCap();
	}

	@Override
	public NhanSu getBangCapByID(String id) {
		// TODO Auto-generated method stub
		return this.bangCapDao.getBangCapByID(id);
	}

	@Override
	public void update(BangCap ns) {
		this.bangCapDao.update(ns);
		
	}

	@Override
	public void delete(int id) {
		this.bangCapDao.delete(id);
		
	}

	@Override
	public boolean checkExistMa(String maNS) {
		// TODO Auto-generated method stub
		return bangCapDao.checkExistMa(maNS);
	}


	@Override
	public BangCap getBangCapUpdate(int id) {
		// TODO Auto-generated method stub
		return bangCapDao.getBangCapUpdate(id);
	}


	@Override
	public List<TrinhDo> listTrinhDo() {
		
		return bangCapDao.listTrinhDo();
	}


	@Override
	public BangCap getBangCapIdBangCap(String id) {
		
		return bangCapDao.getBangCapIdBangCap(id);
	}

}
