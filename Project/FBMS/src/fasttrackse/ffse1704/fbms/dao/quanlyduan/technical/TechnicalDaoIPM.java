package fasttrackse.ffse1704.fbms.dao.quanlyduan.technical;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.technical.Technical;

/**
 * @author Joker
 *
 */
@Repository
public class TechnicalDaoIPM implements TechnicalDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addNew(Technical technical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(technical);

	}

	@Override
	public void update(Technical technical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(technical);
	}

	@Override
	public void delete(String matechnical) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(Technical.class, matechnical));
		pd.commit();
		session.close();

	}

	@Override
	public Technical getTechnicalByIdTechnical(String matechnical) {
		Session session = this.sessionFactory.openSession();
		Technical technical = session.get(Technical.class, matechnical);
		session.close();
		return technical;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Technical> listTechnical(int iDisPlayStart, int iDinPlayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Technical> technicalList = session.createQuery("from Technical").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		return technicalList;
	}

	@Override
	public int getRecordsTotal() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Technical").list().size();
		return rowCount;
	}

	@Override
	public int getRecordsByIdTechnical(String matechnical) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Technical where maTechnical='" + matechnical + "'").list().size();
		return rowCount;
	}

}
