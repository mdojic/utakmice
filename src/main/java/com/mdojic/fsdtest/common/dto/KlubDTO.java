package com.mdojic.fsdtest.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KlubDTO {

	private Long id;
	private String naziv;
	
	private Long mestoId;
	private String nazivMesta;
}	
