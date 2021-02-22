package com.mdojic.fsdtest.service;

import java.util.List;

import com.mdojic.fsdtest.common.dto.KlubDTO;

public interface KlubService {

	public List<KlubDTO> findAll();
	
	public KlubDTO findById(Long id);
	
	public void deleteById(Long id);
	
	public KlubDTO create(KlubDTO klub);
	
	public KlubDTO update(KlubDTO klub);
}