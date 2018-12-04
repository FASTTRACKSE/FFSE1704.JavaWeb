package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

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

	@Override
	public void addCC(ChungChi cc) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(cc);
	}

	@Override
	public void updateCC(ChungChi cc) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(cc);
	}

	@Override
	public void deleteCC(ChungChi cc) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.delete(cc);
	}

	@Override
	public ChungChi getChungChiById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ChungChi cc = (ChungChi) session.get(ChungChi.class, id);
		return cc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChungChi> getChungChiByPage(int pageid, int total) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<ChungChi> listChungChi = session.createQuery("FROM ChungChi").setFirstResult(pageid).setMaxResults(total)
				.list();
		return listChungChi;
	}

	@Override
	public long countSV() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(ChungChi.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

}
