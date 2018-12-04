package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinGiaDinh;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ThongTinGiaDinhDaoImpl implements ThongTinGiaDinhDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinGiaDinh> dsThongTin() {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<ThongTinGiaDinh> listThongTin = session.createQuery("FROM ThongTinGiaDinh").list();
		return listThongTin;
	}

}
