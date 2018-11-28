package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhep;

@Repository(value = "donNghiPhepDaoILM")
@Transactional(rollbackFor = Exception.class)
public class DonNghiPhepDaoILM implements DonNghiPhepDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<DonNghiPhep> listDonNghiPhep() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhep> list = session.createQuery("from DonNghiPhep ").list();

		return list;
	}
}
