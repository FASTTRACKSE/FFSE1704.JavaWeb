package fasttrackse.ffse1704.fbms.dao.security;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;

@Repository
public class ChucDanhDaoImpl implements ChucDanhDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChucDanh> findAll() {
		Session session = this.sessionFactory.openSession();
		List<ChucDanh> list = session.createQuery("from ChucDanh").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(ChucDanh cd) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(cd);
		tx.commit();
		session.close();
	}

	@Override
	public void update(ChucDanh cd) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cd);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(String maChucDanh) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(ChucDanh.class, maChucDanh));
		pb.commit();
		session.close();
	}

	@Override
	public ChucDanh findByMaChucDanh(String maChucDanh) {
		Session session = this.sessionFactory.openSession();
		ChucDanh pb = session.get(ChucDanh.class, maChucDanh);
		session.close();
		return pb;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ChucDanh> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<ChucDanh> listChucDanh = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		session.close();
		return listChucDanh;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();

		String sql = "SELECT COUNT(*) FROM `chuc_danh`";
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
