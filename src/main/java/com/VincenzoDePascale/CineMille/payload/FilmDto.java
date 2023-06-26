package com.VincenzoDePascale.CineMille.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
	
	private String titolo;
	private String autore;
	private String descrizione;
	private LocalDate dataUscita;
	private String genere;
	private String immagine;
	private int minuti;


}
