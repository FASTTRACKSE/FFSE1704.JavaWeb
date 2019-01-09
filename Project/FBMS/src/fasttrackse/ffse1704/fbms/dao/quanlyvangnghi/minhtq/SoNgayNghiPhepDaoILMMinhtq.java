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

	public int KiemTraNgayNghi(DonNghiPhepMinhtq donnghiphep) {
		Session session = sessionFactory.getCurrentSession();
		String rowCount = session.createSQLQuery("select * from quan_ly_so_ngay_nghi where ma_nhan_vien = '"
				+ donnghiphep.getSoNgayNghiDNP().getMaNhanVien() + "' AND ma_ngay_nghi = '"
				+ donnghiphep.getSoNgayNghiDNP().getMaNgayNghi() + "'").getSingleResult().toString();
		return Integer.parseInt(rowCount);
	}

}
