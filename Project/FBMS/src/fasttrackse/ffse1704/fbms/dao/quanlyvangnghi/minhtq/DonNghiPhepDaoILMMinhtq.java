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

	// list toàn bộ đơn nghỉ phép nháp của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepNhap() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='1'").list();

		return list;
	}

	// list toàn bộ đơn nghỉ phép chờ phê duyệt của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepChoDuyet() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='2'").list();

		return list;
	}

	// list toàn bộ đơn nghỉ phép dã duyệt của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepDaDuyet() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='3'").list();

		return list;
	}

	// list toàn bộ đơn nghỉ phép Từ chối của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhepTuChoi() {
		Session session = sessionFactory.getCurrentSession();
		List<DonNghiPhepMinhtq> list = session.createQuery("from DonNghiPhepMinhtq where trangThai ='4'").list();

		return list;
	}

	

	// tìm kiếm đơn nghỉ phép theo id
	public DonNghiPhepMinhtq getByIdDonNghiPhep(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghiPhepMinhtq donnghiphepnhap = (DonNghiPhepMinhtq) session.get(DonNghiPhepMinhtq.class, id);

		return donnghiphepnhap;
	}

	// crud cho đơn nghỉ phép nháp của nhân viên
	public void addDonNghiPhepNhap(DonNghiPhepMinhtq donnghiphepnhap) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(donnghiphepnhap);
		
	}

	public void deleteDonNghiPhep(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getByIdDonNghiPhep(id));
	}

	public void editDonNghiPhepNhap(DonNghiPhepMinhtq donnghiphepnhap) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(donnghiphepnhap);

	}

	// hết crud cho đơn nghỉ phép nháp của nhân viên

	///////////////////////////////////// LOẠI NGÀY NGHỈ//////////
	// list loại ngày nghỉ
	@SuppressWarnings("unchecked")
	public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi() {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiNgayNghiMinhtq> list = session.createQuery("from LoaiNgayNghiMinhtq").list();

		return list;
	}

	// crud cho loại ngày nghỉ
	public void addLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loaingaynghi);
		
	}

	public void deleteLoaiNgayNghi(int maNgayNghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getByIdLoaiNgayNghi(maNgayNghi));
	}

	public void editLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(loaingaynghi);

	}

	// tìm kiếm đơn nghỉ phép theo id loại ngày nghỉ
	public LoaiNgayNghiMinhtq getByIdLoaiNgayNghi(int maNgayNghi) {
		Session session = this.sessionFactory.getCurrentSession();
		LoaiNgayNghiMinhtq loaingaynghi = (LoaiNgayNghiMinhtq) session.get(LoaiNgayNghiMinhtq.class, maNgayNghi);

		return loaingaynghi;
	}

	// hết phần crud cho loại ngày nghỉ
	
	
	
	/////////////////// TRẠNG THÁI/////////////
	//list trạng thái
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

	public void deleteTrangThai(int maNgayNghi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getByIdTrangThai(maNgayNghi));
	}

	public void editTrangThai(TrangThaiVangNghiMinhtq trangthai) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(trangthai);

	}

	// tìm kiếm Trang thái theo id trạng thái
	public TrangThaiVangNghiMinhtq getByIdTrangThai(int maTrangThai) {
		Session session = this.sessionFactory.getCurrentSession();
		TrangThaiVangNghiMinhtq trangthai = (TrangThaiVangNghiMinhtq) session.get(TrangThaiVangNghiMinhtq.class, maTrangThai);

		return trangthai;
	}
	// hết phần crud cho trạng thái

	

}
