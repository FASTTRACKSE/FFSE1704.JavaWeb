package fasttrackse.ffse1704.fbms.dao.quanlyduan.framework;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.framework.Framework;

public interface FrameworkDao {
	public List<Framework> listFramework();
	
	public void addNew(Framework fw);
	
	public void update(Framework fw);
	
	public void delete(String maFramework);
	
	public Framework getFrameworkByMaFramework(String maFramework);
	
	public List<Framework> listFramework(int iDisPlayStart, int iDinPlayLength, String sql);
	
	public String getRecordsTotal();
	
	public String getRecordsFiltered(String sql);
}
