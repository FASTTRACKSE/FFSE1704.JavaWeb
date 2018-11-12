package fasttrack.service;

import java.util.List;

import fasttrack.entity.HocSinh;


public interface  HocSinhService {
	public void addhs(HocSinh hs);
	
	public void updatehs(HocSinh hs);
	
	public HocSinh getHocSinhByID(int id);

	public void delhs(int id);
	
	public List<HocSinh> getAll();
	
	public List<HocSinh> findAllForPaging(int startPosition,int maxResult);

}
