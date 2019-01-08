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

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ChungChi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrinhDo;

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
	public List<ChungChi> viewAll() {
		Session session = sessionFactory.getCurrentSession();
		List<ChungChi> listChungChi = session.createQuery("FROM ChungChi").getResultList();
		return listChungChi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChungChi> GetListChungChiByPage(int start, int total) {
		Session session = sessionFactory.getCurrentSession();
		List<ChungChi> listCC = session.createQuery("FROM ChungChi").setFirstResult(start).setMaxResults(total).list();
		return listCC;
	}

	@Override
	public long CountChungChi() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(ChungChi.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public NhanSu getChungChiByID(String id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(NhanSu.class);
		NhanSu result = (NhanSu) criteria.add(Restrictions.eqOrIsNull("maNhanVien", id)).uniqueResult();
		return result;
	}

	@Override
	public void update(ChungChi cc) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(cc);
	}

	@Override
	public void delete(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		String hql = "DELETE FROM ChungChi WHERE id =:ID";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("ID", id);
		query.executeUpdate();
	}

	@Override
	public boolean checkExistMa(String maNS) {
		Session session = sessionFactory.getCurrentSession();

		Query query = (Query) session.createCriteria("select count(*) from ChungChi Where maNhanVien = :maNhanVien");
		Long check = (Long) query.uniqueResult();
		if (check > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ChungChi getChungChiUpdate(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		ChungChi cc = (ChungChi) session.get(ChungChi.class, id);
		return cc;
	}

	@Override
	public void addChungChi(ChungChi cc) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cc);
	}

	@SuppressWarnings("unchecked")
	public List<TrinhDo> listTrinhDo() {
		Session session = sessionFactory.getCurrentSession();
		List<TrinhDo> trinhDo = session.createQuery("from TrinhDo").getResultList();
		return trinhDo;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<BangCap> findMaBangByMaTrinhDo(int IdtrinhDo) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from BangCap bc where bc.IdtrinhDo = :mbc";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("mbc", IdtrinhDo);
		return (List<BangCap>) query.list();
	}

}
