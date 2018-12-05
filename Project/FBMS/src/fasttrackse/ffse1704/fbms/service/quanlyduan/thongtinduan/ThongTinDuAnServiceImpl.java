/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.thongtinduan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.thongtinduan.ThongTinDuAnDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;

/**
 * @author QuangDai
 *
 */
@Service
public class ThongTinDuAnServiceImpl implements ThongTinDuAnService {
	@Autowired
	private ThongTinDuAnDao thongTinDuAnDao;

	public ThongTinDuAnDao getThongTinDuAnDao() {
		return thongTinDuAnDao;
	}

	public void setThongTinDuAnDao(ThongTinDuAnDao thongTinDuAnDao) {
		this.thongTinDuAnDao = thongTinDuAnDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.thongtinduan.ThongTinDuAnService
	 * #listThongTinDuAn(int, int)
	 */
	@Override
	public List<ThongTinDuAn> listThongTinDuAn(int iDisPlayStart, int iDinPlayLength) {
		return this.thongTinDuAnDao.listThongTinDuAn(iDisPlayStart, iDinPlayLength);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.thongtinduan.ThongTinDuAnService
	 * #countThongTinDuAn()
	 */
	@Override
	public int countThongTinDuAn() {
		return this.thongTinDuAnDao.countThongTinDuAn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.thongtinduan.ThongTinDuAnService
	 * #addNew(fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.
	 * ThongTinDuAn)
	 */
	@Override
	public void addNew(ThongTinDuAn tt) {
		this.thongTinDuAnDao.addNew(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.thongtinduan.ThongTinDuAnService
	 * #update(fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.
	 * ThongTinDuAn)
	 */
	@Override
	public void update(ThongTinDuAn tt) {
		this.thongTinDuAnDao.update(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.thongtinduan.ThongTinDuAnService
	 * #delete(java.lang.String)
	 */
	@Override
	public void delete(String maDuAn) {
		this.thongTinDuAnDao.delete(maDuAn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.thongtinduan.ThongTinDuAnService
	 * #getThongTinDuAnByMaThongTinDuAn(java.lang.String)
	 */
	@Override
	public ThongTinDuAn getThongTinDuAnByMaThongTinDuAn(String maDuAn) {
		return this.thongTinDuAnDao.getThongTinDuAnByMaThongTinDuAn(maDuAn);
	}

}
