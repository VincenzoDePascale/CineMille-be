package com.VincenzoDePascale.CineMille.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
import com.VincenzoDePascale.CineMille.model.Sala;
import com.VincenzoDePascale.CineMille.payload.FilmDto;
import com.VincenzoDePascale.CineMille.payload.ProgrammazioneDto;
import com.VincenzoDePascale.CineMille.repository.ProgrammazioneRepository;
import com.VincenzoDePascale.CineMille.service.FilmService;
import com.VincenzoDePascale.CineMille.service.ProgrammazioneService;
import com.VincenzoDePascale.CineMille.service.SalaService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 360000, allowCredentials = "true")
@RestController
@RequestMapping("/api/programmazione")
public class ProgrammazioneController {
	
	@Autowired
	ProgrammazioneRepository progRepo;
	
	@Autowired
	ProgrammazioneService progService;
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	SalaService salaService;
	
	//GET
	
		@GetMapping
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<List<Programmazione>> getAll() {	
			return new ResponseEntity<List<Programmazione>>(progService.findAll(), HttpStatus.OK);
		}
		
		@GetMapping("/id/{id}")
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<?> findById(@PathVariable("id") Long id) {
			return new ResponseEntity<>(progService.findById(id), HttpStatus.OK);
		}
		
		@GetMapping("/dateRangeInizio/{startDate}/{endDate}")
		//@PreAuthorize("isAuthenticated()")
		public ResponseEntity<List<Programmazione>> findByInizioDateRange(
		        @PathVariable("startDate") LocalDate startDate,
		        @PathVariable("endDate") LocalDate endDate) {
		    List<Programmazione> programmazioni = progService.getProgrammazioniByInizioDateRange(startDate, endDate);
		    return new ResponseEntity<>(programmazioni, HttpStatus.OK);
		}
		
		@GetMapping("/dateRangeFine/{startDate}/{endDate}")
		//@PreAuthorize("isAuthenticated()")
		public ResponseEntity<List<Programmazione>> findByFineDateRange(
		        @PathVariable("startDate") LocalDate startDate,
		        @PathVariable("endDate") LocalDate endDate) {
		    List<Programmazione> programmazioni = progService.getProgrammazioniByFineDateRange(startDate, endDate);
		    return new ResponseEntity<>(programmazioni, HttpStatus.OK);
		}
		
		@PostMapping("/save")
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<?> saveProgrammaizone(@RequestBody ProgrammazioneDto data) {
			Sala s = salaService.findById(data.getId_sala());
			Film f = filmService.findById(data.getId_film());
		    Programmazione p = new Programmazione(s, f,
		    		data.getDataInizioProgrammazione(),
		    		data.getDataInizioProgrammazione().plusWeeks(3),
		    		data.getOrario()
		    		);
		    return new ResponseEntity<>(progService.saveProgrammazione(p), HttpStatus.CREATED);
		}
		
		@PostMapping("/saveCSV")
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<?> saveProgrammazioneByCSV(@RequestParam("file") MultipartFile data) {
		    try {
		    	progService.uploadCSV(data.getInputStream());
		    	return new ResponseEntity<>("programmazioni caricate correttamente", HttpStatus.OK);
		    } catch (Exception e) {
		    	return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
		    }
		}
		
		//DELETE
		
		@DeleteMapping("/delete/{id}")
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<?> delateFilm(@PathVariable Long id) {
			return new ResponseEntity <String>(progService.removeProgrammazione(id), HttpStatus.CREATED);
		}

}
