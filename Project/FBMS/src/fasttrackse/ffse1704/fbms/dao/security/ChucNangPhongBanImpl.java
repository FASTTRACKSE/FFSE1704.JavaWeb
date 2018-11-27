package fasttrackse.ffse1704.fbms.dao.security;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.security.ChucNangPhongBan;

@Repository
public class ChucNangPhongBanImpl implements ChucNangPhongBanDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ChucNangPhongBan> findAll() {
		Session session = this.sessionFactory.openSession();
		List<ChucNangPhongBan> list = session.createQuery("from ChucNangPhongBan").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(ChucNangPhongBan cd) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(cd);
		tx.commit();
		session.close();
	}

	@Override
	public void update(ChucNangPhongBan cd) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cd);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(ChucNangPhongBan.class, id));
		pb.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChucNangPhongBan> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from ChucNangPhongBan");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		List<ChucNangPhongBan> list = q.getResultList();
		session.close();
		return list;
	}

	@Override
	public ChucNangPhongBan findById(int id) {
		Session session = this.sessionFactory.openSession();
		ChucNangPhongBan pb = session.get(ChucNangPhongBan.class, id);
		session.close();
		return pb;
	}

}
