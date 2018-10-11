package model.dao;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserDAO {
	public String getNameUser(int id) {
		//giá trị đã lấy từ database
		String name = "ABC 123";
		return name;
		
	}
}
