package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.khoann;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.DonNghiPhepKhoann;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.khoann.LoaiHinhNghiPhepKhoann;

@Repository
@Transactional
public class DonNghiPhepDaoImplKhoann implements DonNghiPhepDaoKhoann {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<DonNghiPhepKhoann> listDonNghiPhep() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepKhoann> list = session.createQuery("from DonNghiPhepKhoann").list();

		return list;
	}

	@Override
	public void themDon(DonNghiPhepKhoann hs) {

		Session session = this.sessionFactory.getCurrentSession();
		session.save(hs);

	}

	@Override
	public DonNghiPhepKhoann getNhanVienByID(int maNhanVien) {
		// TODO Auto-generated method stub

		Session session = this.sessionFactory.openSession();
		DonNghiPhepKhoann pb = session.get(DonNghiPhepKhoann.class, maNhanVien);
		session.close();
		return pb;
	}

	@Override
	public void suaDon(DonNghiPhepKhoann hs) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(hs);
		tx.commit();
		session.close();
	}

	@Override
	public List<LoaiHinhNghiPhepKhoann> danhSachLyDo() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<LoaiHinhNghiPhepKhoann> cq = cb.createQuery(LoaiHinhNghiPhepKhoann.class);
		Root<LoaiHinhNghiPhepKhoann> root = cq.from(LoaiHinhNghiPhepKhoann.class);
		cq.select(root);
		Query<LoaiHinhNghiPhepKhoann> query = session.createQuery(cq);
		return query.getResultList();
	}

}
