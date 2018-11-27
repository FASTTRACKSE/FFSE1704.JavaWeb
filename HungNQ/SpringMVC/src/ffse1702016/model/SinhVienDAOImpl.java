package ffse1702016.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ffse1702016.entity.SinhVien;

@Repository
public class SinhVienDAOImpl implements SinhVienDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addSV(SinhVien p) {
		// TODO Auto-generated method stub
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void update(SinhVien p) {
		// TODO Auto-generated method stub
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = (Session) this.sessionFactory.getCurrentSession();
		SinhVien p = session.load(SinhVien.class, id);
		if (null != p) {
			session.delete(p);
		}
	}

	@Override
	public SinhVien getSinhVienById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien p = (SinhVien) session.get(SinhVien.class, id);
		return p;
	}

	// @Override
	// public List<SinhVien> getAllSinhVien() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> getEmployeesByPage(int pageid, int total) {

		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<SinhVien> listSinhVien = session.createQuery("FROM SinhVien").setFirstResult(pageid).setMaxResults(total)
				.list();
		return listSinhVien;
	}

	@Override
	public long countSV() {
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().createCriteria(SinhVien.class)
				.setProjection(Projections.rowCount()).uniqueResult();

	}


}