/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.vendor;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.vendor.VendorDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.vendor.Vendor;

/**
 * @author QuangDai
 *
 */
@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDao vendorDao;

	public VendorDao getVendorDao() {
		return vendorDao;
	}

	public void setVendorDao(VendorDao vendorDao) {
		this.vendorDao = vendorDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.vendor.VendorService#listVendor(
	 * int, int)
	 */
	@Override
	@Transactional
	public List<Vendor> listVendor(int iDisPlayStart, int iDinPlayLength) {
		return this.vendorDao.listVendor(iDisPlayStart, iDinPlayLength);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.vendor.VendorService#countVendor
	 * ()
	 */
	@Override
	@Transactional
	public int countVendor() {
		return this.vendorDao.countVendor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.vendor.VendorService#addNew(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.vendor.Vendor)
	 */
	@Override
	@Transactional
	public void addNew(Vendor vd) {
		this.vendorDao.addNew(vd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.vendor.VendorService#update(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.vendor.Vendor)
	 */
	@Override
	@Transactional
	public void update(Vendor vd) {
		this.vendorDao.update(vd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.vendor.VendorService#delete(java
	 * .lang.String)
	 */
	@Override
	@Transactional
	public void delete(String maVendor) {
		this.vendorDao.delete(maVendor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.vendor.VendorService#
	 * getVendorByMaVendor(java.lang.String)
	 */
	@Override
	@Transactional
	public Vendor getVendorByMaVendor(String maVendor) {
		return this.vendorDao.getVendorByMaVendor(maVendor);
	}

}
