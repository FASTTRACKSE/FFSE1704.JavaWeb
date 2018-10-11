package model.form;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import model.dao.UserDao;
import model.entity.SinhVien;

public class SinhVienDataModel extends LazyDataModel<SinhVien> {
	private static final long serialVersionUID =1L;
	private UserDao userDao;
	public SinhVienDataModel(UserDao userDao) {
		this.userDao=userDao;
		setRowCount(userDao.getAllUser().size());
	}
	
	@Override
	public List<SinhVien> load(int first, int pageSize, String sortField, SortOrder sortOder,
			Map<String, Object>filters){
		return userDao.getSinhVienInPage(first, pageSize);
	}
}
