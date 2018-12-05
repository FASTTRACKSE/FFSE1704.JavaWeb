package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
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

	@Override
	public void addTT(ThongTinGiaDinh tt) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(tt);
	}

	@Override
	public void updateTT(ThongTinGiaDinh tt) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(tt);
	}

	@Override
	public void deleteTT(ThongTinGiaDinh tt) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.delete(tt);
	}

	@Override
	public ThongTinGiaDinh getThongTinById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ThongTinGiaDinh tt = (ThongTinGiaDinh) session.get(ThongTinGiaDinh.class, id);
		return tt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinGiaDinh> getThongTinByPage(int pageid, int total) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<ThongTinGiaDinh> listThongTin = session.createQuery("FROM ThongTinGiaDinh").setFirstResult(pageid)
				.setMaxResults(total).list();
		return listThongTin;
	}

	@Override
	public long countTT() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(ThongTinGiaDinh.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}
}
