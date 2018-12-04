/**
 * 
 */
package fasttrackse.ffse1704.fbms.dao.quanlyduan.framework;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;

/**
 * @author QuangDai
 *
 */
@Repository
public class FrameworkDaoIPM implements FrameworkDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Framework> listFramework(){
		 Session session = this.sessionFactory.openSession();
		 List<Framework> list = ((org.hibernate.Session) session).createQuery("from Framework").list();
		 session.close();
		 return list;
	}
	
	@Override
	public void addNew(Framework fw) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(fw);
		tx.commit();
		session.close();
	}
	
	@Override
	public void update(Framework fw) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(fw);
		tx.commit();
		session.close();
	}
	
	@Override
	public void delete(String maFramework) {
		Session session = this.sessionFactory.openSession();
		Transaction pd = session.beginTransaction();
		session.update(session.get(Framework.class, maFramework));
		pd.commit();
		session.close();
	}
	
	@Override
	public Framework getFrameworkByMaFramework(String maFramework) {
		Session session = this.sessionFactory.openSession();
		Framework pd = session.get(Framework.class, maFramework);
		session.close();
		return pd;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Framework> listFramework(int iDisPlayStart, int iDinPlayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<Framework> listFramework = session.createQuery(sql).setFirstResult(iDisPlayStart).setMaxResults(iDinPlayLength).list();
		session.close();
		return listFramework;
	}
	
	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();
		
		String sql = "SELECT COUNT(*) FROM 'framework'";
		Query query = session.createSQLQuery(sql);
		
		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}
	
	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select cd", "select count(*)"));
		String recordsFiltered = query.getSingleResult().toString();
		session.close();
		return recordsFiltered;
	}
}