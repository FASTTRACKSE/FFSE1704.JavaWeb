package fasttrackse.ffse1704.fbms.dao.logwork;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.logwork.ThoiGianLamViec;
import fasttrackse.ffse1704.fbms.entity.logwork.VuDuAnLogwork;
import fasttrackse.ffse1704.fbms.entity.logwork.VuPhongBan;
import fasttrackse.ffse1704.fbms.entity.logwork.VuVaiTroDuAn;

@Repository
public class QuanLiThoiGianDao implements QuanLiThoiGianDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ThoiGianLamViec> findAll() {
		Session session = this.sessionFactory.openSession();
		List<ThoiGianLamViec> list = session.createQuery("from ThoiGianLamViec ORDER BY id DESC").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(ThoiGianLamViec thoiGianLamViec) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(thoiGianLamViec);
		transaction.commit();
		session.close();

	}

	@Override
	public void update(ThoiGianLamViec thoiGianLamViec) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(thoiGianLamViec);
		;
		transaction.commit();
		session.close();

	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(session.get(ThoiGianLamViec.class, id));
		transaction.commit();
		session.close();

	}

	@Override
	public ThoiGianLamViec findByIdThoiGianLamViec(String id) {
		Session session = this.sessionFactory.openSession();
		ThoiGianLamViec thoiGianLamViec = session.get(ThoiGianLamViec.class, id);
		session.close();
		return thoiGianLamViec;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ThoiGianLamViec> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<ThoiGianLamViec> listThoiGianLamViec = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		session.close();
		return listThoiGianLamViec;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();
		String sql = "SELECT COUNT(*) FROM 'thoi_gian_lam_viec'";
		Query query = session.createSQLQuery(sql);
		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

	@Override
	public ThoiGianLamViec findByIdLogwork(int id) {
		Session session = this.sessionFactory.openSession();
		ThoiGianLamViec logwork = session.get(ThoiGianLamViec.class, id);
		session.close();
		return logwork;

	}

	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select thoigianlamviec", "select count(*)"));
		String recordsFilterd = query.getSingleResult().toString();
		session.close();
		return recordsFilterd;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<VuPhongBan> listPhongBan() {
		Session session = sessionFactory.getCurrentSession();
		List<VuPhongBan> listPhongBan = session.createQuery("from VuPhongBan").getResultList();
		return listPhongBan;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<VuDuAnLogwork> listDuAn() {
		Session session = sessionFactory.getCurrentSession();
		List<VuDuAnLogwork> listDuAn = session.createQuery("from VuDuAnLogwork").getResultList();
		return listDuAn;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<VuVaiTroDuAn> listVaiTroDuAn() {
		Session session = sessionFactory.getCurrentSession();
		List<VuVaiTroDuAn> listVaiTroDuAn = session.createQuery("from VuVaiTroDuAn").getResultList();
		return listVaiTroDuAn;
	}
	
	@Override
	public List<ThoiGianLamViec> listOneMonth(String month){
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ThoiGianLamViec so where MONTH(so.thoiGianBatDau) = :month");
		query.setParameter("month", Integer.parseInt(month));
		List<ThoiGianLamViec> logwork = (List<ThoiGianLamViec>) query.getResultList();
		return logwork;
		
	}
	@Override
	public List<ThoiGianLamViec> listTheoTrangThai(int maTrangThai){
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ThoiGianLamViec  where trangThaiLogwork.maTrangThai  = :maTrangThai ORDER BY id DESC");
		query.setParameter("maTrangThai", maTrangThai);
		List<ThoiGianLamViec> logwork = (List<ThoiGianLamViec>) query.getResultList();
		return logwork;
		
	}
	@Override
	public List<ThoiGianLamViec> baoCaoTheoMaNV(String maNhanVien){
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ThoiGianLamViec  where maNhanVien.maNVien = :maNhanVien");
		query.setParameter("maNhanVien", maNhanVien);
		List<ThoiGianLamViec> logwork = (List<ThoiGianLamViec>) query.getResultList();
		return logwork;
		
	}
	@Override
	public List<ThoiGianLamViec> listLogworkPhongBan(String maPhongBan) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"FROM ThoiGianLamViec WHERE maPhongBan.maPBan = :maPB ORDER BY maNhanVien.maNVien,maDuAn.maDAn ");
		query.setParameter("maPB", maPhongBan);
		List<ThoiGianLamViec> logworks = (List<ThoiGianLamViec>) query.getResultList();
		return logworks;
	}
	
}
