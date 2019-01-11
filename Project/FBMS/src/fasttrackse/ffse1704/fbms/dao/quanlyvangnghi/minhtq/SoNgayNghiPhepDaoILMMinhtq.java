package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.SoNgayNghiMinhtq;

@Repository(value = "soNgayNghiPhepDaoILMMinhtq")
@Transactional(rollbackFor = Exception.class)
public class SoNgayNghiPhepDaoILMMinhtq implements SoNgayNghiPhepDaoMinhtq {
	// tự động quét toàn bộ SessionFactory
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addSoNgayNghiPhep(SoNgayNghiMinhtq songaynghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(songaynghi);
	}

	public SoNgayNghiMinhtq getByIdSoNgayNghi(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SoNgayNghiMinhtq songaynghi = (SoNgayNghiMinhtq) session.get(SoNgayNghiMinhtq.class, id);

		return songaynghi;
	}

	// list toàn bộ đơn nghỉ phép chờ phê duyệt của nhân viên
	@SuppressWarnings("unchecked")
	public List<SoNgayNghiMinhtq> listSoNgayNghi() {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from SoNgayNghiMinhtq");

		List<SoNgayNghiMinhtq> list = (List<SoNgayNghiMinhtq>) query.getResultList();

		return list;
	}

	public SoNgayNghiMinhtq getNgayNghi(String maNhanVien, String maNgayNghi) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from SoNgayNghiMinhtq where maNhanVien =:maNhanVien AND maNgayNghi =:maNgayNghi");
		query.setParameter("maNhanVien", maNhanVien);
		query.setParameter("maNgayNghi", maNgayNghi);
		return (SoNgayNghiMinhtq) query.getSingleResult();
	}

	public void addSNN(String maNhanVien, String maNgayNghi, int soNgayDaNghi) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update SoNgayNghiMinhtq set soNgayDaNghi = :soNgayDaNghi"
				+ " where maNhanVien = :maNhanVien and maNgayNghi = :maNgayNghi");
		query.setParameter("soNgayDaNghi", soNgayDaNghi);
		query.setParameter("maNhanVien", maNhanVien);
		query.setParameter("maNgayNghi", maNgayNghi);
		query.executeUpdate();
	}

	@Override
	public boolean chekSongayNghi(String maNhanVien, String maNgayNghi) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery(" from SoNgayNghiMinhtq where maNhanVien= :maNhanVien AND maNgayNghi = :maNgayNghi AND soNgayDaNghi>0");
		query.setParameter("maNhanVien", maNhanVien);
		query.setParameter("maNgayNghi", maNgayNghi);
		int check = query.getResultList().size();

		return (check > 0);

	}
}
