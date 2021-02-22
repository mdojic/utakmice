package com.mdojic.fsdtest.service;

import java.util.List;

import com.mdojic.fsdtest.common.dto.TakmicenjeDTO;

public interface TakmicenjeService {

	public List<TakmicenjeDTO> findAll();
	
	public TakmicenjeDTO findById(Long id);
	
	public void deleteById(Long id);
	
	public TakmicenjeDTO create(TakmicenjeDTO takmicenje);
	
	public TakmicenjeDTO update(TakmicenjeDTO takmicenje);
	
}