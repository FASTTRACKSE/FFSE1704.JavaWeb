package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.thachmh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.thachmh.DonXinNghiPhep;

@Repository
public class DonXinNghiPhepDaoImpl implements DonXinNghiPhepDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DonXinNghiPhep> getAllDonXinNghiPhep() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonXinNghiPhep> list = session.createQuery("from DonXinNghiPhep").list();
		session.close();
		return list;
	}
}
