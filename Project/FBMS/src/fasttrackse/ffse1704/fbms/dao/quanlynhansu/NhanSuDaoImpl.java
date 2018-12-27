package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThanhPho;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.XaPhuong;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

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

	@Override
	public void delete(int id) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		NhanSu ns = session.load(NhanSu.class, id);
		if(null !=ns) {
			session.delete(ns);
		}
	}

	@Override
	public boolean checkExistMa(String maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = (Query) session.createCriteria("select count(*) from NhanSu Where maNhanVien = :maNhanVien");
		Long check = (Long) query.uniqueResult();
		if(check > 0) {
			return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ChucDanh> listChucDanh() {
		Session session = sessionFactory.getCurrentSession();
		List<ChucDanh> listChucDanh = session.createQuery("FROM ChucDanh").getResultList();
		return listChucDanh;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PhongBan> listPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		List<PhongBan> listPhongBan = session.createQuery("FROM PhongBan").getResultList();
		return listPhongBan;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ThanhPho> listTinhThanhPho() {
		Session session = sessionFactory.getCurrentSession();
		List<ThanhPho> dsTinhThanh = session.createQuery("FROM ThanhPho").getResultList();
		return dsTinhThanh;
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<QuanHuyen> listQuanHuyen() {
//		Session session = sessionFactory.getCurrentSession();
//		@SuppressWarnings("rawtypes")
//		Query query = session.createQuery("FROM QuanHuyen");
//		query.setFirstResult(0);  
//		query.setMaxResults(10);
//		
//		List<QuanHuyen> listQuanHuyen = query.list();
//		return listQuanHuyen;
//	}
//
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<XaPhuong> listXaPhuong() {
//		Session session = sessionFactory.getCurrentSession();
//		@SuppressWarnings("rawtypes")
//		Query query = session.createQuery("FROM XaPhuong");
//		query.setFirstResult(0);  
//		query.setMaxResults(10);
//		 
//	QuanHuyen	List<XaPhuong> listXaPhuong = query.list();
//		return listXaPhuong;
//	}

	@Override
	@SuppressWarnings("unchecked")
	public List<QuanHuyen> listQuanHuyenbyID(String maThanhPho) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = (Query) session.createQuery("from QuanHuyen qh where qh.matp = :maThanhPho");
		query.setParameter("maThanhPho", maThanhPho);
		List<QuanHuyen> listQuanHuyen = query.list();
		return listQuanHuyen;
	}

	@Override
	public List<XaPhuong> listPhuongXabyID(String maQuanHuyen) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query =  session.createQuery("from XaPhuong xp where xp.maqh = :maQuanHuyen");
		query.setParameter("maQuanHuyen", maQuanHuyen);
		@SuppressWarnings("unchecked")
		List<XaPhuong> listXaPhuong = query.list();
		return listXaPhuong;
	}



	

}
