package ffse1704.jsfstaff.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ffse1704.jsfstaff.dao.StaffDAO;
import ffse1704.jsfstaff.entity.Staff;

@ManagedBean(name="staff")
@SessionScoped
public class StaffForm {
	private StaffDAO staffDAO;
	private List<Staff> listStaff;

	

	public StaffDAO getStaffDAO() {
		return staffDAO;
	}

	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	public List<Staff> getListStaff() {
		return listStaff;
	}

	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}
	public StaffForm() throws Exception{
		listStaff = new ArrayList<Staff>();
		staffDAO = new StaffDAO();
		//get list of Staff
		loadStafflist();
	}
	public void loadStafflist() {
		listStaff = staffDAO.getAllStaff();
	}
	
}
