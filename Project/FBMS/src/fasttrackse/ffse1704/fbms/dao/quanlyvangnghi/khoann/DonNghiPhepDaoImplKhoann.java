package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.khoann;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhepKhoann;
@Repository
@Transactional
public class DonNghiPhepDaoImplKhoann implements DonNghiPhepDaoKhoann {

	
	
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepKhoann> listDonNghiPhep() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepKhoann> list = session.createQuery("from DonNghiPhepKhoann ").list();

		return list;
	}

}
