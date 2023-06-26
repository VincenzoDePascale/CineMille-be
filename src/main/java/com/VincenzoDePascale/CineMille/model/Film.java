package com.VincenzoDePascale.CineMille.model;

import java.time.LocalDate;
import java.util.List;

import com.VincenzoDePascale.CineMille.Lists.Genere;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String titolo;
	
	@Column(nullable = false)
	private String autore;
	
	@Column
	private String descrizione;
	
	@Column(nullable = false)
	private LocalDate dataUscita;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Genere genere;
	
	@Column(length = 512)
	//@Lob
	private String immagine;
	
	@Column(nullable = false)
	private int minuti;

	@OneToMany(mappedBy = "film")
	@JsonIgnore
	private List<Programmazione> programmazione;
	
	//costruttore senza id e senza programmazione

	public Film(String titolo, String autore, String descrizione, LocalDate dataUscita, Genere genere, String immagine,
			int minuti) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.descrizione = descrizione;
		this.dataUscita = dataUscita;
		this.genere = genere;
		this.immagine = immagine;
		this.minuti = minuti;
	}

}
