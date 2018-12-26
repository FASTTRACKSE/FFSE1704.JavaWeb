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
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrinhDo;

@Repository
@Transactional(rollbackFor = Exception.class)
public class BangCapDaoImpl implements BangCapDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<BangCap> viewAll() {
		Session session = sessionFactory.getCurrentSession();
		List<BangCap> listBangCap = session.createQuery("FROM BangCap").getResultList();
		return listBangCap;
	}

	@Override
	public void addBangCap(BangCap bc) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(bc);

	}

	@Override
	public List<BangCap> GetListBangCapByPage(int start, int total) {
		Session session = sessionFactory.getCurrentSession();
		List<BangCap> listBC = session.createQuery("FROM BangCap").setFirstResult(start).setMaxResults(total).list();
		return listBC;
	}

	@Override
	public long CountBangCap() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(BangCap.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public NhanSu getBangCapByID(String id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(NhanSu.class);
		NhanSu result = (NhanSu) criteria.add(Restrictions.eqOrIsNull("maNhanVien", id)).uniqueResult();
		return result;
	}

	@Override
	public void update(BangCap bc) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(bc);

	}

	@Override
	public void delete(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		BangCap ns = session.load(BangCap.class, id);
		if (null != ns) {
			session.delete(ns);
		}

	}

	@Override
	public boolean checkExistMa(String maNS) {
		Session session = sessionFactory.getCurrentSession();

		Query query = (Query) session.createCriteria("select count(*) from NhanSu Where maNhanVien = :maNhanVien");
		Long check = (Long) query.uniqueResult();
		if (check > 0) {
			return true;
		}
		return false;
	}

	@Override
	public BangCap getBangCapUpdate(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		BangCap ns = (BangCap) session.get(BangCap.class, id);
		return ns;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TrinhDo> listTrinhDo() {
		Session session = sessionFactory.getCurrentSession();
		List<TrinhDo> listTrinhDo = session.createQuery("FROM TrinhDo").getResultList();
		return listTrinhDo;
	}

}
