package com.mdojic.fsdtest.controller;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
import com.mdojic.fsdtest.common.dto.NastupIgracaNaUtakmiciDTO;
import com.mdojic.fsdtest.repository.entity.User;
import com.mdojic.fsdtest.service.IgracService;
import com.mdojic.fsdtest.service.NastupIgracaNaUtakmiciService;
import com.mdojic.fsdtest.service.UserService;

@RestController
@RequestMapping("nastup")
public class NastupIgracaNaUtakmiciController {

	@Autowired
	NastupIgracaNaUtakmiciService nastupService;
	
	@Autowired
	IgracService igracService;
	
	@Autowired UserService userService;
	
	@GetMapping
	public List<NastupIgracaNaUtakmiciDTO> all() {
		return nastupService.findAll();
	}
	
	@GetMapping("/{id}")
	public NastupIgracaNaUtakmiciDTO one(@PathVariable Long id) {
		NastupIgracaNaUtakmiciDTO nastupDTO = nastupService.findById(id);
		if (nastupDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nastup nije pronadjen");
		}
		return nastupDTO;
	}
	
	@GetMapping("/{utakmicaId}/{igracId}")
	public NastupIgracaNaUtakmiciDTO getByUtakmicaIdAndIgracId(@PathVariable Long utakmicaId, @PathVariable Long igracId) {
		NastupIgracaNaUtakmiciDTO nastupDTO =nastupService.findByUtakmicaIdAndIgracId(utakmicaId, igracId);
		if (nastupDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nastup nije pronadjen");
		} 
		
		return nastupDTO;
	}

	@GetMapping("/igrac/{igracId}")
	public List<NastupIgracaNaUtakmiciDTO> getByIgracId(@PathVariable Long igracId, HttpServletRequest httpRequest) {
		
		Principal principal = httpRequest.getUserPrincipal();
		Set<String> loggedUserRoles = userService.getRolesByUsername(principal.getName());
		if (loggedUserRoles.contains("ROLE_ADMIN")) {
			return nastupService.findByIgracId(igracId);
		}
		
		IgracDTO loggedUserIgrac = igracService.findByUsername(principal.getName());
		if (loggedUserIgrac == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Igrac nije pronadjen");
		}
		
		if (!loggedUserIgrac.getId().equals(igracId)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Igrac moze pregledati samo svoje nastupe");
		}
		
		return nastupService.findByIgracId(igracId);
	}
	
	@GetMapping("/utakmica/{utakmicaId}")
	public List<NastupIgracaNaUtakmiciDTO> getByUtakmicaId(@PathVariable Long utakmicaId) {
		return nastupService.findByUtakmicaId(utakmicaId);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		nastupService.deleteById(id);
	}
	
	@DeleteMapping("/{utakmicaId}/{igracId}")
	public void deleteByUtakmicaIdAndIgracId(@PathVariable Long utakmicaId, @PathVariable Long igracId) {
		nastupService.deleteByUtakmicaIdAndIgracId(utakmicaId, igracId);
	}
	
	@PostMapping
	public NastupIgracaNaUtakmiciDTO create(@RequestBody NastupIgracaNaUtakmiciDTO nastupDTO) {
		return nastupService.create(nastupDTO);
	}
	
	@PutMapping("/{id}")
	public NastupIgracaNaUtakmiciDTO update(@PathVariable Long id, @RequestBody NastupIgracaNaUtakmiciDTO nastupDTO) {
		nastupDTO.setId(id);
		nastupDTO = nastupService.update(nastupDTO);
		if (nastupDTO == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nastup nije pronadjen");
		} 
		
		return nastupDTO;
	}
	
}
