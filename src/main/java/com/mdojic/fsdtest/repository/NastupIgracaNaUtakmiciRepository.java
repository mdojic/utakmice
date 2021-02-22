package com.mdojic.fsdtest.repository;

import com.mdojic.fsdtest.repository.entity.NastupIgracaNaUtakmici;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NastupIgracaNaUtakmiciRepository extends CrudRepository<NastupIgracaNaUtakmici, Long> {

	public List<NastupIgracaNaUtakmici> findByIgracId(Long igracId);
	
	public List<NastupIgracaNaUtakmici> findByUtakmicaId(Long utakmicaId);
	
	public NastupIgracaNaUtakmici findByUtakmicaIdAndIgracId(Long utakmicaId, Long igracId);

	public void deleteByUtakmicaIdAndIgracId(Long utakmicaId, Long igracId);
	
}
