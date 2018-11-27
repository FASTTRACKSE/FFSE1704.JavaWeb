package fasttrackse.ffse1704.fbms.service.security;

import fasttrackse.ffse1704.fbms.entity.security.UserAccount;

public interface UserAccountService {
	public UserAccount loadUserByUsername(final String username);
}
