package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.TrangThaiVangNghiMinhtq;

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

	
	// đếm trong bảng Dơn nghỉ phép
	public int count() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from DonNghiPhepMinhtq").list().size();
		return rowCount;
	}

	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepNhap(int start, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='1' ORDER BY id ASC").setFirstResult(start)
				.setMaxResults(maxResult).list();
		return list;
	}

	

	// list toàn bộ đơn nghỉ phép chờ phê duyệt của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepChoDuyet(int start, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='2' ORDER BY id ASC").list();

		return list;
	}

	// list toàn bộ đơn nghỉ phép dã duyệt của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepDaDuyet(int start, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='3' ORDER BY id ASC").list();

		return list;
	}

	// list toàn bộ đơn nghỉ phép Từ chối của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepTuChoi(int start, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='4' ORDER BY id ASC").list();

		return list;
	}

	// tìm kiếm đơn nghỉ phép theo id
	public DonNghiPhepMinhtq getByIdDonNghiPhep(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghiPhepMinhtq donnghiphepnhap = (DonNghiPhepMinhtq) session.get(DonNghiPhepMinhtq.class, id);

		return donnghiphepnhap;
	}

	// crud cho đơn nghỉ phép nháp của nhân viên
	
	
	
	public void addDonNghiPhep(DonNghiPhepMinhtq donnghiphep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(donnghiphep);

	}

	public void deleteDonNghiPhep(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getByIdDonNghiPhep(id));
	}

	public void editDonNghiPhep(DonNghiPhepMinhtq donnghiphep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(donnghiphep);

	}

	// hết crud cho đơn nghỉ phép nháp của nhân viên

	///////////////////////////////////// LOẠI NGÀY NGHỈ//////////
	// list loại ngày nghỉ
	@SuppressWarnings("unchecked")
	public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi() {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiNgayNghiMinhtq> list = session.createQuery("from LoaiNgayNghiMinhtq").getResultList();

		return list;
	}

	

	// crud cho loại ngày nghỉ
	public void addLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loaingaynghi);

	}

	public void deleteLoaiNgayNghi(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getByIdLoaiNgayNghi(id));
	}

	public void editLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(loaingaynghi);

	}
	

	// tìm kiếm đơn nghỉ phép theo id loại ngày nghỉ
	public LoaiNgayNghiMinhtq getByIdLoaiNgayNghi(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		LoaiNgayNghiMinhtq loaingaynghi = (LoaiNgayNghiMinhtq) session.get(LoaiNgayNghiMinhtq.class, id);

		return loaingaynghi;
	}

	// hết phần crud cho loại ngày nghỉ

	/////////////////// TRẠNG THÁI/////////////
	// list trạng thái
	@SuppressWarnings("unchecked")
	public List<TrangThaiVangNghiMinhtq> listAllTrangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiVangNghiMinhtq> list = session.createQuery("from TrangThaiVangNghiMinhtq").list();

		return list;
	}

	// crud cho trạng thái
	public void addTrangThai(TrangThaiVangNghiMinhtq trangthai) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(trangthai);

	}

	public void deleteTrangThai(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getByIdTrangThai(id));
	}

	public void editTrangThai(TrangThaiVangNghiMinhtq trangthai) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(trangthai);

	}

	// tìm kiếm Trang thái theo id trạng thái
	public TrangThaiVangNghiMinhtq getByIdTrangThai(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TrangThaiVangNghiMinhtq trangthai = (TrangThaiVangNghiMinhtq) session.get(TrangThaiVangNghiMinhtq.class,
				id);

		return trangthai;
	}
	// hết phần crud cho trạng thái

}
