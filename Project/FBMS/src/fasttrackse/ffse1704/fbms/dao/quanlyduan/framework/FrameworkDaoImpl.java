/**
 * 
 */
package fasttrackse.ffse1704.fbms.dao.quanlyduan.framework;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;

/**
 * @author QuangDai
 *
 */
@Repository
public class FrameworkDaoImpl implements FrameworkDao {
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
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.framework.FrameworkDao#listFramework
	 * (int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Framework> listFramework(int iDisPlayStart, int iDinPlayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Framework> frameworkList = session.createQuery("from Framework").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		return frameworkList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.framework.FrameworkDao#
	 * countFramework()
	 */
	@Override
	public int countFramework() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Framework").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.framework.FrameworkDao#addNew(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework)
	 */
	@Override
	public void addNew(Framework fw) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(fw);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.framework.FrameworkDao#update(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework)
	 */
	@Override
	public void update(Framework fw) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(fw);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.framework.FrameworkDao#delete(java.
	 * lang.String)
	 */
	@Override
	public void delete(String maFramework) {
		/*Session session = this.sessionFactory.openSession();
		Framework fw = session.load(Framework.class, maFramework);
		if (null != fw) {
			session.delete(fw);
		}*/
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(Framework.class, maFramework));
		pd.commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.framework.FrameworkDao#
	 * getFrameworkByMaFramework(java.lang.String)
	 */
	@Override
	public Framework getFrameworkByMaFramework(String maFramework) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Framework> listFramework = session.createQuery("from Framework where maFramework = '" + maFramework + "'", Framework.class)
				.list();
		Framework fw = listFramework.get(0);
		return fw;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.framework.FrameworkDao#
	 * getRecordsByMaFramework(java.lang.String)
	 */
	@Override
	public int getRecordsByMaFramework(String maFramework) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Framework where maFramework='" + maFramework + "'").list().size();
		return rowCount;
	}

}
