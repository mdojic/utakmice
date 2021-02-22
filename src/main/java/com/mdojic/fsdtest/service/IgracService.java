package com.mdojic.fsdtest.service;

import java.util.List;

import com.mdojic.fsdtest.common.dto.IgracDTO;
import com.mdojic.fsdtest.common.dto.IgracSaSlikomDTO;

public interface IgracService {

	public List<IgracDTO> findAll();
	
	public IgracSaSlikomDTO findById(Long id);
	
	public void deleteById(Long id);
	
	public IgracDTO create(IgracSaSlikomDTO igrac);
	
	public IgracDTO update(IgracSaSlikomDTO igrac);
	
	public IgracDTO findByUsername(String username);
}