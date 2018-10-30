package springmvc.form.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import springmvc.form.entity.User;

public class UserDao {
	private static final Map<String, User> userMap = new HashMap<String, User>();

	public void getUser() {

		User user1 = new User("1", "anh vũ", "anh văn");
		User user2 = new User("2", "anh vũ2", "anh văn");
		User user3 = new User("3", "anh vũ3", "anh văn");
		userMap.put(user1.getId(), user1);
		userMap.put(user2.getId(), user2);
		userMap.put(user3.getId(), user3);
	}

	public User getUserById(String id) {
		return userMap.get(id);
	}

	public User editUser(User user) {
		userMap.put(user.getId(), user);
		return user;
	}
	public void deleteUser(String id) {
		userMap.remove(id);
	}
	public User addUser(User user) {
		userMap.put(user.getId(), user);
		return user;
	}
	public List<User> getAllUser() {
		if (!(userMap.size() > 0)) {
			getUser();
		}
		
		Collection<User> us = userMap.values();
		List<User> list = new ArrayList<User>();
		list.addAll(us);
		return list;
	}

}
