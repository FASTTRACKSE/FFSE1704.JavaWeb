/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyduan.database.DatabaseDao;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database;

/**
 * @author QuangDai
 *
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {
	@Autowired
	private DatabaseDao databaseDao;

	public DatabaseDao getDatabaseDao() {
		return databaseDao;
	}

	public void setDatabaseDao(DatabaseDao databaseDao) {
		this.databaseDao = databaseDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.database.DatabaseService#
	 * listDatabase(int, int)
	 */
	@Override
	public List<Database> listDatabase(int iDisPlayStart, int iDinPlayLength) {
		return this.databaseDao.listDatabase(iDisPlayStart, iDinPlayLength);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.database.DatabaseService#
	 * countDatabase()
	 */
	@Override
	public int countDatabase() {
		return this.databaseDao.countDatabase();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.database.DatabaseService#addNew(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database)
	 */
	@Override
	public void addNew(Database db) {
		this.databaseDao.addNew(db);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.database.DatabaseService#update(
	 * fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database)
	 */
	@Override
	public void update(Database db) {
		this.databaseDao.update(db);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fasttrackse.ffse1704.fbms.service.quanlyduan.database.DatabaseService#delete(
	 * java.lang.String)
	 */
	@Override
	public void delete(String maDatabase) {
		this.databaseDao.delete(maDatabase);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fasttrackse.ffse1704.fbms.service.quanlyduan.database.DatabaseService#
	 * getDatabaseByMaDatabase(java.lang.String)
	 */
	@Override
	public Database getDatabaseByMaDatabase(String maDatabase) {
		return this.databaseDao.getDatabaseByMaDatabase(maDatabase);
	}

}
