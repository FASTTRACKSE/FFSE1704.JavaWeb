package fasttrackse.ffse1704.fbms.dao.quanlyduan.domain;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.domain.Domain;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;

/**
 * @author Joker
 *
 */
@Repository
public class DomainIPM implements DomainDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> listDomain() {
		Session session = this.sessionFactory.openSession();
		List<Domain> list = ((org.hibernate.Session) session).createQuery("from Domain").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(Domain domain) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(domain);
		tx.commit();
		session.close();

	}

	@Override
	public void update(Domain domain) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(domain);
		tx.commit();
		session.close();

	}

	@Override
	public void delete(String maDomain) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(Framework.class, maDomain));
		pd.commit();
		session.close();

	}

	@Override
	public Domain getDomainByIdDomain(String maDomain) {
		Session session = this.sessionFactory.openSession();
		Domain domain = session.get(Domain.class, maDomain);
		session.close();
		return domain;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> listDomain(int iDisPlayStart, int iDinPlayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<Domain> listFramework = session.createQuery(sql).setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		session.close();
		return listFramework;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();

		String sql = "SELECT COUNT(*) FROM 'domain'";
		Query query = session.createSQLQuery(sql);

		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select cd", "select count(*)"));
		String recordsFiltered = query.getSingleResult().toString();
		session.close();
		return recordsFiltered;
	}

}
