package com.mdojic.fsdtest.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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
@Table(name = "igrac_slika")
public class IgracSlika {

	@Id
	@Column(name = "igrac_id")
	private Long id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "igrac_id")
	private Igrac igrac;

	@Lob
	@Column(name = "slika")
	private byte[] slika;
	
}
