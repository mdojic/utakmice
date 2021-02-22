package com.mdojic.fsdtest.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class TakmicenjeDTO {

	private Long id;
	private String naziv;
	
}
