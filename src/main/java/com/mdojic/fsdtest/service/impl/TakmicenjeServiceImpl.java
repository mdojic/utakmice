package com.mdojic.fsdtest.service.impl;

import com.mdojic.fsdtest.common.dto.TakmicenjeDTO;
import com.mdojic.fsdtest.common.dto.convert.ModelDTOConverter;
import com.mdojic.fsdtest.repository.TakmicenjeRepository;
import com.mdojic.fsdtest.repository.entity.Takmicenje;
import com.mdojic.fsdtest.service.TakmicenjeService;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TakmicenjeServiceImpl implements TakmicenjeService {

	private final TakmicenjeRepository takmicenjeRepository;
	private final ModelDTOConverter converter;
	
	@Autowired
	public TakmicenjeServiceImpl(TakmicenjeRepository takmicenjeRepository, ModelDTOConverter converter) {
		this.takmicenjeRepository = takmicenjeRepository;
		this.converter = converter;
	}

	@Override
	public List<TakmicenjeDTO> findAll() {
		List<TakmicenjeDTO> result = new ArrayList<>();
		takmicenjeRepository.findAll().forEach(takmicenje -> result.add(converter.convert(takmicenje)));
		return result;
	}

	@Override
	public TakmicenjeDTO findById(Long id) {
		return converter.convert(takmicenjeRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteById(Long id) {
		takmicenjeRepository.deleteById(id);
	}

	@Override
	public TakmicenjeDTO create(TakmicenjeDTO takmicenjeDTO) {
		Takmicenje takmicenje = converter.convert(takmicenjeDTO);
		return converter.convert(takmicenjeRepository.save(takmicenje));
	}

	@Override
	public TakmicenjeDTO update(TakmicenjeDTO takmicenjeDTO) {
		if (!takmicenjeRepository.existsById(takmicenjeDTO.getId())) {
			return null;
		}
		
		Takmicenje takmicenje = converter.convert(takmicenjeDTO);
		return converter.convert(takmicenje);
	}
	
}
