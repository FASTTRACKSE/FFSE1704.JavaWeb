package fasttrackse.ffse1704.fbms.dao.security;

import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

public interface UserAccountDao {
	public UserAccount loadUserByUsername(final String username);
}