/**
 * 
 */
package fasttrackse.ffse1704.fbms.dao.quanlyduan.database;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.database.Database;

/**
 * @author QuangDai
 *
 */
public interface DatabaseDao {

	public List<Database> listDatabase(int iDisPlayStart, int iDinPlayLength);

	public int countDatabase();

	public void addNew(Database db);

	public void update(Database db);

	public void delete(String maDatabase);

	public Database getDatabaseByMaDatabase(String maDatabase);
}
