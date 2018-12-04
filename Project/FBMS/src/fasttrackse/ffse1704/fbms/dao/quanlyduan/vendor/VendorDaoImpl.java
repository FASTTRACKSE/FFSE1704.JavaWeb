/**
 * 
 */
package fasttrackse.ffse1704.fbms.dao.quanlyduan.vendor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.vendor.Vendor;

/**
 * @author QuangDai
 *
 */
@Repository
public class VendorDaoImpl implements VendorDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.vendor.VendorDao#listVendor(int,
	 * int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> listVendor(int iDisPlayStart, int iDinPlayLength) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<Vendor> listVendor = session.createQuery("FROM khach_hang").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		return listVendor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.vendor.VendorDao#countVendor()
	 */
	@Override
	public int countVendor() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from khach_hang").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.vendor.VendorDao#addNew(fasttrackse.
	 * ffse1704.fbms.entity.quanlyduan.vendor.Vendor)
	 */
	@Override
	public void addNew(Vendor vd) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(vd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.vendor.VendorDao#update(fasttrackse.
	 * ffse1704.fbms.entity.quanlyduan.vendor.Vendor)
	 */
	@Override
	public void update(Vendor vd) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(vd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.vendor.VendorDao#delete(java.lang.
	 * String)
	 */
	@Override
	public void delete(String maVendor) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		Vendor vd = session.load(Vendor.class, maVendor);
		if (null != vd) {
			session.delete(vd);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.vendor.VendorDao#getVendorByMaVendor
	 * (java.lang.String)
	 */
	@Override
	public Vendor getVendorByMaVendor(String maVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		Vendor vd = (Vendor) session.get(Vendor.class, maVendor);
		return vd;
	}

}
