package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.tuanpt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn.DonNghi;

@Repository
public class QuanLyVangNghiDaoTuanPTImpl implements QuanLyVangNghiTuanPTDao{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<DonNghi> listDonNghi() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghi> list = session.createQuery("from DonNghi ").list();

		return list;
	}

}
