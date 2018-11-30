package fasttrackse.ffse1704.fbms.dao.logwork;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;

@Repository
public class QuanLiThoiGianDao implements QuanLiThoiGianDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ThoiGianLamViec> findAll() {
		Session session = this.sessionFactory.openSession();
		List<ThoiGianLamViec> list = session.createQuery("from ThoiGianLamViec").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(ThoiGianLamViec thoiGianLamViec) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(thoiGianLamViec);
		transaction.commit();
		session.close();

	}

	@Override
	public void update(ThoiGianLamViec thoiGianLamViec) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(thoiGianLamViec);
		;
		transaction.commit();
		session.close();

	}

	@Override
	public void delete(String id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(session.get(ThoiGianLamViec.class, id));
		transaction.commit();
		session.close();

	}

	@Override
	public ThoiGianLamViec findByIdThoiGianLamViec(String id) {
		Session session = this.sessionFactory.openSession();
		ThoiGianLamViec thoiGianLamViec = session.get(ThoiGianLamViec.class, id);
		session.close();
		return thoiGianLamViec;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ThoiGianLamViec> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<ThoiGianLamViec> listThoiGianLamViec = session.createQuery(sql).setFirstResult(iDisplayStart).setMaxResults(iDisplayLength)
				.list();
		session.close();
		return listThoiGianLamViec;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();
		String sql = "SELECT COUNT(*) FROM 'thoi_gian_lam_viec'";
		Query query = session.createSQLQuery(sql);
		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select thoigianlamviec", "select count(*)"));
		String recordsFilterd = query.getSingleResult().toString();
		session.close();
		return recordsFilterd;
	}
}
