package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
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
	public List<ThongTinGiaDinh> viewAll() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongTinGiaDinh> listThongTin = session.createQuery("FROM ThongTinGiaDinh").getResultList();
		return listThongTin;
	}

	@Override
	public void addThongTinGiaDinh(ThongTinGiaDinh tt) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(tt);

	}

	@Override
	public List<ThongTinGiaDinh> GetListThongTinGiaDinhByPage(int start, int total) {
		Session session = sessionFactory.getCurrentSession();
		List<ThongTinGiaDinh> listTT = session.createQuery("FROM ThongTinGiaDinh").setFirstResult(start)
				.setMaxResults(total).list();
		return listTT;
	}

	@Override
	public long CountThongTinGiaDinh() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(ThongTinGiaDinh.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public NhanSu getThongTinGiaDinhByID(String id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(NhanSu.class);
		NhanSu result = (NhanSu) criteria.add(Restrictions.eqOrIsNull("maNhanVien", id)).uniqueResult();
		return result;
	}

	@Override
	public void update(ThongTinGiaDinh tt) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(tt);
	}

	@Override
	public void delete(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		String hql = "DELETE FROM ThongTinGiaDinh WHERE id =:id";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();

	}

	@Override
	public boolean checkExistMa(String maNS) {
		Session session = sessionFactory.getCurrentSession();

		Query query = (Query) session
				.createCriteria("select count(*) from ThongTinGiaDinh Where maNhanVien = :maNhanVien");
		Long check = (Long) query.uniqueResult();
		if (check > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ThongTinGiaDinh getThongTinGiaDinhUpdate(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		ThongTinGiaDinh tt = (ThongTinGiaDinh) session.get(ThongTinGiaDinh.class, id);
		return tt;
	}

}
