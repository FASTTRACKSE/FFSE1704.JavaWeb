package fasttrackse.ffse1704.fbms.dao.thongtinlogwork.quanlythoigian;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinLogwork;

@Repository
public class ThongTinLogworkDAOImpl implements ThongTinLogworkDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinLogwork> findAll() {
		Session session = this.sessionFactory.openSession();
		List<ThongTinLogwork> list = session.createQuery("from ThongTinLogwork").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(ThongTinLogwork logwork) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(logwork);
		transaction.commit();
		session.close();

	}

	@Override
	public void update(ThongTinLogwork logwork) {
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
		session.delete(session.get(ThongTinLogwork.class, id));
		transaction.commit();
		session.close();

	}

	@Override
	public ThongTinLogwork findByIdLogwork(String id) {
		Session session = this.sessionFactory.openSession();
		ThongTinLogwork logwork = session.get(ThongTinLogwork.class, id);
		session.close();
		return logwork;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ThongTinLogwork> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<ThongTinLogwork> listLogwork = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		session.close();
		return listLogwork;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();
		String sql = "SELECT COUNT(*) FROM 'thong_tin_logwork'";
		Query query = session.createSQLQuery(sql);
		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select thong_tin_logwork", "select count(*)"));
		String recordsFilterd = query.getSingleResult().toString();
		session.close();
		return recordsFilterd;
	}
}
