package ffse1704.quanlysinhvien.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ffse1704.quanlysinhvien.entity.DiemSinhVien;
import ffse1704.quanlysinhvien.entity.SinhVien;

@Repository(value = "sinhVienDAOITF")
@Transactional(rollbackFor = Exception.class)
public class SinhVienDAOITF implements SinhVienDAO {
	@Autowired
	SessionFactory sessionFactory;



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(SinhVien sinhvien) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(sinhvien);
		
	}

	
	public SinhVien findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien u = (SinhVien) session.get(SinhVien.class, id);
		return u;
	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}
	

	public void edit(SinhVien sinhvien) {
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(sinhvien);
		tx.commit();
		session.close();
	}

	
	

	@SuppressWarnings("unchecked")
	public List<SinhVien> listSinhVien() {
		Session session = sessionFactory.getCurrentSession();
		List<SinhVien> list = session.createQuery("from SinhVien ").list();
	
		return list;
	}

	

	@SuppressWarnings("unchecked")
	public List<SinhVien> findAll(Integer offset, Integer maxResult) {
		Session session = sessionFactory.getCurrentSession();
		List<SinhVien> sinhvien = session.createQuery("from SinhVien").setFirstResult(offset).setMaxResults(maxResult).list();
		return sinhvien;
	}


	public int count() {

		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from SinhVien").list().size();
		return rowCount;
		
	}

	




}