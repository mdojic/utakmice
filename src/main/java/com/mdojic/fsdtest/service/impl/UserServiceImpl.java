package com.mdojic.fsdtest.service.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mdojic.fsdtest.repository.RoleRepository;
import com.mdojic.fsdtest.repository.UserRepository;
import com.mdojic.fsdtest.repository.entity.Role;
import com.mdojic.fsdtest.repository.entity.User;
import com.mdojic.fsdtest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User saveUser(User user, String role) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role userRole = roleRepository.findByRole(role);
		user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
		return userRepository.save(user);
	}
	
	@Override
	public Set<String> getRolesByUsername(String username) {
		User user = findByUsername(username);
		return user.getRoles().stream().map(role -> role.getRole()).collect(Collectors.toSet());
	}
}
