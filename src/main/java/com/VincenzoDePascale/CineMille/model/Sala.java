package com.VincenzoDePascale.CineMille.model;

import java.util.List;

import com.VincenzoDePascale.CineMille.Lists.TecnologiaSala;
import com.VincenzoDePascale.CineMille.Lists.TipoSala;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sala")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String codiceIdentificativo;
	
	@Column(nullable = false)
	private TipoSala tipoSala;
	
	@Column(nullable = false)
	private TecnologiaSala tecnologiaSala;
	
	@Column(nullable = false)
	private int capienza;

	@OneToMany(mappedBy = "sala")
	@JsonIgnore
	private List<Programmazione> programmazione;
	
	//costruttore senza id e senza programmazione
	
	public Sala(String codiceIdentificativo, TipoSala tipoSala, TecnologiaSala tecnologiaSala, int capienza) {
		super();
		this.codiceIdentificativo = codiceIdentificativo;
		this.tipoSala = tipoSala;
		this.tecnologiaSala = tecnologiaSala;
		this.capienza = capienza;
	}

}
