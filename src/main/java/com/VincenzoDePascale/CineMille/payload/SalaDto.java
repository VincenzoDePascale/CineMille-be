package com.VincenzoDePascale.CineMille.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SalaDto {
	
	private String codiceIdentificativo;
	private String tipoSala;
	private String tecnologiaSala;
	private int capienza;

}
