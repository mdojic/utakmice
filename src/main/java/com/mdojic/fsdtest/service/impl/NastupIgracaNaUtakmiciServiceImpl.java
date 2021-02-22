package com.mdojic.fsdtest.service.impl;

import com.mdojic.fsdtest.common.dto.NastupIgracaNaUtakmiciDTO;
import com.mdojic.fsdtest.common.dto.convert.ModelDTOConverter;
import com.mdojic.fsdtest.repository.NastupIgracaNaUtakmiciRepository;
import com.mdojic.fsdtest.repository.entity.NastupIgracaNaUtakmici;
import com.mdojic.fsdtest.service.NastupIgracaNaUtakmiciService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NastupIgracaNaUtakmiciServiceImpl implements NastupIgracaNaUtakmiciService {

	private final NastupIgracaNaUtakmiciRepository nastupRepository;
	private final ModelDTOConverter converter;
	
	@Autowired
	public NastupIgracaNaUtakmiciServiceImpl(NastupIgracaNaUtakmiciRepository nastupIgracaNaUtakmiciRepository, ModelDTOConverter converter) {
		this.nastupRepository = nastupIgracaNaUtakmiciRepository;
		this.converter = converter;
	}

	@Override
	public List<NastupIgracaNaUtakmiciDTO> findAll() {
		List<NastupIgracaNaUtakmiciDTO> result = new ArrayList<>();
		nastupRepository.findAll().forEach(nastup -> result.add(converter.convert(nastup)));
		return result;
	}

	@Override
	public NastupIgracaNaUtakmiciDTO findById(Long id) {
		return converter.convert(nastupRepository.findById(id).orElse(null));
	}

	@Override
	public List<NastupIgracaNaUtakmiciDTO> findByIgracId(Long igracId) {
		return nastupRepository.findByIgracId(igracId).stream()
				.map(converter::convert).collect(Collectors.toList());
	}
	
	@Override
	public List<NastupIgracaNaUtakmiciDTO> findByUtakmicaId(Long utakmicaId) {
		return nastupRepository.findByUtakmicaId(utakmicaId).stream()
				.map(converter::convert).collect(Collectors.toList());
	}
	
	@Override
	public NastupIgracaNaUtakmiciDTO findByUtakmicaIdAndIgracId(Long utakmicaId, Long igracId) {
		return converter.convert(nastupRepository.findByUtakmicaIdAndIgracId(utakmicaId, igracId));
	}
	
	@Override
	public void deleteById(Long id) {
		nastupRepository.deleteById(id);
	}
	
	@Override
	public void deleteByUtakmicaIdAndIgracId(Long utakmicaId, Long igracId) {
		nastupRepository.deleteByUtakmicaIdAndIgracId(utakmicaId, igracId);
	}

	@Override
	public NastupIgracaNaUtakmiciDTO create(NastupIgracaNaUtakmiciDTO nastupDTO) {
		NastupIgracaNaUtakmici nastup = converter.convert(nastupDTO);
		return converter.convert(nastupRepository.save(nastup));
	}

	@Override
	public NastupIgracaNaUtakmiciDTO update(NastupIgracaNaUtakmiciDTO nastupDTO) {
		if (!nastupRepository.existsById(nastupDTO.getId())) {
			return null;
		}
		
		NastupIgracaNaUtakmici nastup = converter.convert(nastupDTO);
		return converter.convert(nastupRepository.save(nastup));
	}

}
