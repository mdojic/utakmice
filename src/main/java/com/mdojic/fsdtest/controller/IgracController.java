package com.mdojic.fsdtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mdojic.fsdtest.common.dto.IgracDTO;
import com.mdojic.fsdtest.common.dto.IgracSaSlikomDTO;
import com.mdojic.fsdtest.service.IgracService;

@RestController
@RequestMapping("igrac")
public class IgracController {

	@Autowired
	IgracService igracService;
	
	@GetMapping
	public List<IgracDTO> all() {
		return igracService.findAll();
	}
	
	@GetMapping("/{id}")
	public IgracSaSlikomDTO one(@PathVariable Long id) {
		IgracSaSlikomDTO igracDTO = igracService.findById(id);
		if (igracDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Igrac nije pronadjen");
		}
		
		return igracDTO;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		igracService.deleteById(id);
	}
	
	@PostMapping
	public IgracDTO create(@RequestBody IgracSaSlikomDTO igracSaSlikomDTO) {
		if (igracSaSlikomDTO.getSlika() == null || igracSaSlikomDTO.getSlika().length == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Slika je obavezna");
		}
		return igracService.create(igracSaSlikomDTO);
	}
	
	@PutMapping("/{id}")
	public IgracDTO update(@PathVariable Long id, @RequestBody IgracSaSlikomDTO igracSaSlikomDTO) {
		if (igracSaSlikomDTO.getSlika() == null || igracSaSlikomDTO.getSlika().length == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Slika je obavezna");
		}
		
		igracSaSlikomDTO.getIgrac().setId(id);
		IgracDTO igracDTO = igracService.update(igracSaSlikomDTO);
		if (igracDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Igrac nije pronadjen");
		}
		
		return igracDTO;
	}
}


