package com.VincenzoDePascale.CineMille.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "programmazione")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Programmazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_sala")
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(name = "id_film")
	private Film film;
	
	@Column(nullable = false)
	private LocalDate dataInizioProgrammazione;

	@Column
	private LocalDate dataFineProgrammazione;
	
	@Column
	private LocalTime orario;
	
	//costruttore senza id
	
	public Programmazione(Sala sala, Film film, LocalDate dataInizioProgrammazione, LocalDate dataFineProgrammazione,
			LocalTime orario) {
		super();
		this.sala = sala;
		this.film = film;
		this.dataInizioProgrammazione = dataInizioProgrammazione;
		this.dataFineProgrammazione = dataFineProgrammazione;
		this.orario = orario;
	}

}
