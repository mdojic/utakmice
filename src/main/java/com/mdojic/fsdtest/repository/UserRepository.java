package com.mdojic.fsdtest.repository;

import org.springframework.data.repository.CrudRepository;

import com.mdojic.fsdtest.repository.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUsername(String username);
	
}
