package com.mdojic.fsdtest.service;

import java.util.Set;

import com.mdojic.fsdtest.repository.entity.User;

public interface UserService {
	
	public User findByUsername(String username);
	
	public User saveUser(User user, String role);

	public Set<String> getRolesByUsername(String username);
}
