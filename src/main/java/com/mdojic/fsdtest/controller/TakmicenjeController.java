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

import com.mdojic.fsdtest.common.dto.TakmicenjeDTO;
import com.mdojic.fsdtest.service.TakmicenjeService;

@RestController
@RequestMapping("takmicenje")
public class TakmicenjeController {

	@Autowired
	TakmicenjeService takmicenjeService;
	
	@GetMapping
	public List<TakmicenjeDTO> all() {
		return takmicenjeService.findAll();
	}
	
	@GetMapping("/{id}")
	public TakmicenjeDTO one(@PathVariable Long id) {
		TakmicenjeDTO takmicenjeDTO = takmicenjeService.findById(id);
		if (takmicenjeDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Takmicenje nije pronadjeno");
		}
		
		return takmicenjeDTO;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		takmicenjeService.deleteById(id);
	}
	
	@PostMapping
	public TakmicenjeDTO create(@RequestBody TakmicenjeDTO takmicenjeDTO) {
		return takmicenjeService.create(takmicenjeDTO);
	}
	
	@PutMapping("/{id}")
	public TakmicenjeDTO update(@PathVariable Long id, @RequestBody TakmicenjeDTO takmicenjeDTO) {
		takmicenjeDTO.setId(id);
		takmicenjeDTO = takmicenjeService.update(takmicenjeDTO);
		if (takmicenjeDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Takmicenje nije pronadjeno");
		}
		
		return takmicenjeDTO;
	}
	
}
