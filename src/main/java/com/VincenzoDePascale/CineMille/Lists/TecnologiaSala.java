package com.VincenzoDePascale.CineMille.Lists;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TecnologiaSala {
	
	IMAX("imax", "Nella sala IMAX è possibile provare l'esperienza cinematografica più immersiva che esista grazie alla combinazione di immagini dotate di una risoluzione e una nitidezza senza precedenti, a un impianto surround digitale ad allineamento laser e alla conformazione speciale della sala, progettata per abbracciare tutto il campo visivo dello spettatore e dotata di uno schermo più grande e curvo rispetto a quelli delle normali sale cinematografiche."),
	ISENSE("isense", "Il grande schermo, il suono perfetto, le poltrone ultra comode. I film in sala iSense sono stupefacenti. L'ambiente perfetto per stupire ad un appuntamento, aggiungere un tocco di magia a un compleanno o ad una spettacolare uscita tra amici."),
	TRIDIMENSIONALE("3D", "Tutta la potenza del cinema in tre dimensioni. Vi sembrerà di toccare i vostri eroi.");
	
	private String tipo;
	private String descrizione;
	
	private TecnologiaSala(String tipo, String descrizione) {
		this.tipo = tipo;
		this.descrizione = descrizione;
	}
	
	@JsonValue
    public Map<String, Object> createTecnologiaSala() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("tipo", tipo);
        result.put("descrizione", descrizione);
        return result;
    }
	
	public static TecnologiaSala getEnumByData(String data) {
        for (TecnologiaSala ts : TecnologiaSala.values()) {
            if (ts.getTipo().equalsIgnoreCase(data)) {
                return ts;
            }
        }
        throw new IllegalArgumentException("Nessun genere trovato con questo nome: " + data);
    }
	
	private String getTipo() {
		return tipo;
	}
	
	private String getDescrizione() {
		return descrizione;
	}

}
