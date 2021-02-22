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

import com.mdojic.fsdtest.common.dto.KlubDTO;
import com.mdojic.fsdtest.service.KlubService;

@RestController
@RequestMapping("klub")
public class KlubController {

	@Autowired
	KlubService klubService;

	@GetMapping
	public List<KlubDTO> all() {
		return klubService.findAll();
	}
	
	@GetMapping("/{id}")
	public KlubDTO one(@PathVariable Long id) {
		KlubDTO klubDTO = klubService.findById(id);
		if (klubDTO == null) { 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Klub nije pronadjen");
		}
		
		return klubService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		klubService.deleteById(id);
	}
	
	@PostMapping
	public KlubDTO create(@RequestBody KlubDTO klubDTO) {
		return klubService.create(klubDTO);
	}
	
	@PutMapping("/{id}")
	public KlubDTO update(@PathVariable Long id, @RequestBody KlubDTO klubDTO) {
		klubDTO.setId(id);
		klubDTO = klubService.update(klubDTO);
		if (klubDTO == null) { 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Klub nije pronadjen");
		}
		
		return klubDTO;
	}
}
