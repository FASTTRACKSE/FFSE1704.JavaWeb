package fasttrackse.ffse1704.fbms.dao.quanlyduan.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;

/**
 * @author Joker
 *
 */
@Repository
public class DomainIPM implements DomainDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addNew(Domain domain) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(domain);

	}

	@Override
	public void update(Domain domain) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domain);
	}

	@Override
	public void delete(String maDomain) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(Domain.class, maDomain));
		pd.commit();
		session.close();

	}

	@Override
	public Domain getDomainByIdDomain(String maDomain) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Domain> listDomain = session.createQuery("from Domain where maDomain = '" + maDomain + "'", Domain.class)
				.list();
		Domain domain = listDomain.get(0);
		return domain;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> listDomain(int iDisPlayStart, int iDinPlayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Domain> domainList = session.createQuery("from Domain").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		return domainList;
	}

	@Override
	public int getRecordsTotal() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Domain").list().size();
		return rowCount;
	}

	@Override
	public int getRecordsByIdDomain(String maDomain) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Domain where maDomain='" + maDomain + "'").list().size();
		return rowCount;
	}

}
