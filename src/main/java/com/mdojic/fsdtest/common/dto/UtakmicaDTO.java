package com.mdojic.fsdtest.common.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtakmicaDTO {

	private Long id;
	private LocalDate datumOdigravanja;
	
	private Long takmicenjeId;
	private String nazivTakmicenja;
	
	private Long klubDomacinId;
	private String nazivKlubaDomacina;
	
	private Long klubGostId;
	private String nazivKlubaGosta;
	
}
