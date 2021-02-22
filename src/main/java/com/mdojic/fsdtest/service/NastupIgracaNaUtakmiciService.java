package com.mdojic.fsdtest.service;

import java.util.List; 

import com.mdojic.fsdtest.common.dto.NastupIgracaNaUtakmiciDTO;

public interface NastupIgracaNaUtakmiciService {

	public List<NastupIgracaNaUtakmiciDTO> findAll();
	
	public NastupIgracaNaUtakmiciDTO findById(Long id);

	public List<NastupIgracaNaUtakmiciDTO> findByIgracId(Long igracId);

	public List<NastupIgracaNaUtakmiciDTO> findByUtakmicaId(Long utakmicaId);
	
	public NastupIgracaNaUtakmiciDTO findByUtakmicaIdAndIgracId(Long utakmicaId, Long igracId);
	
	public void deleteById(Long id);
	
	public void deleteByUtakmicaIdAndIgracId(Long utakmicaId, Long igracId);
	
	public NastupIgracaNaUtakmiciDTO create(NastupIgracaNaUtakmiciDTO nastup);
	
	public NastupIgracaNaUtakmiciDTO update(NastupIgracaNaUtakmiciDTO nastup);
	
}