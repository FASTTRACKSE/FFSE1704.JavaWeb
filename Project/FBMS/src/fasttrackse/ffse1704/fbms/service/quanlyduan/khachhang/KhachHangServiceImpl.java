/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.khachhang;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.khachhang.KhachHangDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang;

/**
 * @author QuangDai
 *
 */
@Service
public class KhachHangServiceImpl implements KhachHangService {
	@Autowired
	private KhachHangDao khachHangDao;

	public KhachHangDao getKhachHangDao() {
		return khachHangDao;
	}

	public void setKhachHangDao(KhachHangDao khachHangDao) {
		this.khachHangDao = khachHangDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.khachhang.KhachHangService#
	 * listKhachHang(int, int)
	 */
	@Override
	@Transactional
	public List<KhachHang> listKhachHang(int iDisPlayStart, int iDinPlayLength) {
		return this.khachHangDao.listKhachHang(iDisPlayStart, iDinPlayLength);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.khachhang.KhachHangService#
	 * countKhachHang()
	 */
	@Override
	@Transactional
	public int countKhachHang() {
		return this.khachHangDao.countKhachHang();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.khachhang.KhachHangService#
	 * addNew(fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang)
	 */
	@Override
	@Transactional
	public void addNew(KhachHang kh) {
		this.khachHangDao.addNew(kh);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.khachhang.KhachHangService#
	 * update(fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang)
	 */
	@Override
	@Transactional
	public void update(KhachHang kh) {
		this.khachHangDao.update(kh);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.khachhang.KhachHangService#
	 * delete(java.lang.String)
	 */
	@Override
	@Transactional
	public void delete(String maKhachHang) {
		this.khachHangDao.delete(maKhachHang);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.khachhang.KhachHangService#
	 * getKhachHangByMaKhachHang(java.lang.String)
	 */
	@Override
	@Transactional
	public KhachHang getKhachHangByMaKhachHang(String maKhachHang) {
		return this.khachHangDao.getKhachHangByMaKhachHang(maKhachHang);
	}

}
