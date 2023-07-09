package com.VincenzoDePascale.CineMille.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VincenzoDePascale.CineMille.model.Film;
import com.VincenzoDePascale.CineMille.model.Programmazione;
import com.VincenzoDePascale.CineMille.model.Sala;
import com.VincenzoDePascale.CineMille.repository.FilmRepository;
import com.VincenzoDePascale.CineMille.repository.ProgrammazioneRepository;
import com.VincenzoDePascale.CineMille.repository.SalaRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProgrammazioneService {
	
	@Autowired
	private ProgrammazioneRepository progRepo;
	
	@Autowired
	private FilmRepository filmRepo;
	
	@Autowired
	private SalaRepository salaRepo;
	
	// SAVE
	
	public Programmazione saveProgrammazione(Programmazione programmazione) {
		if (progRepo.existsById(programmazione.getId())) {
			throw new EntityExistsException("Programmazione già presente nel database");
		}
		return progRepo.save(programmazione);
	}
	
	// SEARCH
	
	public List<Programmazione> findAll() {
		return (List<Programmazione>) progRepo.findAll();
	}
	
	public Programmazione findById(Long id) {
		if (!progRepo.existsById(id)) {
			throw new EntityNotFoundException("programmazione con ID" + id + " non trovata");
		}
		return progRepo.findById(id).get();
	}
	
	// Recupero delle programmazioni di una sala specifica
	public List<Programmazione> getProgrammazioniBySala(Sala sala) {
		return progRepo.findBySala(sala);
	}
	
	// Recupero delle programmazioni di un film specifico
	public List<Programmazione> getProgrammazioniByFilm(Film film) {
		return progRepo.findByFilm(film);
	}
	
	// Recupero delle programmazioni in base a un intervallo di date
	public List<Programmazione> getProgrammazioniByInizioDateRange(LocalDate startDate, LocalDate endDate) {
		return progRepo.findByDataInizioProgrammazioneBetween(startDate, endDate);
	}
	
	// Recupero delle programmazioni in base a un intervallo di date
	public List<Programmazione> getProgrammazioniByFineDateRange(LocalDate startDate, LocalDate endDate) {
		return progRepo.findByDataFineProgrammazioneBetween(startDate, endDate);
	}
	
	// Recupero delle programmazioni in base a un intervallo di orari
	public List<Programmazione> getProgrammazioniByTimeRange(LocalTime startTime, LocalTime endTime) {
		return progRepo.findByOrarioBetween(startTime, endTime);
	}
	
	//POST
	
	public void uploadCSV(InputStream csv) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(csv, "UTF-8"));
				
			 CSVParser csvParser = new CSVParser(fileReader, CSVFormat.newFormat(';')
				.withFirstRecordAsHeader()
				.withIgnoreHeaderCase()
				.withTrim()
				.withAllowMissingColumnNames());) {

			List<Programmazione> programmazioni = new ArrayList<>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Sala sala = salaRepo.findById(Long.parseLong(csvRecord.get(0)))
					.orElseThrow(() -> new IllegalArgumentException("Sala non trovata: " + csvRecord.get(0)));
				Film film = filmRepo.findById(Long.parseLong(csvRecord.get(1)))
					.orElseThrow(() -> new IllegalArgumentException("Film non trovato: " + csvRecord.get(1)));
				LocalDate dataInizioProgrammazione = LocalDate.parse(csvRecord.get(2));
				LocalDate dataFineProgrammazione = dataInizioProgrammazione.plusWeeks(Long.parseLong(csvRecord.get(3)));
				LocalTime orario = LocalTime.parse(csvRecord.get(4));

				Programmazione programmazione = new Programmazione(
					sala,
					film,
					dataInizioProgrammazione,
					dataFineProgrammazione,
					orario);
				programmazioni.add(programmazione);
			}

			progRepo.saveAll(programmazioni);
		} catch (IOException e) {
			throw new RuntimeException("Il file CSV non è stato caricato correttamente: " + e.getMessage());
		}
	}

	
	// REMOVE
	
		public String removeProgrammazione(Long id) {
			if (!progRepo.existsById(id)) {
				throw new EntityNotFoundException("Programmazione non trovata");
			}
			progRepo.deleteById(id);
			return "Programmazione Eliminata con successo";
		}
		
}
