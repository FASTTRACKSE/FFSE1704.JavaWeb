package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

@Repository
@Transactional(rollbackFor = Exception.class)
public class NhanSuDaoImpl implements NhanSuDao {
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
	public List<NhanSu> allNS() {
		Session session = sessionFactory.getCurrentSession();
		List<NhanSu> listNhanSu = session.createQuery("FROM NhanSu").getResultList();
		return listNhanSu;
	}

	
	@Override
	public void addNS(NhanSu ns) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(ns);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NhanSu> GetListNhanSuByPage(int start, int total) {
		Session session = sessionFactory.getCurrentSession();
		List<NhanSu> listNhanSu = session.createQuery("FROM NhanSu").setFirstResult(start).setMaxResults(total).list();
		return listNhanSu;
	}

	@Override
	public long CountNhanSu() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(NhanSu.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public NhanSu getNhanSuByID(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		NhanSu ns = (NhanSu) session.get(NhanSu.class, id);
		return ns;
	}

	@Override
	public void update(NhanSu ns) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(ns);
		
	}

	

}
