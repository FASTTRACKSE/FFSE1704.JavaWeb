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
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.SoNgayNghiNhanVien;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThongTinHopDong;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;
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
	public void saveHopDongCheDo(ThongTinHopDong thongtinhopdong) {
		Session session = sessionFactory.getCurrentSession();
		session.save(thongtinhopdong);
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
	@SuppressWarnings("deprecation")
	@Override
	public SoNgayNghiNhanVien findNgayNghiConLaibyMaNV(String maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SoNgayNghiNhanVien.class);
		SoNgayNghiNhanVien yourObject = (SoNgayNghiNhanVien) criteria.add(Restrictions.eq("maNhanVien", maNhanVien)).uniqueResult();
		return yourObject;
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
}
