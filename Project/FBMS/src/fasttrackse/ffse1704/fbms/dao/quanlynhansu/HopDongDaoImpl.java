package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.CheDoHuong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachCongViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DanhSachNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.DiaDiemLamViec;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanLySoNgayNghi;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrangThaiHopDong;

@Repository
@Transactional(rollbackFor = Exception.class)
public class HopDongDaoImpl implements HopDongDao {

	ThongTinHopDong thongtinhopdong;

	public ThongTinHopDong getThongtinhopdong() {
		return thongtinhopdong;
	}

	public void setThongtinhopdong(ThongTinHopDong thongtinhopdong) {
		this.thongtinhopdong = thongtinhopdong;
	}

	NhanSu nhanSu;

	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<HopDong> listHopDong() {
		Session session = sessionFactory.getCurrentSession();
		List<HopDong> listHopDong = session.createQuery("from HopDong").getResultList();
		return listHopDong;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CheDoHuong> listCheDoHuong() {
		Session session = sessionFactory.getCurrentSession();
		List<CheDoHuong> listCheDoHuong = session.createQuery("from CheDoHuong").getResultList();
		return listCheDoHuong;
	}

	@Override
	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong, boolean checkMaNV) {
		Session session = sessionFactory.getCurrentSession();

		String maHD = thongtinhopdong.getMaHopDong();
		String trangThaiHD = thongtinhopdong.getMaTrangThai();

		if (maHD.equals("HD3") && trangThaiHD.equals("ACTIVE") && checkMaNV==false) {
			String maNV = thongtinhopdong.getMaNhanVien();
			int ngayNPN = thongtinhopdong.getSoNgayNghiTrongNam();
			QuanLySoNgayNghi khoiTaoThongTinNgayNghi = new QuanLySoNgayNghi(maNV, "PN", ngayNPN, 0);
			session.save(khoiTaoThongTinNgayNghi);
			session.flush();
			session.clear();

			QuanLySoNgayNghi khoiTaoThongTinNgayNghi2 = new QuanLySoNgayNghi(maNV, "DO", 3, 0);
			session.save(khoiTaoThongTinNgayNghi2);
			session.flush();
			session.clear();

			QuanLySoNgayNghi khoiTaoThongTinNgayNghi3 = new QuanLySoNgayNghi(maNV, "TG", 3, 0);
			session.save(khoiTaoThongTinNgayNghi3);

			session.flush();
			session.clear();

			QuanLySoNgayNghi khoiTaoThongTinNgayNghi4 = new QuanLySoNgayNghi(maNV, "SD", 3, 0);
			session.save(khoiTaoThongTinNgayNghi4);
			session.save(thongtinhopdong);
		} else {
			session.save(thongtinhopdong);
		}
	}

	@Override
	public void editHopDong(ThongTinHopDong thongtinhopdong) {
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(thongtinhopdong);
		tx.commit();
		session.close();
	}

	@Override
	public ThongTinHopDong findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ThongTinHopDong sv = (ThongTinHopDong) session.get(ThongTinHopDong.class, id);
		return sv;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void deleteHopDong(int id) {
		Session session = this.sessionFactory.getCurrentSession();
//		nhanSu.listHopDong.remove(findById(id));
//		session.delete(findById(id));
		String hql = "delete from ThongTinHopDong where id= :id";
		Query query = session.createQuery(hql);

		query.setInteger("id", id);
		query.executeUpdate();
		System.out.println(query.executeUpdate());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DanhSachCongViec> listDanhSachCongViec() {
		Session session = sessionFactory.getCurrentSession();
		List<DanhSachCongViec> listDanhSachCongViec = session.createQuery("from DanhSachCongViec").getResultList();
		return listDanhSachCongViec;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DiaDiemLamViec> listDiaDiemLamViec() {
		Session session = sessionFactory.getCurrentSession();
		List<DiaDiemLamViec> listDiaDiemLamViec = session.createQuery("from DiaDiemLamViec").getResultList();
		return listDiaDiemLamViec;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DanhSachNgayNghi> listDanhSachNgayNghi() {
		Session session = sessionFactory.getCurrentSession();
		List<DanhSachNgayNghi> listDanhSachNgayNghi = session.createQuery("from DanhSachNgayNghi").getResultList();
		return listDanhSachNgayNghi;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TrangThaiHopDong> TrangThaiHopDong() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiHopDong> listTrangThaiHopDong = session.createQuery("from TrangThaiHopDong").getResultList();
		return listTrangThaiHopDong;
	}

	@SuppressWarnings("deprecation")
	@Override
	public HopDong findTenHopDongbyMaHopDong(String maHopDong) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(HopDong.class);
		HopDong yourObject = (HopDong) criteria.add(Restrictions.eq("maHopDong", maHopDong)).uniqueResult();
		return yourObject;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ThongTinHopDong> findByMNVandMHD(String maNhanVien, String maHopDong) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ThongTinHopDong tthd where tthd.maNhanVien = :mnv AND tthd.maHopDong = :mhd";

		Query query = session.createQuery(hql);
		query.setParameter("mnv", maNhanVien);
		query.setParameter("mhd", maHopDong);
		return (List<ThongTinHopDong>) query.list();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ThongTinHopDong> findByMNVandMTT(String maNhanVien, String maTrangThai) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ThongTinHopDong tthd where tthd.maNhanVien = :mnv AND tthd.maTrangThai = :mtt";

		Query query = session.createQuery(hql);
		query.setParameter("mnv", maNhanVien);
		query.setParameter("mtt", maTrangThai);
		return (List<ThongTinHopDong>) query.list();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ThongTinHopDong> findByMNVandMHDandMTT(String maNhanVien, String maHopDong, String maTrangThai) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ThongTinHopDong tthd where tthd.maNhanVien = :mnv AND tthd.maHopDong = :mhd  AND tthd.maTrangThai = :mtt";

		Query query = session.createQuery(hql);
		query.setParameter("mnv", maNhanVien);
		query.setParameter("mhd", maHopDong);
		query.setParameter("mtt", maTrangThai);
		return (List<ThongTinHopDong>) query.list();
	}
	
	@Override
	@SuppressWarnings({ "rawtypes" })
	public void editNgayNghiPhepNam(String maNhanVien, int soNgayNghi) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("update QuanLySoNgayNghi set tongSoNgayDuocNghi = :sndn" + " where maNhanVien = :mnv and maNgayNghi = :mnn");
		query.setParameter("sndn", soNgayNghi);
		query.setParameter("mnv", maNhanVien);
		query.setParameter("mnn", "PN");
		query.executeUpdate();
		System.out.println(query.executeUpdate());
	}
	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkExistMaNV(String maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(" from QuanLySoNgayNghi Where maNhanVien = :maNhanVien");
		query.setParameter("maNhanVien", maNhanVien);
		int check = query.getResultList().size();
		
		return (check>0);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkExistMaTT(String maNhanVien,String maTrangThai) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(" from ThongTinHopDong where maNhanVien= :maNhanVien AND maTrangThai = :maTrangThai");
		query.setParameter("maNhanVien", maNhanVien);
		query.setParameter("maTrangThai", maTrangThai);
		int check = query.getResultList().size();
		
		return (check>0);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkHDbyMaNV(int id, String tenNguoiCode) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(" from ThongTinHopDong where id= :id AND maTrangThai = :maTrangThai");
		query.setParameter("id", id);
		query.setParameter("maTrangThai", "ACTIVE");
		int check = query.getResultList().size();
		return (check>0);
	}
	
	
}
