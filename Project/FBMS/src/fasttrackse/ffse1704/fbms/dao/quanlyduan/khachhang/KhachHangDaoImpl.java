/**
 * 
 */
package fasttrackse.ffse1704.fbms.dao.quanlyduan.khachhang;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang;

/**
 * @author QuangDai
 *
 */
@Repository
public class KhachHangDaoImpl implements KhachHangDao {
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
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.khachhang.KhachHangDao#listKhachHang
	 * (int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHang> listKhachHang(int iDisPlayStart, int iDinPlayLength) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<KhachHang> listKhachHang = session.createQuery("FROM khach_hang").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		return listKhachHang;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.khachhang.KhachHangDao#
	 * countKhachHang()
	 */
	@Override
	public int countKhachHang() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from khach_hang").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.khachhang.KhachHangDao#addNew(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang)
	 */
	@Override
	public void addNew(KhachHang kh) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(kh);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.khachhang.KhachHangDao#update(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang)
	 */
	@Override
	public void update(KhachHang kh) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(kh);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.khachhang.KhachHangDao#delete(java.
	 * lang.String)
	 */
	@Override
	public void delete(String maKhachHang) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		KhachHang kh = session.load(KhachHang.class, maKhachHang);
		if (null != kh) {
			session.delete(kh);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.khachhang.KhachHangDao#
	 * getKhachHangByMaKhachHang(java.lang.String)
	 */
	@Override
	public KhachHang getKhachHangByMaKhachHang(String maKhachHang) {
		Session session = this.sessionFactory.getCurrentSession();
		KhachHang kh = (KhachHang) session.get(KhachHang.class, maKhachHang);
		return kh;
	}

}
