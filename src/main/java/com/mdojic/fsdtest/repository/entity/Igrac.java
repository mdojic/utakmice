package com.mdojic.fsdtest.repository.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mdojic.fsdtest.common.enums.PozicijaIgraca;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "igrac")
public class Igrac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String username;
	
	@Column
	private String ime;
	
	@Column
	private String prezime;
	
	@Column
	private String jmbg;
	
	@Column(name = "datum_rodjenja", columnDefinition = "DATE")
	private LocalDate datumRodjenja;

	@Column
	@Enumerated(EnumType.STRING)
	private PozicijaIgraca pozicija;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mesto_id")
	private Mesto mesto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "klub_id")
	private Klub klub;
	
}
