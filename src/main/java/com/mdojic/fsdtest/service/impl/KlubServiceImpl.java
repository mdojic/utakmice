package com.mdojic.fsdtest.service.impl;

import com.mdojic.fsdtest.common.dto.KlubDTO;
import com.mdojic.fsdtest.common.dto.convert.ModelDTOConverter;
import com.mdojic.fsdtest.repository.KlubRepository;
import com.mdojic.fsdtest.repository.entity.Klub;
import com.mdojic.fsdtest.service.KlubService;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class KlubServiceImpl implements KlubService {

	private final KlubRepository klubRepository;
	private final ModelDTOConverter converter;
	
	@Autowired
	public KlubServiceImpl(KlubRepository klubRepository, ModelDTOConverter converter) {
		this.klubRepository = klubRepository;
		this.converter = converter;
	}

	@Override
	public KlubDTO findById(Long id) {
		return converter.convert(klubRepository.findById(id).orElse(null));
	}

	@Override
	public List<KlubDTO> findAll() {
		List<KlubDTO> result = new ArrayList<>();
		klubRepository.findAll().forEach(klub -> result.add(converter.convert(klub)));
		return result;
	}
	
	@Override
	public void deleteById(Long id) {
		klubRepository.deleteById(id);
	}

	@Override
	public KlubDTO create(KlubDTO klubDTO) {
		Klub klub = converter.convert(klubDTO);
		return converter.convert(klubRepository.save(klub));
	}
	
	@Override
	public KlubDTO update(KlubDTO klubDTO) {
		if (!klubRepository.existsById(klubDTO.getId())) {
			return null;
		}
		
		Klub klub = converter.convert(klubDTO);
		return converter.convert(klubRepository.save(klub));
	}
}
