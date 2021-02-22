package com.mdojic.fsdtest.service.impl;

import com.mdojic.fsdtest.common.dto.MestoDTO;
import com.mdojic.fsdtest.common.dto.convert.ModelDTOConverter;
import com.mdojic.fsdtest.repository.MestoRepository;
import com.mdojic.fsdtest.repository.entity.Mesto;
import com.mdojic.fsdtest.service.MestoService;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MestoServiceImpl implements MestoService {

	private final MestoRepository mestoRepository;
	private final ModelDTOConverter converter;
	
	@Autowired
	public MestoServiceImpl(MestoRepository mestoRepository, ModelDTOConverter converter) {
		this.mestoRepository = mestoRepository;
		this.converter = converter;
	}

	@Override
	public MestoDTO findById(Long id) {
		return converter.convert(mestoRepository.findById(id).orElse(null));
	}
	
	@Override
	public List<MestoDTO> findAll() {
		List<MestoDTO> result = new ArrayList<>();
		mestoRepository.findAll().forEach(mesto -> result.add(converter.convert(mesto)));
		return result;
	}

	@Override
	public void deleteById(Long id) {
		mestoRepository.deleteById(id);
	}

	@Override
	public MestoDTO create(MestoDTO mestoDTO) {
		Mesto mesto = converter.convert(mestoDTO);
		return converter.convert(mestoRepository.save(mesto));
	}

	@Override
	public MestoDTO update(MestoDTO mestoDTO) {
		if (!mestoRepository.existsById(mestoDTO.getId())) {
			return null;
		}
		
		Mesto mesto = converter.convert(mestoDTO);
		return converter.convert(mestoRepository.save(mesto));
	}
	
}
