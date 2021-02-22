package com.mdojic.fsdtest.service.impl;

import com.mdojic.fsdtest.common.dto.UtakmicaDTO;
import com.mdojic.fsdtest.common.dto.convert.ModelDTOConverter;
import com.mdojic.fsdtest.repository.UtakmicaRepository;
import com.mdojic.fsdtest.repository.entity.Utakmica;
import com.mdojic.fsdtest.service.UtakmicaService;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UtakmicaServiceImpl implements UtakmicaService {

	private final UtakmicaRepository utakmicaRepository;
	private final ModelDTOConverter converter;
	
	@Autowired
	public UtakmicaServiceImpl(UtakmicaRepository utakmicaRepository, ModelDTOConverter converter) {
		this.utakmicaRepository = utakmicaRepository;
		this.converter = converter;
	}

	@Override
	public UtakmicaDTO findById(Long id) {
		return converter.convert(utakmicaRepository.findById(id).orElse(null));
	}

	@Override
	public List<UtakmicaDTO> findAll() {
		List<UtakmicaDTO> result = new ArrayList<>();
		utakmicaRepository.findAll().forEach(utakmica -> result.add(converter.convert(utakmica)));
		return result;
	}
	
	@Override
	public void deleteById(Long id) {
		utakmicaRepository.deleteById(id);
	}

	@Override
	public UtakmicaDTO create(UtakmicaDTO utakmicaDTO) {
		Utakmica utakmica = converter.convert(utakmicaDTO); 
		return converter.convert(utakmicaRepository.save(utakmica));
	}

	@Override
	public UtakmicaDTO update(UtakmicaDTO utakmicaDTO) {
		if (!utakmicaRepository.existsById(utakmicaDTO.getId())) {
			return null;
		}
		
		Utakmica utakmica = converter.convert(utakmicaDTO);
		return converter.convert(utakmicaRepository.save(utakmica));
	}

}
