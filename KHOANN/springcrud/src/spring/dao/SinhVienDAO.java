package spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import springmvc.entity.*;

public class SinhVienDAO {
	private static final Map<String, SinhVien> svMap = new HashMap<String, SinhVien>();

	public void getSinhVien() {

		SinhVien sinhVien1 = new SinhVien("1", "Khoa", "1999", "Nam");
		SinhVien sinhVien2 = new SinhVien("2", "Hahaa", "1988", "Nu");
		SinhVien sinhVien3 = new SinhVien("3", "hihi ", "1999", "Nam");
		
		svMap.put(sinhVien1.getId(), sinhVien1);
		svMap.put(sinhVien2.getId(), sinhVien2);
		svMap.put(sinhVien3.getId(), sinhVien3);
	}

	public SinhVien getSinhVienById(String id) {
		return svMap.get(id);
	}

	public SinhVien editSinhVien(SinhVien sinhVien) {
		svMap.put(sinhVien.getId(), sinhVien);
		return sinhVien;
	}

	public void deleteSinhVien(String id) {
		svMap.remove(id);
	}

	public SinhVien addSinhVien(SinhVien sinhVien) {
		svMap.put(sinhVien.getId(), sinhVien);
		return sinhVien;
	}

	public List<SinhVien> getAllUser() {
		if (!(svMap.size() > 0)) {
			getSinhVien();
		}
		
		Collection<SinhVien> sv = svMap.values();
		List<SinhVien> list = new ArrayList<SinhVien>();
		list.addAll(sv);
		return list;
	}

}