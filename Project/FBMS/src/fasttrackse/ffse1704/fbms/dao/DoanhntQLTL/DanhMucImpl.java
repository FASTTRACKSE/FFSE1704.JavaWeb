package fasttrackse.ffse1704.fbms.dao.DoanhntQLTL;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.DoanhntQLTL.DanhMuc;

@Repository
public class DanhMucImpl implements DanhMucDao {
	@Autowired
	private SessionFactory sessionFac;

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhMuc> listAllDanhMuc() {
		Session session = this.sessionFac.openSession();
		List<DanhMuc> list = session.createQuery("from DanhMuc where isDelete = 0").list();
		session.close();
		return list;
	}

	@Override
	public void addDM(DanhMuc dm) {
		Session session = this.sessionFac.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(dm);
		tx.commit();
		session.close();
	}

	@Override
	public void updateDM(DanhMuc dm) {
		Session session = this.sessionFac.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dm);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteDM(String maDM) {
		Session session = this.sessionFac.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(DanhMuc.class, maDM));
		pb.commit();
		session.close();
	}

	@Override
	public DanhMuc getDMbyID(String maDM) {
		Session session = this.sessionFac.openSession();
		DanhMuc dm = session.get(DanhMuc.class, maDM);
		session.close();
		return dm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhMuc> listAllDanhMuc(int start, int limit, String sql) {
		Session session = this.sessionFac.openSession();
		List<DanhMuc> listDM = session.createQuery(sql).setFirstResult(start).setMaxResults(limit).list();
		session.close();
		return listDM;
	}

	@Override
	public String getRecordTotal() {
		Session session = this.sessionFac.openSession();
		String sql = "SELECT COUNT(*) FROM `danh_muc`";
		Query query = session.createSQLQuery(sql);
		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}
}