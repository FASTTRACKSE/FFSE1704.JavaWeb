/**
 * 
 */
package fasttrackse.ffse1704.fbms.dao.quanlyduan.thongtinduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;

/**
 * @author QuangDai
 *
 */
@Repository
public class ThongTinDuAnDaoImpl implements ThongTinDuAnDao {
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
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.thongtinduan.ThongTinDuAnDao#
	 * listThongTinDuAn(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinDuAn> listThongTinDuAn(int iDisPlayStart, int iDinPlayLength) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<ThongTinDuAn> listThongTinDuAn = session.createQuery("FROM quan_ly_thong_tin_du_an")
				.setFirstResult(iDisPlayStart).setMaxResults(iDinPlayLength).list();
		return listThongTinDuAn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.thongtinduan.ThongTinDuAnDao#
	 * countThongTinDuAn()
	 */
	@Override
	public int countThongTinDuAn() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from quan_ly_thong_tin_du_an").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.thongtinduan.ThongTinDuAnDao#addNew(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn)
	 */
	@Override
	public void addNew(ThongTinDuAn tt) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.thongtinduan.ThongTinDuAnDao#update(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn)
	 */
	@Override
	public void update(ThongTinDuAn tt) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.thongtinduan.ThongTinDuAnDao#delete(
	 * java.lang.String)
	 */
	@Override
	public void delete(String maDuAn) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		ThongTinDuAn tt = session.load(ThongTinDuAn.class, maDuAn);
		if (null != tt) {
			session.delete(tt);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.thongtinduan.ThongTinDuAnDao#
	 * getThongTinDuAnByMaThongTinDuAn(java.lang.String)
	 */
	@Override
	public ThongTinDuAn getThongTinDuAnByMaThongTinDuAn(String maDuAn) {
		Session session = this.sessionFactory.getCurrentSession();
		ThongTinDuAn tt = (ThongTinDuAn) session.get(ThongTinDuAn.class, maDuAn);
		return tt;
	}

}
