package fasttrackse.ffse1704.fbms.dao.security;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.security.ChucNang;

@SuppressWarnings("deprecation")
@Repository
public class ChucNangDaoImpl implements ChucNangDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ChucNang findByMaChucNang(String ma_chuc_nang) {
		Session session = this.sessionFactory.openSession();
		ChucNang cn = session.get(ChucNang.class, ma_chuc_nang);
		session.close();
		return cn;
	}
	
	@SuppressWarnings("unchecked")
	public List<ChucNang> findAll() {
		Session session = this.sessionFactory.openSession();
		List<ChucNang> list = session.createQuery("from ChucNang").list();
		session.close();
		return list;
	}

	@Override
	public void save(ChucNang cn) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(cn);
		tx.commit();
		session.close();
	}

	@Override
	public void update(ChucNang cn) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cn);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(String ma_chuc_nang) {
		Session session = this.sessionFactory.openSession();
		Transaction cn = session.beginTransaction();
		session.delete(session.get(ChucNang.class, ma_chuc_nang));
		cn.commit();
		session.close();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void active(String ma_chuc_nang) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery sql = session
				.createSQLQuery("UPDATE chuc_nang SET `trang_thai`=if(`trang_thai`=1,0,1) WHERE `ma_chuc_nang` in ('"
						+ ma_chuc_nang + "')");
		sql.executeUpdate();
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ChucNang getChucNangByCode(String ma_chuc_nang) {
		Session session = this.sessionFactory.openSession();
		List<ChucNang> cn = session.createSQLQuery("select * from chuc_nang WHERE ma_chuc_nang ='" + ma_chuc_nang + "'")
				.setResultTransformer(Transformers.aliasToBean(ChucNang.class)).list();

		session.close();
		return cn.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ChucNang> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<ChucNang> listChucNang = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		session.close();
		return listChucNang;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();
		String sql = "SELECT COUNT(*) FROM `chuc_nang`";
		Query query = session.createSQLQuery(sql);
		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select cn", "select count(*)"));
		String recordsFiltered = query.getSingleResult().toString();
		session.close();
		return recordsFiltered;
	}

}
