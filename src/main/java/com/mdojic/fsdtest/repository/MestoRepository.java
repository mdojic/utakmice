package com.mdojic.fsdtest.repository;

import com.mdojic.fsdtest.repository.entity.Mesto; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MestoRepository extends CrudRepository<Mesto, Long> {

}
