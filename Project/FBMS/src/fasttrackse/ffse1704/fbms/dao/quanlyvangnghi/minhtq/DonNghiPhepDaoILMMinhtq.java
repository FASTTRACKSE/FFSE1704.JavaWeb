package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.HoSoNhanVienMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.PhongBanMinhtq;
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

	public DonNghiPhepMinhtq read(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(DonNghiPhepMinhtq.class);
		DonNghiPhepMinhtq donnghiphep = (DonNghiPhepMinhtq) criteria.add(Restrictions.eq("id", id)).uniqueResult();
		return donnghiphep;
	}

	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listDonNghiPhep(int start, int perPage, String idTT) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DonNghiPhepMinhtq where trangThai = :idTT ORDER BY id DESC ");
		query.setParameter("idTT", idTT);
		query.setFirstResult(start);
		query.setMaxResults(perPage);

		List<DonNghiPhepMinhtq> list = (List<DonNghiPhepMinhtq>) query.getResultList();

		return list;
	}

	// list toàn bộ đơn nghỉ phép chờ phê duyệt của nhân viên
	@SuppressWarnings("unchecked")
	public List<DonNghiPhepMinhtq> listAllDonNghiPhep(String idTT) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from DonNghiPhepMinhtq where  trangThai = :idTT ORDER BY id DESC ");
		query.setParameter("idTT", idTT);
		List<DonNghiPhepMinhtq> list = (List<DonNghiPhepMinhtq>) query.getResultList();

		return list;
	}

	// tìm kiếm đơn nghỉ phép theo id
	public DonNghiPhepMinhtq getByIdDonNghiPhep(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghiPhepMinhtq donnghiphepnhap = (DonNghiPhepMinhtq) session.get(DonNghiPhepMinhtq.class, id);

		return donnghiphepnhap;
	}

	public DonNghiPhepMinhtq getByIdApproved(String maTrangThai) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DonNghiPhepMinhtq where  trangThai = :maTrangThai ORDER BY id DESC ");
		query.setParameter("maTrangThai", maTrangThai);
		DonNghiPhepMinhtq donnghiphep = (DonNghiPhepMinhtq) query.getResultList().get(0);

		return donnghiphep;
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
	
	public int KiemTraNgayNghi(DonNghiPhepMinhtq donnghiphep) {
		Session session = sessionFactory.getCurrentSession();
		String rowCount = session.createSQLQuery("select count(*) from quan_ly_so_ngay_nghi where ma_nhan_vien = '"
				+ donnghiphep.getMaNhanVien() + "'").getSingleResult().toString();
		return Integer.parseInt(rowCount);
	}

	// list phòng ban
	@SuppressWarnings("unchecked")
	public List<PhongBanMinhtq> listPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		List<PhongBanMinhtq> list = session.createQuery("from PhongBanMinhtq").getResultList();

		return list;
	}

	// list mã nhân viên
	@SuppressWarnings("unchecked")
	public List<HoSoNhanVienMinhtq> listMaNhanVien() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVienMinhtq> list = session.createQuery("from HoSoNhanVienMinhtq").getResultList();

		return list;
	}

	///////////////////////////////////// LOẠI NGÀY NGHỈ//////////
	// list loại ngày nghỉ
	@SuppressWarnings("unchecked")
	public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi() {
		Session session = sessionFactory.getCurrentSession();
		List<LoaiNgayNghiMinhtq> list = session.createQuery("from LoaiNgayNghiMinhtq ").getResultList();

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
		TrangThaiVangNghiMinhtq trangthai = (TrangThaiVangNghiMinhtq) session.get(TrangThaiVangNghiMinhtq.class, id);

		return trangthai;
	}
	// hết phần crud cho trạng thái

}
