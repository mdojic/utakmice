package com.mdojic.fsdtest.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NastupIgracaNaUtakmiciDTO {

	private Long id;
	private Double ocenaIgraca;
	private Long igracId;
	private Long utakmicaId;

}
