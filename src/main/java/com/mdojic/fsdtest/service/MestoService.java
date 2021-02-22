package com.mdojic.fsdtest.service;

import java.util.List;

import com.mdojic.fsdtest.common.dto.MestoDTO;

public interface MestoService {

	public List<MestoDTO> findAll();
	
	public MestoDTO findById(Long id);
	
	public void deleteById(Long id);
	
	public MestoDTO create(MestoDTO mesto);
	
	public MestoDTO update(MestoDTO mesto);
	
}