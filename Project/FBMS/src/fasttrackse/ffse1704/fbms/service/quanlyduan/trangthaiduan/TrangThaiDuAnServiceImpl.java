/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.trangthaiduan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.trangthaiduan.TrangThaiDuAnDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.trangthaiduan.TrangThaiDuAn;

/**
 * @author QuangDai
 *
 */
@Service
public class TrangThaiDuAnServiceImpl implements TrangThaiDuAnService {
	@Autowired
	private TrangThaiDuAnDao trangThaiDuAnDao;

	public TrangThaiDuAnDao getTrangThaiDuAnDao() {
		return trangThaiDuAnDao;
	}

	public void setTrangThaiDuAnDao(TrangThaiDuAnDao trangThaiDuAnDao) {
		this.trangThaiDuAnDao = trangThaiDuAnDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.trangthaiduan.
	 * TrangThaiDuAnService#listTrangThaiDuAn(int, int)
	 */
	@Override
	public List<TrangThaiDuAn> listTrangThaiDuAn(int iDisPlayStart, int iDinPlayLength) {
		return this.trangThaiDuAnDao.listTrangThaiDuAn(iDisPlayStart, iDinPlayLength);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.trangthaiduan.
	 * TrangThaiDuAnService#countTrangThaiDuAn()
	 */
	@Override
	public int countTrangThaiDuAn() {
		return this.trangThaiDuAnDao.countTrangThaiDuAn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.trangthaiduan.
	 * TrangThaiDuAnService#addNew(fasttrackse.ffse1704.fbms.entity.quanlyduan.
	 * trangthaiduan.TrangThaiDuAn)
	 */
	@Override
	public void addNew(TrangThaiDuAn tt) {
		this.trangThaiDuAnDao.addNew(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.trangthaiduan.
	 * TrangThaiDuAnService#update(fasttrackse.ffse1704.fbms.entity.quanlyduan.
	 * trangthaiduan.TrangThaiDuAn)
	 */
	@Override
	public void update(TrangThaiDuAn tt) {
		this.trangThaiDuAnDao.update(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.trangthaiduan.
	 * TrangThaiDuAnService#delete(java.lang.String)
	 */
	@Override
	public void delete(String maTrangThai) {
		this.trangThaiDuAnDao.delete(maTrangThai);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.trangthaiduan.
	 * TrangThaiDuAnService#getTrangThaiDuAnByMaTrangThaiDuAn(java.lang.String)
	 */
	@Override
	public TrangThaiDuAn getTrangThaiDuAnByMaTrangThaiDuAn(String maTrangThai) {
		return this.trangThaiDuAnDao.getTrangThaiDuAnByMaTrangThaiDuAn(maTrangThai);
	}

}
