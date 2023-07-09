package com.VincenzoDePascale.CineMille.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.VincenzoDePascale.CineMille.Lists.Genere;
import com.VincenzoDePascale.CineMille.model.Film;
import com.VincenzoDePascale.CineMille.model.Programmazione;
import com.VincenzoDePascale.CineMille.payload.FilmDto;
import com.VincenzoDePascale.CineMille.repository.FilmRepository;
import com.VincenzoDePascale.CineMille.service.FilmService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 360000, allowCredentials = "true")
@RestController
@RequestMapping("/api/film")
public class FilmController {
	
	@Autowired
	FilmRepository filmRepo;
	
	@Autowired
	FilmService filmService;
	
	//GET
	
	@GetMapping
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Film>> getAll() {	
		return new ResponseEntity<List<Film>>(filmService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(filmService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/titolo/{titolo}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByTitolo(@PathVariable("titolo") String titolo) {
		return new ResponseEntity<>(filmService.findByTitolo(titolo), HttpStatus.OK);
	}
	
	@GetMapping("/autore/{autore}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByAutore(@PathVariable("autore") String autore) {
		return new ResponseEntity<>(filmService.findByAutore(autore), HttpStatus.OK);
	}
	
	@GetMapping("/dataUscita/{dataUscita}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByDataUscita(@PathVariable("dataUscita") LocalDate dataUscita) {
		return new ResponseEntity<>(filmService.findByDataUscita(dataUscita), HttpStatus.OK);
	}
	
	@GetMapping("/genere/{genere}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByGenere(@PathVariable("genere") String genere) {
		Genere g = Genere.getEnumByData(genere);
		return new ResponseEntity<>(filmService.findByGenere(g), HttpStatus.OK);
	}
	
	@GetMapping("/dateRange/{startDate}/{endDate}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Film>> findByDateRange(
	        @PathVariable("startDate") LocalDate startDate,
	        @PathVariable("endDate") LocalDate endDate) {
	    List<Film> programmazioni = filmService.getFilmByDataRange(startDate, endDate);
	    return new ResponseEntity<>(programmazioni, HttpStatus.OK);
	}
	
	//POST
	
	@PostMapping("/save")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> saveFilm(@RequestBody FilmDto data) {
	    Film f = new Film(data.getTitolo(), data.getAutore(), data.getDescrizione(),
	            data.getDataUscita(), Genere.getEnumByData(data.getGenere()), data.getImmagine(),
	            data.getMinuti());
	    return new ResponseEntity<>(filmService.saveFilm(f), HttpStatus.CREATED);
	}
	
	@PostMapping("/saveCSV")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> saveFilmByCSV(@RequestParam("file") MultipartFile data) {
	    try {
	    	//filmService.deleteAll(); -> decommentando questa riga all'upload del csv verranno cancellati tutti i film presenti in DB e poi caricati i nuovi
	    	filmService.uploadCSV(data.getInputStream());
	    	return new ResponseEntity<>("film caricati correttamente", HttpStatus.OK);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
	    }
	    
	}
	
	//DELETE
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> delateFilm(@PathVariable Long id) {
		return new ResponseEntity <String>(filmService.removeFilm(id), HttpStatus.CREATED);
	}

}
