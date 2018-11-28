package fasttrack.service;

import java.util.List;

import fasttrack.entity.DiemHocSinh;
import fasttrack.entity.HocSinh;

public interface HocSinhService {
	public void addhs(HocSinh hs);

	public void updatehs(HocSinh hs);

	public HocSinh getHocSinhByID(String maSV);

	public void delhs(int id);

	/*public List<HocSinh> getAll();*/

	public List<HocSinh> findAll(Integer offset, Integer maxResult);

	public int count();

	public List<DiemHocSinh> getDiemHocSinh(String maSV);
}
