package fasttrack.DAO;

import java.util.List;

import fasttrack.entity.DiemHocSinh;
import fasttrack.entity.HocSinh;

public interface HocSinhDao {

	public void addHS(HocSinh hs);

	public void updatehs(HocSinh hs);

	public HocSinh getHocSinhByID(String maSV);

	public void delhs(int id);

	/*public List<HocSinh> getAll();*/

	public int count();

	public List<HocSinh> findAll(Integer offset, Integer maxResult);
	
	public List<DiemHocSinh> getDiemHocSinh(String maSV);

}
