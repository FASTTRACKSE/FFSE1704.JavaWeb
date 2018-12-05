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
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;;

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

}
