package ffsespring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ffsespring.entity.DiemSinhVien;
import ffsespring.entity.SinhVien;

@Repository
public class SinhVienDaoIPM implements SVDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sv);
	}

	@Override
	public void updateSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sv);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SinhVien> listSinhVien(int start, int end) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<SinhVien> sinhVienList = session.createQuery("from SinhVien").setFirstResult(start).setMaxResults(end)
				.list();
		return sinhVienList;
	}

	@Override
	public SinhVien getSinhVien(String maSinhVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<SinhVien> listSV = session
				.createQuery("from SinhVien where maSinhVien = '" + maSinhVien + "'", SinhVien.class).list();
		SinhVien sv = listSV.get(0);
		return sv;
	}

	@Override
	public void deleteSinhVien(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<SinhVien> listSV = session.createQuery("from SinhVien where id = '" + id + "'", SinhVien.class).list();
		SinhVien sv = listSV.get(0);
		if (null != sv) {
			session.delete(sv);
		}
	}

	@Override
	public int countSinhVien() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from SinhVien").list().size();
		return rowCount;
	}

	@Override
	public List<DiemSinhVien> getDiemSinhVien(String maSinhVien) {
		Session session = sessionFactory.getCurrentSession();
		List<DiemSinhVien> listDiem = session.createQuery("from DiemSinhVien where maSinhVien='"+ maSinhVien +"'", DiemSinhVien.class).list();
		return listDiem;
	}

}
