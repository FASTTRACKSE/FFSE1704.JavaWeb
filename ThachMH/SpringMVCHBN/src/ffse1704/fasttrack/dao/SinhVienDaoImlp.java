package ffse1704.fasttrack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ffse1704.fasttrack.entity.SinhVien;

@Repository
public class SinhVienDaoImlp implements SinhVienDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<SinhVien> getAllSinhViens() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<SinhVien> theQuery = currentSession.createQuery("from SinhVien").list();
		return theQuery;
	}

	@Override
	public void saveSV(SinhVien v) {
		sessionFactory.getCurrentSession().saveOrUpdate(v);
	}

	@Override
	public SinhVien getSinhVien(int theId) {
		SinhVien v = (SinhVien) sessionFactory.getCurrentSession().get(SinhVien.class, theId);
		
		return v;
	}
	@Override
	public void deleteSV(int theId) {
		// TODO Auto-generated method stub
		SinhVien v = (SinhVien) sessionFactory.getCurrentSession().get(SinhVien.class, theId);
		sessionFactory.getCurrentSession().delete(v);
	}

}
