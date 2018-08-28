package org.life.service;

import org.life.entity.User;

public interface UserService {
	User createOrUpdate(User user);

	void remove(User user);

	User find(Object id);

	User get(String userId);
}
