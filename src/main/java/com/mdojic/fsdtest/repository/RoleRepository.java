package com.mdojic.fsdtest.repository;

import org.springframework.data.repository.CrudRepository;

import com.mdojic.fsdtest.repository.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByRole(String role);
	
}
