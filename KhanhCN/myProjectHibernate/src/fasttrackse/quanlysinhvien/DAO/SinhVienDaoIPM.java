package fasttrackse.quanlysinhvien.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.quanlysinhvien.entity.SinhVien;

@Repository
public class SinhVienDaoIPM implements SinhVienDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<SinhVien> listStudent() {
		Session session = sessionFactory.getCurrentSession();
		List<SinhVien> list = session.createQuery("from SinhVien").list();
		return list;
	}
	
	@Override
	public void addStudent(SinhVien sv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sv);
	}

	@Override
	public void editStudent(SinhVien sv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sv);
	}

	@Override
	public SinhVien getSinhVienById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(SinhVien.class, id);
	}

	@Override
	public void deleteSinhVien(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien p = (SinhVien) session.load(SinhVien.class, new Integer(id));
		session.delete(p);
	}
	
	@Override
	public int count() {

		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from SinhVien").list().size();
		return rowCount;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> findAll(Integer offset, Integer maxResult) {
		Session session = sessionFactory.getCurrentSession();
		List<SinhVien> students = session.createQuery("from SinhVien").setFirstResult(offset).setMaxResults(maxResult).list();
		return students;
	}

}
