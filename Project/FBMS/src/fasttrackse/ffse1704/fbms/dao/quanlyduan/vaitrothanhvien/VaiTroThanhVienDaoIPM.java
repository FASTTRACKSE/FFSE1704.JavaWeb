package fasttrackse.ffse1704.fbms.dao.quanlyduan.vaitrothanhvien;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.vaitrothanhvien.VaiTroThanhVien;

/**
 * @author Joker
 *
 */
@Repository
public class VaiTroThanhVienDaoIPM implements VaiTroThanhVienDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addNew(VaiTroThanhVien vaiTroThanhVien) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(vaiTroThanhVien);

	}

	@Override
	public void update(VaiTroThanhVien vaiTroThanhVien) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vaiTroThanhVien);

	}

	@Override
	public void delete(String VaiTroThanhVien) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(VaiTroThanhVien.class, VaiTroThanhVien));
		pd.commit();
		session.close();

	}

	@Override
	public VaiTroThanhVien getVaiTroThanhVienByIdVaiTroThanhVien(String maVaiTroThanhVien) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VaiTroThanhVien> listVaiTroThanhVien = session.createQuery("from VaiTroThanhVien where maVaiTro = '" + maVaiTroThanhVien + "'", VaiTroThanhVien.class)
				.list();
		VaiTroThanhVien vaiTroThanhVien = listVaiTroThanhVien.get(0);
		return vaiTroThanhVien;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VaiTroThanhVien> listVaiTroThanhVien(int iDisPlayStart, int iDinPlayLength) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VaiTroThanhVien> vaiTroThanhVienList = session.createQuery("from VaiTroThanhVien")
				.setFirstResult(iDisPlayStart).setMaxResults(iDinPlayLength).list();
		return vaiTroThanhVienList;
	}

	@Override
	public int getRecordsTotal() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from VaiTroThanhVien").list().size();
		return rowCount;
	}

	@Override
	public int getRecordsByIdVaiTroThanhVien(String maVaiTroThanhVien) {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from VaiTroThanhVien where maVaiTroThanhVien='" + maVaiTroThanhVien + "'").list().size();
		return rowCount;
	}

}
