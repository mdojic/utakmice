package com.mdojic.fsdtest.common.dto;

import java.time.LocalDate;

import com.mdojic.fsdtest.common.enums.PozicijaIgraca;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IgracDTO {

	private Long id;
	private String ime;
	private String prezime;
	private String username;
	private String jmbg;
	private LocalDate datumRodjenja;
	private PozicijaIgraca pozicija;
	
	private Long mestoId;
	private String nazivMesta;
	
	private Long klubId;
	private String nazivKluba;
	
}
