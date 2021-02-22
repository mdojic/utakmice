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

import com.mdojic.fsdtest.common.dto.UtakmicaDTO;
import com.mdojic.fsdtest.service.UtakmicaService;

@RestController
@RequestMapping("utakmica")
public class UtakmicaController {

	@Autowired
	UtakmicaService utakmicaService;

	@GetMapping
	public List<UtakmicaDTO> all() {
		return utakmicaService.findAll();
	}
	
	@GetMapping("/{id}")
	public UtakmicaDTO one(@PathVariable Long id) {
		UtakmicaDTO utakmicaDTO = utakmicaService.findById(id);
		if (utakmicaDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utakmica nije pronadjena");
		}
		
		return utakmicaDTO;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		utakmicaService.deleteById(id);
	}
	
	@PostMapping
	public UtakmicaDTO create(@RequestBody UtakmicaDTO utakmicaDTO) {
		return utakmicaService.create(utakmicaDTO);
	}
	
	@PutMapping("/{id}")
	public UtakmicaDTO update(@PathVariable Long id, @RequestBody UtakmicaDTO utakmicaDTO) {
		utakmicaDTO.setId(id);
		utakmicaDTO = utakmicaService.update(utakmicaDTO);
		if (utakmicaDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utakmica nije pronadjena");
		}
		
		return utakmicaDTO;
	}
}
