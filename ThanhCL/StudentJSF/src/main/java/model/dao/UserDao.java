package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.bean.User;

@ManagedBean(name = "userDao")
@SessionScoped
public class UserDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/myjavaapp";
	private String jdbcUsername = "myjavaapp";
	private String jdbcPassword = "myjavaapp";
	private Connection jdbcConnection;

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public List<User> getAllRecords() {
		System.out.println("get data");
		List<User> list = new ArrayList<User>();

		try {
			connect();
			PreparedStatement ps = jdbcConnection.prepareStatement("select * from testcrud");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				list.add(u);
			}
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public String addUser(User u) {
		int status = 0;
		try {
			connect();
			PreparedStatement ps = jdbcConnection
					.prepareStatement("insert into testcrud(id,name,password,email,sex,country) values(?,?,?,?,?,?)");
			ps.setString(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getSex());
			ps.setString(6, u.getCountry());
			status = ps.executeUpdate();
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		if (status != 0) {
			return "/usersList.xhtml?faces-redirect=true";
		} else {
			return "/addUserForm.xhtml?faces-redirect=true";
		}
	}

	public String showUpdateUser(String userId) {
		User u = null;
		/* Setting The Particular Student Details In Session */
		Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try {
			connect();
			PreparedStatement ps = jdbcConnection.prepareStatement("select * from testcrud where id=?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
			}
			sessionMapObj.put("editRecordObj", u);
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/updateUserForm.xhtml?faces-redirect=true";
	}

	public String doUpdateUser(User u) {
		PreparedStatement ps;
		try {
			connect();
			if (u.getPassword().isEmpty()) {
				ps = jdbcConnection.prepareStatement("update testcrud set name=?,email=?,sex=?,country=? where id=?");
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getSex());
				ps.setString(4, u.getCountry());
				ps.setString(5, u.getId());
			} else {
				ps = jdbcConnection
						.prepareStatement("update testcrud set name=?,password=?,email=?,sex=?,country=? where id=?");
				ps.setString(1, u.getName());
				ps.setString(2, u.getPassword());
				ps.setString(3, u.getEmail());
				ps.setString(4, u.getSex());
				ps.setString(5, u.getCountry());
				ps.setString(6, u.getId());
			}
			ps.executeUpdate();
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/usersList.xhtml?faces-redirect=true";
	}

	public String deleteUser(String userId) {
		try {
			connect();
			PreparedStatement ps = jdbcConnection.prepareStatement("delete from testcrud where id=?");
			ps.setString(1, userId);
			ps.executeUpdate();
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}

		return "/usersList.xhtml?faces-redirect=true";
	}

	public int countRecords() {
		try {
			connect();
			PreparedStatement ps = jdbcConnection.prepareStatement("select count(*) from testcrud");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			disconnect();
			return count;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public List<User> getRecords(int start, int total) {
		List<User> list = new ArrayList<User>();
		try {
			connect();
			PreparedStatement ps = jdbcConnection
					.prepareStatement("select * from testcrud limit " + (start) + "," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				list.add(u);
			}
			disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
