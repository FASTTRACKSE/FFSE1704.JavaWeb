package model.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.bo.Paginator;
import model.dao.UserDao;

@SuppressWarnings("restriction")
@ManagedBean
@SessionScoped
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id, name, password, email, sex, country;
	private List<User> usersList;

	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;

	@ManagedProperty(value = "#{paginator}")
	private Paginator paginator;

	@PostConstruct
	public void init() {
		int countRecords = userDao.countRecords();
		paginator.setUserList(countRecords);
		setUsersList();
	}

	public List<User> getUsersList() {
		return usersList;
	}

	// Pagination
	public void next() {
		paginator.next();
		setUsersList();
	}

	public void prev() {
		paginator.prev();
		setUsersList();
	}

	public void firstPage() {
		paginator.firstPage();
		setUsersList();
	}

	public void lastPage() {
		paginator.lastPage();
		setUsersList();
	}

	public void setUsersList() {
		this.usersList = userDao.getRecords(paginator.getFromIndex(), paginator.getRecords());
	}

	// CRUD
	public String returnIndex() {
		return "/usersList.xhtml?faces-redirect=true";
	}

	public String addUser(User u) {
		String rs = userDao.addUser(u);
		init();
		return rs;
	}

	public String showUpdateUser(String userId) {
		return userDao.showUpdateUser(userId);
	}

	public String doUpdateUser(User u) {
		String rs = userDao.doUpdateUser(u);
		init();
		return rs;
	}

	public String deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	public User() {
		super();
	}

	public User(String id, String name, String password, String email, String sex, String country) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

}
