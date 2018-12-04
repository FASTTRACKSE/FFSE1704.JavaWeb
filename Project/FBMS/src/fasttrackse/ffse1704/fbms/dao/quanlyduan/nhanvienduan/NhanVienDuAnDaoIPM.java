package fasttrackse.ffse1704.fbms.dao.quanlyduan.nhanvienduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvienduan.NhanVienDuAn;

/**
 * @author Joker
 *
 */
@Repository
public class NhanVienDuAnDaoIPM implements NhanVienDuAnDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addNew(NhanVienDuAn nhanVienDuAn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nhanVienDuAn);
	}

	@Override
	public void update(NhanVienDuAn nhanVienDuAn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nhanVienDuAn);
	}

	@Override
	public void delete(String maDuAn, String maNhanVien) {
		Session session = this.sessionFactory.getCurrentSession();
		List<NhanVienDuAn> nhanVienDuAn = session.createQuery(
				"from NhanVienDuAn where ma_du_an = '" + maDuAn + "' and ma_nhan_vien='" + maNhanVien + "'",
				NhanVienDuAn.class).list();
		NhanVienDuAn sv = nhanVienDuAn.get(0);
		if (null != sv) {
			session.delete(sv);
		}

	}

	@Override
	public NhanVienDuAn getNhanVienDuAnByIdDuAnAndIdNhanVien(String maDuAn, String maNhanVien) {
		Session session = this.sessionFactory.getCurrentSession();
		List<NhanVienDuAn> listNhanVienDuAn = session.createQuery(
				"from NhanVienDuAn where ma_du_an = '" + maDuAn + "' and ma_nhan_vien='" + maNhanVien + "'",
				NhanVienDuAn.class).list();
		NhanVienDuAn nhanVienDuAn = listNhanVienDuAn.get(0);
		return nhanVienDuAn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NhanVienDuAn> listNhanVienDuAn(int iDisPlayStart, int iDinPlayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<NhanVienDuAn> nhanVienDuAnList = session.createQuery("from NhanVienDuAn").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		return nhanVienDuAnList;
	}

	@Override
	public int getRecordsTotal() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from NhanVienDuAn").list().size();
		return rowCount;
	}

}
