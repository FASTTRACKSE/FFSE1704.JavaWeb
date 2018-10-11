package myJSF;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import model.dao.SinhVienDao;
import model.entity.SinhVien;

public class SinhVienDataModel extends LazyDataModel<SinhVien> {

	private static final long serialVersionUID = 1L;
	
	private SinhVienDao sinhVienDao;
	
	public SinhVienDataModel(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
		setRowCount(sinhVienDao.getAllSinhVien().size());
	}

	/*@Override
	public List<SinhVien> load(int first, int pageSize, String sortField, SortOrder sortOder,
			Map<String, Object>filters){
		return sinhVienDao.pageSinhVien(first, pageSize);
	}*/
}
