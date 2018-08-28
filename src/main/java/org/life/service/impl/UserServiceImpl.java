package org.life.service.impl;

import org.life.dao.UserRepository;
import org.life.entity.User;
import org.life.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
@Service
@ComponentScan("org.life")
public class UserServiceImpl  {//implements UserService{
	/*@Autowired
	UserRepository userRepository;
	
	@Override
	public User createOrUpdate(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

	@Override
	public User find(Object id) {
		// TODO Auto-generated method stub
		return userRepository.getById((Long)id);
	}

	@Override
	public User get(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(userId);
	}
*/
}
