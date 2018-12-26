/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.framework;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;

/**
 * @author QuangDai
 *
 */
public interface FrameworkService {

	public List<Framework> listFramework(int iDisPlayStart, int iDinPlayLength);

	public int countFramework();

	public void addNew(Framework fw);

	public void update(Framework fw);

	public void delete(String maFramework);

	public Framework getFrameworkByMaFramework(String maFramework);
	
	public int getRecordsByMaFramework(String maFramework);
}
