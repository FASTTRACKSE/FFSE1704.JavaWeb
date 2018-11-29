package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.dao.quanlynhansu.NhanSuDao;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

@Service
@Transactional
public class NhanSuServiceImpl implements NhanSuService {
	@Autowired
	NhanSuDao nhanSuDao;


	public NhanSuDao getNhanSuDao() {
		return nhanSuDao;
	}


	public void setNhanSuDao(NhanSuDao nhanSuDao) {
		this.nhanSuDao = nhanSuDao;
	}


	@Override
	public List<NhanSu> allNS() {
		return nhanSuDao.allNS();
	}

}
