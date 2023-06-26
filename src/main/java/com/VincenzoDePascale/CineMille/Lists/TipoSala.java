package com.VincenzoDePascale.CineMille.Lists;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoSala {
	
	CHIUSO("sala al chiuso"),
	APERTO("sala all'aperto"),
	TEATRO("sala in teatro");
	
	private String luogo;
	
	private TipoSala(String luogo) {
		this.luogo = luogo; 
	}
	
	@JsonValue
    public Map<String, Object> createTecnologiaSala() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("luogo", luogo);
        return result;
    }
	
	public static TipoSala getEnumByData(String data) {
        for (TipoSala ts : TipoSala.values()) {
            if (ts.getLuogo().equalsIgnoreCase(data)) {
                return ts;
            }
        }
        throw new IllegalArgumentException("Nessun genere trovato con questo nome: " + data);
    }
	
	public String getLuogo() {
		return luogo;
	}

}
