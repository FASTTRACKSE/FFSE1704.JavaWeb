package springmvchibernate.dao;

import java.util.List;

import springmvchibernate.entity.User;

public interface UserDao {

	public void create(User user);

/*	public List<User> findAllForPaging(int startPosition, int maxResult);
*/
	public void update(User user);

	public void delete(int id);

	public User findById(int id);

	public List<User> listUser();

}
