package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.XaPhuong;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Repository
@Transactional(rollbackFor = Exception.class)
public class XemThongTinNVDaoImpl implements XemThongTinNVDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// list phong ban
	@SuppressWarnings("unchecked")
	public List<PhongBan> listPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		List<PhongBan> list = session.createQuery("from PhongBan").getResultList();
		return list;
	}

	//select no HQL
//	@SuppressWarnings("deprecation")
//	@Override
//	public List<NhanSu> findByPhongBan(String maPhongBan) {
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(NhanSu.class);
//
//		@SuppressWarnings("unchecked")
//		List<NhanSu> yourObject = (List<NhanSu>) criteria.add(Restrictions.eq("phongBan.maPhongBan", maPhongBan))
//				.list();
//		return yourObject;
//	}
//
//	@SuppressWarnings("deprecation")
//
//	@Override
//	public List<NhanSu> findAllForPaging(String maPhongBan, int startPosition, int maxResult) {
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(NhanSu.class);
//
//		@SuppressWarnings("unchecked")
//		List<NhanSu> yourObject = (List<NhanSu>) criteria.add(Restrictions.eq("phongBan.maPhongBan", maPhongBan))
//				.list();
//		startPosition = 1;
//		maxResult = yourObject.size();
//		return yourObject;
//	}

	// select theo maPhongBan HQL
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<NhanSu> findByPhongBan(String maPhongBan) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from NhanSu ns where ns.maPhongBan = :mpb";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("mpb", maPhongBan);
		return (List<NhanSu>) query.list();
	}

	//phan trang theo maPhongBan HQL
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<NhanSu> findAllForPaging(String maPhongBan, int startPosition, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from NhanSu ns where ns.maPhongBan = :mpb";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("mpb", maPhongBan);
		query.setFirstResult(startPosition);
		query.setMaxResults(maxResult);
		return (List<NhanSu>) query.list();
	}

	// select theo maNhanVien
	@SuppressWarnings("deprecation")
	@Override
	public NhanSu findByMaNhanVien(String maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(NhanSu.class);
		NhanSu yourObject = (NhanSu) criteria.add(Restrictions.eq("maNhanVien", maNhanVien)).uniqueResult();
		return yourObject;
	}

	// select ten phongBan theo maPhongBan
	@SuppressWarnings("deprecation")
	@Override
	public PhongBan findTenPhongBanByMaPhongBan(String maPhongBan) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PhongBan.class);
		PhongBan yourObject = (PhongBan) criteria.add(Restrictions.eq("maPhongBan", maPhongBan)).uniqueResult();
		return yourObject;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<QuanHuyen> findQuanHuyenByIdThanhPho(String maThanhPho) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(QuanHuyen.class);

		@SuppressWarnings("unchecked")
		List<QuanHuyen> yourObject = (List<QuanHuyen>) criteria.add(Restrictions.eq("matp", maThanhPho))
				.list();
		return yourObject;
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<XaPhuong> findXaPhuongByIdQuanHuyen(String maQuanHuyen) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(XaPhuong.class);

		@SuppressWarnings("unchecked")
		List<XaPhuong> yourObject = (List<XaPhuong>) criteria.add(Restrictions.eq("maqh", maQuanHuyen))
				.list();
		return yourObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinHopDong> findTTByMaPhongBan(String maPhongBan) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ThongTinHopDong hd where hd.maHopDong = :mhd";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("mhd", maPhongBan);
		return (List<ThongTinHopDong>) query.list();
	}
	@SuppressWarnings("rawtypes")
	@Override
	public ThongTinHopDong findPBCDByMaNhanVien(String maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ThongTinHopDong hd where hd.maNhanVien = :mnv AND hd.maTrangThai = 'ACTIVE'";
		Query query = session.createQuery(hql);
		query.setParameter("mnv", maNhanVien);
		return (ThongTinHopDong) query.uniqueResult();
			
	}
}
