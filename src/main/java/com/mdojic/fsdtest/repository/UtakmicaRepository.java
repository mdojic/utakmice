package com.mdojic.fsdtest.repository;

import com.mdojic.fsdtest.repository.entity.Utakmica;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtakmicaRepository extends CrudRepository<Utakmica, Long> {

}
