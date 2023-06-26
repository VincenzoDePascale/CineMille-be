package com.VincenzoDePascale.CineMille.payload;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammazioneDto {
	
	private Long id_sala;
	private Long id_film;
	private LocalDate dataInizioProgrammazione;
	private int settimane;
	private LocalTime orario;
	
}
