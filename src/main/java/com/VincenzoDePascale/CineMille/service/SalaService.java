package com.VincenzoDePascale.CineMille.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VincenzoDePascale.CineMille.Lists.Genere;
import com.VincenzoDePascale.CineMille.Lists.TecnologiaSala;
import com.VincenzoDePascale.CineMille.Lists.TipoSala;
import com.VincenzoDePascale.CineMille.model.Film;
import com.VincenzoDePascale.CineMille.model.Sala;
import com.VincenzoDePascale.CineMille.repository.SalaRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepo;
	
	//SAVE
	
	public Sala saveSala(Sala s) {
		if(salaRepo.existsByCodiceIdentificativo(s.getCodiceIdentificativo()) ||
				salaRepo.existsById(s.getId())) {
			throw new EntityExistsException("codice identificativo o id già presenti \n modificare i parametri e riprovare");
		}
		salaRepo.save(s);
		return s;
	}
	
	//SEARCH
	
	public List<Sala> findAll() {
		return (List<Sala>) salaRepo.findAll();
	}
	
	public Sala findById(Long id) {
		if (!salaRepo.existsById(id)) {
			throw new EntityNotFoundException("sala con ID" + id + " non trovata" );
		}
		return salaRepo.findById(id).get();
	}
	
	public List<Sala> findByTipoSala(TipoSala tipoSala) {
		return (List<Sala>) salaRepo.findByTipoSala(tipoSala);
	}
	
	public List<Sala> findByTecnologiaSala(TecnologiaSala tecnologiaSala) {
		return (List<Sala>) salaRepo.findByTecnologiaSala(tecnologiaSala);
	}
	
	public List<Sala> findByCapienza(int capienza) {
		return (List<Sala>) salaRepo.findByCapienza(capienza);
	}
	
	//POST
	
	public void uploadCSV(InputStream csv) {
		try 
		(BufferedReader fileReader = new BufferedReader(new InputStreamReader(csv, "UTF-8"));

				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.newFormat(';')
						.withFirstRecordAsHeader() //prima riga sono gli header
						.withIgnoreHeaderCase() //ignora prima riga
						.withTrim() //toglie gli i spazi
						.withAllowMissingColumnNames()
						);) {

			List<Sala> sale = new ArrayList<Sala>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Sala sala = new Sala(
						csvRecord.get(0),
						TipoSala.getEnumByData(csvRecord.get(1)),
						TecnologiaSala.getEnumByData(csvRecord.get(2)),
						Integer.parseInt(csvRecord.get(3))
						);

				sale.add(sala);
			}

			salaRepo.saveAll(sale);
		} catch (IOException e) {
			throw new RuntimeException("file csv non è stato caricato correttamente: " + e.getMessage());
		}
	}
	
	//DELETE
	
	public void deleteAll() {
		salaRepo.deleteAll();
	}
	
	public String removeSala(Long id) {
		if(!salaRepo.existsById(id)) {
			throw new EntityNotFoundException("sala con ID" + id + " non trovata" );
		}
		salaRepo.deleteById(id);
		return "Sala Eliminata con successo";
	}

}
