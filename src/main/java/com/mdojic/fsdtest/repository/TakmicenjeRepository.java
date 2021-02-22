package com.mdojic.fsdtest.repository;

import com.mdojic.fsdtest.repository.entity.Takmicenje; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakmicenjeRepository extends CrudRepository<Takmicenje, Long> {

}
