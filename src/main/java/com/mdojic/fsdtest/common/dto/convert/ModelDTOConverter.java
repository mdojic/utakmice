package com.mdojic.fsdtest.common.dto.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mdojic.fsdtest.common.dto.IgracDTO;
import com.mdojic.fsdtest.common.dto.KlubDTO;
import com.mdojic.fsdtest.common.dto.MestoDTO;
import com.mdojic.fsdtest.common.dto.NastupIgracaNaUtakmiciDTO;
import com.mdojic.fsdtest.common.dto.TakmicenjeDTO;
import com.mdojic.fsdtest.common.dto.UtakmicaDTO;
import com.mdojic.fsdtest.repository.IgracRepository;
import com.mdojic.fsdtest.repository.KlubRepository;
import com.mdojic.fsdtest.repository.MestoRepository;
import com.mdojic.fsdtest.repository.TakmicenjeRepository;
import com.mdojic.fsdtest.repository.UtakmicaRepository;
import com.mdojic.fsdtest.repository.entity.Igrac;
import com.mdojic.fsdtest.repository.entity.Klub;
import com.mdojic.fsdtest.repository.entity.Mesto;
import com.mdojic.fsdtest.repository.entity.NastupIgracaNaUtakmici;
import com.mdojic.fsdtest.repository.entity.Takmicenje;
import com.mdojic.fsdtest.repository.entity.Utakmica;

@Component
public class ModelDTOConverter {
	
	private final MestoRepository mestoRepository;
	private final KlubRepository klubRepository;
	private final TakmicenjeRepository takmicenjeRepository;
	private final IgracRepository igracRepository;
	private final UtakmicaRepository utakmicaRepository;
	
	@Autowired
	public ModelDTOConverter(MestoRepository mestoRepository, KlubRepository klubRepository, 
			TakmicenjeRepository takmicenjeRepository, IgracRepository igracRepository,
			UtakmicaRepository utakmicaRepository) {
		this.mestoRepository = mestoRepository;
		this.klubRepository = klubRepository;
		this.takmicenjeRepository = takmicenjeRepository;
		this.igracRepository = igracRepository;
		this.utakmicaRepository = utakmicaRepository;
	}

	public IgracDTO convert(Igrac igrac) {
		if (igrac == null) {
			return null;
		}
		return IgracDTO.builder()
				.datumRodjenja(igrac.getDatumRodjenja())
				.id(igrac.getId())
				.ime(igrac.getIme())
				.username(igrac.getUsername())
				.prezime(igrac.getPrezime())
				.jmbg(igrac.getJmbg())
				.pozicija(igrac.getPozicija())
				.klubId(igrac.getKlub().getId())
				.nazivKluba(igrac.getKlub().getNaziv())
				.mestoId(igrac.getMesto().getId())
				.nazivMesta(igrac.getMesto().getNaziv())
				.build();
	}
	
	public KlubDTO convert(Klub klub) {
		if (klub == null) {
			return null;
		}
		return KlubDTO.builder()
				.id(klub.getId())
				.naziv(klub.getNaziv())
				.mestoId(klub.getMesto().getId())
				.nazivMesta(klub.getMesto().getNaziv())
				.build();
	}
	
	public MestoDTO convert(Mesto mesto) {
		if (mesto == null) {
			return null;
		}
		return MestoDTO.builder()
				.id(mesto.getId())
				.naziv(mesto.getNaziv())
				.ptt(mesto.getPtt())
				.build();
	}
	
	public UtakmicaDTO convert(Utakmica utakmica) {
		if (utakmica == null) {
			return null;
		}
		return UtakmicaDTO.builder()
				.id(utakmica.getId())
				.datumOdigravanja(utakmica.getDatumOdigravanja())
				.klubDomacinId(utakmica.getDomacin().getId())
				.nazivKlubaDomacina(utakmica.getDomacin().getNaziv())
				.klubGostId(utakmica.getGost().getId())
				.nazivKlubaGosta(utakmica.getGost().getNaziv())
				.takmicenjeId(utakmica.getTakmicenje().getId())
				.nazivTakmicenja(utakmica.getTakmicenje().getNaziv())
				.build();
	}
	
	public TakmicenjeDTO convert(Takmicenje takmicenje) {
		return TakmicenjeDTO.builder()
				.id(takmicenje.getId()).naziv(takmicenje.getNaziv()).build();
	}
	
	public NastupIgracaNaUtakmiciDTO convert(NastupIgracaNaUtakmici nastup) {
		return NastupIgracaNaUtakmiciDTO.builder()
				.id(nastup.getId())
				.igracId(nastup.getIgrac().getId())
				.utakmicaId(nastup.getUtakmica().getId())
				.ocenaIgraca(nastup.getOcenaIgraca())
				.build();
	}
	
	public Igrac convert(IgracDTO igracDTO) {
		return Igrac.builder()
			.id(igracDTO.getId())
			.datumRodjenja(igracDTO.getDatumRodjenja())
			.ime(igracDTO.getIme()).jmbg(igracDTO.getJmbg())
			.pozicija(igracDTO.getPozicija()).prezime(igracDTO.getPrezime())
			.username(igracDTO.getUsername())
			.klub(klubRepository.findById(igracDTO.getKlubId()).get())
			.mesto(mestoRepository.findById(igracDTO.getMestoId()).get())
			.build();
	}
	
	public Klub convert(KlubDTO klubDTO) {
		return Klub.builder()
				.id(klubDTO.getId()).naziv(klubDTO.getNaziv())
				.mesto(mestoRepository.findById(klubDTO.getMestoId()).get())
				.build();
	}
	
	public Mesto convert(MestoDTO mestoDTO) {
		return Mesto.builder()
				.id(mestoDTO.getId()).naziv(mestoDTO.getNaziv())
				.ptt(mestoDTO.getPtt()).build();
	}
	
	public Utakmica convert(UtakmicaDTO utakmicaDTO) {
		return Utakmica.builder()
				.id(utakmicaDTO.getId())
				.datumOdigravanja(utakmicaDTO.getDatumOdigravanja())
				.takmicenje(takmicenjeRepository.findById(utakmicaDTO.getTakmicenjeId()).get())
				.domacin(klubRepository.findById(utakmicaDTO.getKlubDomacinId()).get())
				.gost(klubRepository.findById(utakmicaDTO.getKlubGostId()).get())
				.build();
	}
	
	public NastupIgracaNaUtakmici convert(NastupIgracaNaUtakmiciDTO nastupDTO) {
		return NastupIgracaNaUtakmici.builder()
				.id(nastupDTO.getId())
				.igrac(igracRepository.findById(nastupDTO.getIgracId()).get())
				.ocenaIgraca(nastupDTO.getOcenaIgraca())
				.utakmica(utakmicaRepository.findById(nastupDTO.getUtakmicaId()).get())
				.build();
	}
	
	public Takmicenje convert(TakmicenjeDTO takmicenjeDTO) {
		return Takmicenje.builder()
				.id(takmicenjeDTO.getId()).naziv(takmicenjeDTO.getNaziv()).build();
	}
}
