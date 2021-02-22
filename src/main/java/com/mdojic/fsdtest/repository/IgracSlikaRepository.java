package com.mdojic.fsdtest.repository;

import com.mdojic.fsdtest.repository.entity.IgracSlika; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgracSlikaRepository extends CrudRepository<IgracSlika, Long> {

}
