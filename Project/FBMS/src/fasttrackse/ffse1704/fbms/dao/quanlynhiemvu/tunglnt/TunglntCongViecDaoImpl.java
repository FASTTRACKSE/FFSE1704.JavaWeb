package fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.tunglnt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntLoaiCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt.TunglntTrangThai;
import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;

@Repository
@Transactional(rollbackFor = Exception.class)
public class TunglntCongViecDaoImpl implements TunglntCongViecDao{

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TunglntCongViec> AllCV() {
		Session session = this.sessionFactory.openSession();
		List<TunglntCongViec> listCV = session.createQuery("from TunglntCongViec ").list();
		return listCV;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TunglntTrangThai> trangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TunglntTrangThai> tt = session.createQuery("from TunglntTrangThai").list();
		return tt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TunglntLoaiCongViec> loaiCongViec() {
		Session session = sessionFactory.getCurrentSession();
		List<TunglntLoaiCongViec> cv = session.createQuery("from TunglntLoaiCongViec").list();
		return cv;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TunglntDuAn> duAn() {
		Session session = sessionFactory.getCurrentSession();
		List<TunglntDuAn> da = session.createQuery("from TunglntDuAn").list();
		return da;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> nhanVien() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVien> nv = session.createQuery("from HoSoNhanVien").list();
		return nv;
	}

	@Override
	public void addCongViec(TunglntCongViec cv) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cv);
		
	}
	
	
	
}
