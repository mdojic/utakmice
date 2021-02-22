package com.mdojic.fsdtest.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "igrac_utakmica_nastup")
public class NastupIgracaNaUtakmici {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ocena_igraca")
	private Double ocenaIgraca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "igrac_id")
	private Igrac igrac;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utakmica_id")
	private Utakmica utakmica;
	
}
