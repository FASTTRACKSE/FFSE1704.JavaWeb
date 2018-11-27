package fasttrackse.ffse1704.fbms.dao.security;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Repository
public class PhongBanDaoImpl implements PhongBanDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> findAll() {
		Session session = this.sessionFactory.openSession();
		List<PhongBan> list = session.createQuery("from PhongBan").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(PhongBan pb) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(pb);
		tx.commit();
		session.close();
	}

	@Override
	public void update(PhongBan pb) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(pb);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(String maPhongBan) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(PhongBan.class, maPhongBan));
		pb.commit();
		session.close();
	}

	@Override
	public PhongBan findByMaPhongBan(String maPhongBan) {
		Session session = this.sessionFactory.openSession();
		PhongBan pb = session.get(PhongBan.class, maPhongBan);
		session.close();
		return pb;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();

		String sql = "SELECT COUNT(*) FROM `phong_ban`";
		Query query = session.createSQLQuery(sql);

		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<PhongBan> listPhongBan = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		session.close();
		return listPhongBan;
	}
	
	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select pb", "select count(*)"));
		String recordsFiltered = query.getSingleResult().toString();
		session.close();
		return recordsFiltered;
	}

}
