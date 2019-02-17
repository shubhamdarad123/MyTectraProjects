package com.mytechra.spring.playground.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class UserService implements UserDetailsService{

	@Autowired
	private UserDao dao;
	@Override
	public User loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return dao.getUserByName(username);
	}

	
	
}
