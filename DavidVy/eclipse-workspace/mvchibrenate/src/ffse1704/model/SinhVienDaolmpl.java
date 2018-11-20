package ffse1704.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ffse1704.entity.SinhVien;
@Repository
public class SinhVienDaolmpl implements SinhVienDao {
	
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
/*	@SuppressWarnings("unchecked")
	public List<SinhVien>  getAllSinhVien() {
		Session session = sessionFactory.getCurrentSession();
		List<SinhVien> list = session.createQuery("from SinhVien").getResultList();
		return list;
	}*/
	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> getAllSinhVien() {
		
		Session session = (Session) this.sessionFactory.getCurrentSession();
		
		List<SinhVien> listSinhVien = session.createQuery("FROM SinhVien").getResultList();
		return listSinhVien;
	}

	/*@Override
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
		if(null !=p) {
			session.delete(p);
		}*/
	/*}

	@Override
	public SinhVien getSinhVienById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien p = (SinhVien) session.get(SinhVien.class, id);
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> getEmployeesByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<SinhVien> listSinhVien = session.createQuery("FROM SinhVien").setFirstResult(pageid).setMaxResults(total).list();
		return listSinhVien;
	}
	
	public int countSV() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		int rowcount = session.createQuery("from SinhVien").list().size();
		return rowcount;
		

	}
	*/

}
