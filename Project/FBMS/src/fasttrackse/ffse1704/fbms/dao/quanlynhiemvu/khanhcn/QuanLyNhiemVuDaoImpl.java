package fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.khanhcn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.LoaiCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.NhanVienDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.NhanVienKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.TrangThaiKhanhCN;;

@Repository
@Transactional(rollbackFor = Exception.class)
public class QuanLyNhiemVuDaoImpl implements QuanLyNhiemVuDao {

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
	public List<CongViecKhanhCN> congViec() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<CongViecKhanhCN> congViec = session.createQuery("from CongViecKhanhCN").list();
		return congViec;
	}

	@Override
	public void addCongViec(CongViecKhanhCN cv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(cv);
		tx.commit();
		session.close();

	}

	@Override
	public void updateCongViec(CongViecKhanhCN cv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cv);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteCongViec(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(CongViecKhanhCN.class, id));
		pb.commit();
		session.close();
	}

	@Override
	public CongViecKhanhCN findByID(int id) {
		Session session = this.sessionFactory.openSession();
		CongViecKhanhCN pb = session.get(CongViecKhanhCN.class, id);
		session.close();
		return pb;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiKhanhCN> trangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiKhanhCN> tt = session.createQuery("from TrangThaiKhanhCN").list();
		return tt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiCongViec> loaiCongViec() {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiCongViec> cv = session.createQuery("from LoaiCongViec").list();
		return cv;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DuAnKhanhCN> duAn() {
		Session session = sessionFactory.getCurrentSession();
		List<DuAnKhanhCN> da = session.createQuery("from DuAnKhanhCN").list();
		return da;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhanVienDuAn> nhanVienDuAn() {
		Session session = sessionFactory.getCurrentSession();
		List<NhanVienDuAn> nvda = session.createQuery("from NhanVienDuAn").list();
		return nvda;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhanVienKhanhCN> nhanVien() {
		Session session = sessionFactory.getCurrentSession();
		List<NhanVienKhanhCN> cv = session.createQuery("from NhanVienKhanhCN").list();
		return cv;
	}

}
