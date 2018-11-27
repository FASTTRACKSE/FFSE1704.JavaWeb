package springmvchibernate.service;

import java.util.List;

import springmvchibernate.entity.User;

public interface UserService {

	public void add(User user);

/*	public List<User> findAllForPaging(int startPosition, int maxResult);
*/
	public void delete(int id);

	public void update(User user);

	public User findById(int id);

	public List<User> listUser();

}
