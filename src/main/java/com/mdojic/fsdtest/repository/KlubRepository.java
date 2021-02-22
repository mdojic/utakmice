package com.mdojic.fsdtest.repository;

import com.mdojic.fsdtest.repository.entity.Klub;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlubRepository extends CrudRepository<Klub, Long> {

}
