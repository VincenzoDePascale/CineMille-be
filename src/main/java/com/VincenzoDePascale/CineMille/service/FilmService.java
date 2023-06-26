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

import com.VincenzoDePascale.CineMille.Lists.Genere;
import com.VincenzoDePascale.CineMille.model.Film;
import com.VincenzoDePascale.CineMille.model.Programmazione;
import com.VincenzoDePascale.CineMille.repository.FilmRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepo;

	// SAVE

	public Film saveFilm(Film f) {
		if (filmRepo.existsByTitolo(f.getTitolo()) || filmRepo.existsById(f.getId())) {
			throw new EntityExistsException("film già presente nel database");
		}
		filmRepo.save(f);
		return f;
	}

	// SEARCH

	public List<Film> findAll() {
		return (List<Film>) filmRepo.findAll();
	}

	public Film findById(Long id) {
		if (!filmRepo.existsById(id)) {
			throw new EntityNotFoundException("film con ID" + id + " non trovato");
		}
		return filmRepo.findById(id).get();
	}

	public Film findByTitolo(String titolo) {
		if (!filmRepo.existsByTitolo(titolo)) {
			throw new EntityNotFoundException("film con ID" + titolo + " non trovato");
		}
		return filmRepo.findByTitolo(titolo).get();
	}

	public List<Film> findByAutore(String autore) {
		if (!filmRepo.existsByAutore(autore)) {
			throw new EntityNotFoundException("film con ID" + autore + " non trovato");
		}
		return filmRepo.findByAutore(autore);
	}

	public List<Film> findByDataUscita(LocalDate dataUscita) {
		if (!filmRepo.existsByDataUscita(dataUscita)) {
			throw new EntityNotFoundException("nessun film uscito in questa data: " + dataUscita);
		}
		return filmRepo.findByDataUscita(dataUscita);
	}

	public List<Film> findByGenere(Genere genere) {
		if (!filmRepo.existsByGenere(genere)) {
			throw new EntityNotFoundException("nessun film di questo genere" + genere);
		}
		return filmRepo.findByGenere(genere);
	}
	
	public List<Film> getFilmByDataRange(LocalDate startTime, LocalDate endTime) {
		return filmRepo.findByDataUscitaBetween(startTime, endTime);
	}

	// POST

	public void uploadCSV(InputStream csv) {
		try 
		(BufferedReader fileReader = new BufferedReader(new InputStreamReader(csv, "UTF-8"));

				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.newFormat(';')
						.withFirstRecordAsHeader() //prima riga sono gli header
						.withIgnoreHeaderCase() //ignora prima riga
						.withTrim() //toglie gli i spazi
						.withAllowMissingColumnNames()
						);) {

			List<Film> films = new ArrayList<Film>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Film film = new Film(
						csvRecord.get(0),
						csvRecord.get(1),
						csvRecord.get(2),
						LocalDate.parse(csvRecord.get(3)),
						Genere.getEnumByData(csvRecord.get(4)),
						csvRecord.get(5),
						Integer.parseInt(csvRecord.get(6))
						);

				films.add(film);
			}

			filmRepo.saveAll(films);
		} catch (IOException e) {
			throw new RuntimeException("file csv non è stato caricato correttamente: " + e.getMessage());
		}
	}
	
	// DELETE
	
	public void deleteAll() {
		filmRepo.deleteAll();
	}

	public String removeFilm(Long id) {
		if (!filmRepo.existsById(id)) {
			throw new EntityNotFoundException("film con ID" + id + " non trovata");
		}
		filmRepo.deleteById(id);
		return "Film Eliminato con successo";
	}

}
