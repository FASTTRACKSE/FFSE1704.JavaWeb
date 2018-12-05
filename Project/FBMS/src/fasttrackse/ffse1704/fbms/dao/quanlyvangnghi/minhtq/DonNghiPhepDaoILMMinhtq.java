package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;

@Repository(value = "donNghiPhepDaoILMMinhtq")
@Transactional(rollbackFor = Exception.class)
public class DonNghiPhepDaoILMMinhtq implements DonNghiPhepDaoMinhtq {

	// tự động quét toàn bộ SessionFactory
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// list toàn bộ đơn nghỉ phép của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepNhap( String trangthai) {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='" + trangthai + "'").list();

		return list;
	}
	
	
	// list loại ngày nghỉ
		@SuppressWarnings("unchecked")
		public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi() {
			Session session = sessionFactory.getCurrentSession();
			List<LoaiNgayNghiMinhtq> list = session.createQuery("from LoaiNgayNghiMinhtq").list();

			return list;
		}
		
	// crud cho đơn nghỉ phép nháp của nhân viên
	public void addDonNghiPhepNhap(DonNghiPhepMinhtq donnghiphepnhap) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(donnghiphepnhap);
	}

	public DonNghiPhepMinhtq getByIdDonNghiPhep(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghiPhepMinhtq donnghiphepnhap = (DonNghiPhepMinhtq) session.get(DonNghiPhepMinhtq.class, id);

		return donnghiphepnhap;
	}

	public void deleteDonNghiPhepNhap(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getByIdDonNghiPhep(id));
	}

	public void editDonNghiPhepNhap(DonNghiPhepMinhtq donnghiphepnhap) {
		Session session = this.sessionFactory.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(donnghiphepnhap);
		tx.commit();
		session.close();
	}

	

	

	

}
