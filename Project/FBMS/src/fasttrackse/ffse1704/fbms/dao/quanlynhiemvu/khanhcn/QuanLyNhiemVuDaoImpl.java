package fasttrackse.ffse1704.fbms.dao.quanlynhiemvu.khanhcn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.CongViecKhanhCN;
import fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn.DuAnKhanhCN;
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
	public List<DuAnKhanhCN> duAn() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<DuAnKhanhCN> duAn = session.createQuery("from ThongTinDuAn").list();
		return duAn;
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
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cv);

	}

}
