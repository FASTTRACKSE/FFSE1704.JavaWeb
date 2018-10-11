package model.form;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

public class SinhVienDataModel extends LazyDataModel<SinhVien>{
	private static final long serialVersionUID = 1L;
	
	private SinhVienDAO sinhVienDAO;
	
	public SinhVienDataModel(SinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
		setRowCount(sinhVienDAO.getAllSinhVien().size());
	}
	
	@Override
	public List<SinhVien> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters){
		return sinhVienDAO.getSinhVienLimit(first, pageSize);
	}
}
