package com.mdojic.fsdtest.repository.entity;

import java.time.LocalDate;

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
@Table(name = "utakmica")
public class Utakmica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "datum_odigravanja", columnDefinition = "DATE")
	private LocalDate datumOdigravanja;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "takmicenje_id")
	private Takmicenje takmicenje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klub_domacin_id")
	private Klub domacin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klub_gost_id")
	private Klub gost;
	
}
