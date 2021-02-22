package com.mdojic.fsdtest.repository;

import com.mdojic.fsdtest.repository.entity.Igrac;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgracRepository extends CrudRepository<Igrac, Long> {

	public Igrac findByUsername(String username);
	
}
