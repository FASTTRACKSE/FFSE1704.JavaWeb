package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.BangCap;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
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

	@SuppressWarnings("unchecked")
	public List<PhongBan> listPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		List<PhongBan> list = session.createQuery("from PhongBan").getResultList();
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<NhanSu> findByPhongBan(String maPhongBan) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(NhanSu.class);
		@SuppressWarnings("unchecked")
		List<NhanSu> yourObject = (List<NhanSu>) criteria.add(Restrictions.eq("phongBan.maPhongBan", maPhongBan)).list();
		return yourObject;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public NhanSu findByMaNhanVien(String maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(NhanSu.class);
		NhanSu yourObject = (NhanSu) criteria.add(Restrictions.eq("maNhanVien", maNhanVien)).uniqueResult();
		return yourObject;
	}
}
