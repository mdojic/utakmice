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

import com.mdojic.fsdtest.common.dto.MestoDTO;
import com.mdojic.fsdtest.service.MestoService;

@RestController
@RequestMapping("mesto")
public class MestoController {

	@Autowired
	MestoService mestoService;

	@GetMapping
	public List<MestoDTO> all() {
		return mestoService.findAll();
	}
	
	@GetMapping("/{id}")
	public MestoDTO one(@PathVariable Long id) {
		MestoDTO mestoDTO = mestoService.findById(id);
		if (mestoDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesto nije pronadjeno");
		}
		
		return mestoDTO;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		mestoService.deleteById(id);
	}
	
	@PostMapping
	public MestoDTO create(@RequestBody MestoDTO mestoDTO) {
		return mestoService.create(mestoDTO);
	}
	
	@PutMapping("/{id}")
	public MestoDTO update(@PathVariable Long id, @RequestBody MestoDTO mestoDTO) {
		mestoDTO.setId(id);
		mestoDTO = mestoService.update(mestoDTO);
		if (mestoDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesto nije pronadjeno");
		}
		return mestoService.update(mestoDTO);
	}
	
}
