/**
 * 
 */
package fasttrackse.ffse1704.fbms.dao.quanlyduan.trangthaiduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.trangthaiduan.TrangThaiDuAn;

/**
 * @author QuangDai
 *
 */
@Repository
public class TrangThaiDuAnDaoImpl implements TrangThaiDuAnDao {
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
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.trangthaiduan.TrangThaiDuAnDao#
	 * listTrangThaiDuAn(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiDuAn> listTrangThaiDuAn(int iDisPlayStart, int iDinPlayLength) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<TrangThaiDuAn> listTrangThaiDuAn = session.createQuery("FROM trang_thai_du_an")
				.setFirstResult(iDisPlayStart).setMaxResults(iDinPlayLength).list();
		return listTrangThaiDuAn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.trangthaiduan.TrangThaiDuAnDao#
	 * countTrangThaiDuAn()
	 */
	@Override
	public int countTrangThaiDuAn() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from trang_thai_du_an").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.trangthaiduan.TrangThaiDuAnDao#
	 * addNew(fasttrackse.ffse1704.fbms.entity.quanlyduan.trangthaiduan.
	 * TrangThaiDuAn)
	 */
	@Override
	public void addNew(TrangThaiDuAn tt) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.trangthaiduan.TrangThaiDuAnDao#
	 * update(fasttrackse.ffse1704.fbms.entity.quanlyduan.trangthaiduan.
	 * TrangThaiDuAn)
	 */
	@Override
	public void update(TrangThaiDuAn tt) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(tt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.trangthaiduan.TrangThaiDuAnDao#
	 * delete(java.lang.String)
	 */
	@Override
	public void delete(String maTrangThai) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		TrangThaiDuAn tt = session.load(TrangThaiDuAn.class, maTrangThai);
		if (null != tt) {
			session.delete(tt);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.trangthaiduan.TrangThaiDuAnDao#
	 * getTrangThaiDuAnByMaTrangThaiDuAn(java.lang.String)
	 */
	@Override
	public TrangThaiDuAn getTrangThaiDuAnByMaTrangThaiDuAn(String maTrangThai) {
		Session session = this.sessionFactory.getCurrentSession();
		TrangThaiDuAn tt = (TrangThaiDuAn) session.get(TrangThaiDuAn.class, maTrangThai);
		return tt;
	}

}
