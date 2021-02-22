package com.mdojic.fsdtest.service;

import java.util.List;

import com.mdojic.fsdtest.common.dto.UtakmicaDTO;

public interface UtakmicaService {

	public List<UtakmicaDTO> findAll();
	
	public UtakmicaDTO findById(Long id);
	
	public void deleteById(Long id);
	
	public UtakmicaDTO create(UtakmicaDTO utakmica);
	
	public UtakmicaDTO update(UtakmicaDTO utakmica);
	
}