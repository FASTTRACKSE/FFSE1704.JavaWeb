package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ChungChiDaoImpl implements ChungChiDao {
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
	public List<ChungChi> allCC() {
		Session session = sessionFactory.getCurrentSession();
		List<ChungChi> listChungChi = session.createQuery("FROM ChungChi").getResultList();
		return listChungChi;
	}

	@Override
	public void addCC(ChungChi cc) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(cc);
	}

}
