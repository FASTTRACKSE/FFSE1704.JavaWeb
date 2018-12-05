/**
 * 
 */
package fasttrackse.ffse1704.fbms.dao.quanlyduan.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database;

/**
 * @author QuangDai
 *
 */
@Repository
public class DatabaseDaoImpl implements DatabaseDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.database.DatabaseDao#listDatabase(
	 * int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Database> listDatabase(int iDisPlayStart, int iDinPlayLength) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		List<Database> listDatabase = session.createQuery("FROM database").setFirstResult(iDisPlayStart)
				.setMaxResults(iDinPlayLength).list();
		return listDatabase;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.database.DatabaseDao#countDatabase()
	 */
	@Override
	public int countDatabase() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from database").list().size();
		return rowCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.database.DatabaseDao#addNew(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database)
	 */
	@Override
	public void addNew(Database db) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.persist(db);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.database.DatabaseDao#update(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database)
	 */
	@Override
	public void update(Database db) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		session.update(db);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.dao.quanlyduan.database.DatabaseDao#delete(java.
	 * lang.String)
	 */
	@Override
	public void delete(String maDatabase) {
		Session session = (Session) this.sessionFactory.getCurrentSession();
		Database db = session.load(Database.class, maDatabase);
		if (null != db) {
			session.delete(db);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.dao.quanlyduan.database.DatabaseDao#
	 * getDatabaseByMaDatabase(java.lang.String)
	 */
	@Override
	public Database getDatabaseByMaDatabase(String maDatabase) {
		Session session = this.sessionFactory.getCurrentSession();
		Database db = (Database) session.get(Database.class, maDatabase);
		return db;
	}

}
