package fasttrackse.ffse1704.fbms.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.security.UserAccountDao;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserAccountDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserAccount user = userDao.loadUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("No user found with id:" + username);
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(username, user.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, user.getAuthorities());
	}
}