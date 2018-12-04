package fasttrackse.ffse1704.fbms.dao.quanlythoigian;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlythoigian.Logwork;
import fasttrackse.ffse1704.fbms.entity.quanlythoigian.PhongBanLogwork;

@Repository
@Transactional(rollbackFor = Exception.class)
public class LogworkDaolmpl implements LogworkDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Logwork> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Logwork> list = session.createQuery("from Logwork").list();
		return list;
	}

	@Override
	public void addNew(Logwork logwork) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(logwork);
		transaction.commit();
		session.close();

	}

	@Override
	public void update(Logwork logwork) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(logwork);
		;
		transaction.commit();
		session.close();

	}

	@Override
	public void delete(String id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(session.get(Logwork.class, id));
		transaction.commit();
		session.close();

	}

	@Override
	public Logwork findByIdLogwork(String id) {
		Session session = this.sessionFactory.openSession();
		Logwork logwork = session.get(Logwork.class, id);
		session.close();
		return logwork;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Logwork> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<Logwork> listLogwork = session.createQuery(sql).setFirstResult(iDisplayStart).setMaxResults(iDisplayLength)
				.list();
		session.close();
		return listLogwork;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();
		String sql = "SELECT COUNT(*) FROM 'qltg_logwork'";
		Query query = session.createSQLQuery(sql);
		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select logwork", "select count(*)"));
		String recordsFilterd = query.getSingleResult().toString();
		session.close();
 		return recordsFilterd;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PhongBanLogwork> listPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		List<PhongBanLogwork> listPhongBan = session.createQuery("from PhongBanLogwork").getResultList();
		return listPhongBan;
	}
}
