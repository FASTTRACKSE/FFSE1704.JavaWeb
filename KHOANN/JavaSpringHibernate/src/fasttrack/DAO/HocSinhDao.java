package fasttrack.DAO;

import java.util.List;

import fasttrack.entity.HocSinh;
 
public interface HocSinhDao {
 
	public void addHS(HocSinh hs);
	
	public void updatehs(HocSinh hs);
	
	public HocSinh getHocSinhByID(int id);

	public void delhs(int id);
	
	public List<HocSinh> getAll();

	

	public int count();

	List<HocSinh> findAll(Integer offset, Integer maxResult);
	
	


 
}
