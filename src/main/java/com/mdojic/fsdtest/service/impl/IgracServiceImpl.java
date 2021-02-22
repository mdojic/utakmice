package com.mdojic.fsdtest.service.impl;

import com.mdojic.fsdtest.common.dto.IgracDTO;
import com.mdojic.fsdtest.common.dto.IgracSaSlikomDTO;
import com.mdojic.fsdtest.common.dto.convert.ModelDTOConverter;
import com.mdojic.fsdtest.repository.IgracRepository;
import com.mdojic.fsdtest.repository.IgracSlikaRepository;
import com.mdojic.fsdtest.repository.entity.Igrac;
import com.mdojic.fsdtest.repository.entity.IgracSlika;
import com.mdojic.fsdtest.service.IgracService;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IgracServiceImpl implements IgracService {

	private final IgracRepository igracRepository;
	private final IgracSlikaRepository igracSlikaRepository;
	private final ModelDTOConverter converter;
	
	@Autowired
	public IgracServiceImpl(IgracRepository igracRepository,
			IgracSlikaRepository igracSlikaRepository,
			ModelDTOConverter converter) {
		this.igracRepository = igracRepository;
		this.igracSlikaRepository = igracSlikaRepository;
		this.converter = converter;
	}

	@Override
	public IgracSaSlikomDTO findById(Long id) {
		IgracDTO igracDTO = converter.convert(igracRepository.findById(id).orElse(null));
		if (igracDTO == null) {
			return null;
		}
		
		IgracSaSlikomDTO igracSaSlikomDTO = IgracSaSlikomDTO.builder()
				.slika(igracSlikaRepository.findById(id).get().getSlika())
				.igrac(igracDTO)
				.build();
		
		return igracSaSlikomDTO;
	}
	
	@Override
	public List<IgracDTO> findAll() {
		List<IgracDTO> result = new ArrayList<>();
		igracRepository.findAll().forEach(igrac -> result.add(converter.convert(igrac)));
		return result;
	}
	
	@Override
	public void deleteById(Long id) {
		igracRepository.deleteById(id);
		igracSlikaRepository.deleteById(id);
	}

	@Override
	public IgracDTO create(IgracSaSlikomDTO igracSaSlikomDTO) {
		Igrac igrac = converter.convert(igracSaSlikomDTO.getIgrac());		
		igrac = igracRepository.save(igrac);
		
		IgracSlika igracSlika = IgracSlika.builder().igrac(igrac).slika(igracSaSlikomDTO.getSlika()).build();
		igracSlikaRepository.save(igracSlika);
		
		return converter.convert(igrac);
	}
	
	@Override
	public IgracDTO update(IgracSaSlikomDTO igracSaSlikomDTO) {
		if (!igracRepository.existsById(igracSaSlikomDTO.getIgrac().getId())) {
			return null;
		}
		
		updateIgracSlika(igracSaSlikomDTO);
		
		Igrac igrac = converter.convert(igracSaSlikomDTO.getIgrac());
		return converter.convert(igracRepository.save(igrac));
	}
	
	private void updateIgracSlika(IgracSaSlikomDTO igracSaSlikomDTO) {
		byte[] slika = igracSaSlikomDTO.getSlika();
		IgracSlika igracSlika = igracSlikaRepository.findById(igracSaSlikomDTO.getIgrac().getId()).get();
		igracSlika.setSlika(slika);
		igracSlikaRepository.save(igracSlika);
	}
	
	@Override
	public IgracDTO findByUsername(String username) {
		return converter.convert(igracRepository.findByUsername(username));
	}
}
