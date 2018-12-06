package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.thachmh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh.DonXinNghiPhep;

@Repository
public class DonXinNghiPhepDaoImpl implements DonXinNghiPhepDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DonXinNghiPhep> getAllDonXinNghiPhep() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonXinNghiPhep> list = session.createQuery("from DonXinNghiPhep").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(DonXinNghiPhep dx) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(dx);
		tx.commit();
		session.close();
	}

	@Override
	public void update(DonXinNghiPhep dx) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dx);
		tx.commit();
		session.close();
	}

	@Override
	public DonXinNghiPhep findByidDon(int idDon) {
		Session session = this.sessionFactory.openSession();
		DonXinNghiPhep pb = session.get(DonXinNghiPhep.class, idDon);
		session.close();
		return pb;		
	}

	@Override
	public void delete(int idDon) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(DonXinNghiPhep.class, idDon));
		pb.commit();
		session.close();		
	}
}
