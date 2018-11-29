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

	// list toàn bộ đơn nghỉ phép của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhep> listDonNghiPhep() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhep> list = session.createQuery("from DonNghiPhep ").list();

		return list;
	}

	// crud cho đơn nghỉ phép của nhân viên
	public void addDonNghiPhep(DonNghiPhep donnghiphep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(donnghiphep);
	}

	public DonNghiPhep getByIdDonNghiPhep(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghiPhep donnghiphep = (DonNghiPhep) session.get(DonNghiPhep.class, id);

		return donnghiphep;
	}

	public void deleteDonNghiPhep(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getByIdDonNghiPhep(id));
	}

	public void editDonNghiPhep(DonNghiPhep donnghiphep) {
		Session session = this.sessionFactory.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(donnghiphep);
		tx.commit();
		session.close();
	}

	
	
}
