package fasttrack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrack.entity.SinhVien;
import fasttrack.entity.TinhThanh;

@Repository()
@Transactional(rollbackFor = Exception.class)
public class SinhVienDaoHBN implements SinhVienDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void add(SinhVien sinhVien) {
		Session session = sessionFactory.getCurrentSession();
		session.save(sinhVien);
	}
	@SuppressWarnings("unchecked")
	public List<SinhVien> listStudent() {
		Session session = sessionFactory.getCurrentSession();
		
		List<SinhVien> list = session.createQuery("from SinhVien").getResultList();
		return list;
	}
	public SinhVien findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien sv = (SinhVien) session.get(SinhVien.class, id);
		return sv;
	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}
	
	@Override
	public void edit(SinhVien sinhVien) {
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(sinhVien);
		tx.commit();
		session.close();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SinhVien> findAllForPaging(int startPosition,int maxResult){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from SinhVien");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		
		return q.list();		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TinhThanh> listTinhThanh() {
		Session session = sessionFactory.getCurrentSession();
		List<TinhThanh> listTinhThanh = session.createQuery("from TinhThanh").getResultList();
		return listTinhThanh;
	}
}