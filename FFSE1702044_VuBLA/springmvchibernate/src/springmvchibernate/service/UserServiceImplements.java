package springmvchibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvchibernate.dao.UserDao;
import springmvchibernate.entity.User;
@Service
@Transactional
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
	public List<User> listUser() {
		return this.userDAO.listUser();
	}

	@Override
	@Transactional
	public User findById(int id) {
		// TODO Auto-generated method stub
		return this.userDAO.findById(id);
	}

	@Override
	@Transactional
	public void add(User user) {
		this.userDAO.create(user);
	}

	@Override
	@Transactional
	public void update(User user) {
		this.userDAO.update(user);

	}

	@Override
	@Transactional
	public void delete(int id) {
		this.userDAO.delete(id);

	}

/*	@Override
	@Transactional
	public List<User> findAllForPaging(int startPosition, int maxResult) {
		return this.userDAO.findAllForPaging(startPosition, maxResult);
	}*/
}
