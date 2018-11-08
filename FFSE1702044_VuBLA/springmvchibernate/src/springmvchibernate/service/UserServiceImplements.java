package springmvchibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import springmvchibernate.dao.UserDao;
import springmvchibernate.entity.User;

public class UserServiceImplements implements UserService {
	@Autowired
	UserDao userDAO;

	public UserDao getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDao userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	@Transactional
	public void add(User user) {
		this.userDAO.addUser(user);
	}
}
