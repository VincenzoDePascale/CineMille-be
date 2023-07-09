package com.VincenzoDePascale.CineMille.Controller;

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

import com.VincenzoDePascale.CineMille.repository.SalaRepository;
import com.VincenzoDePascale.CineMille.service.SalaService;
import com.VincenzoDePascale.CineMille.Lists.Genere;
import com.VincenzoDePascale.CineMille.Lists.TecnologiaSala;
import com.VincenzoDePascale.CineMille.Lists.TipoSala;
import com.VincenzoDePascale.CineMille.model.Film;
import com.VincenzoDePascale.CineMille.model.Sala;
import com.VincenzoDePascale.CineMille.payload.FilmDto;
import com.VincenzoDePascale.CineMille.payload.SalaDto;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 360000, allowCredentials = "true")
@RestController
@RequestMapping("/api/sala")
public class SalaController {
	
	@Autowired
	SalaRepository salaRepo;
	
	@Autowired
	SalaService salaService;
	
	//GET
	
	@GetMapping
	//@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Sala>> getAll() {	
		return new ResponseEntity<List<Sala>>(salaService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(salaService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/tipoSala/{tipoSala}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByTipoSala(@PathVariable("tipoSala") String ts) {
		TipoSala data = TipoSala.getEnumByData(ts);
		return new ResponseEntity<>(salaService.findByTipoSala(data), HttpStatus.OK);
	}
	
	@GetMapping("/tecnologiaSala/{tecnologiaSala}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByTecnologiaSala(@PathVariable("tecnologiaSala") String ts) {
		TecnologiaSala data = TecnologiaSala.getEnumByData(ts);
		return new ResponseEntity<>(salaService.findByTecnologiaSala(data), HttpStatus.OK);
	}
	
	@GetMapping("/capienza/{capienza}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByCapienza(@PathVariable("capienza") int capienza) {
		return new ResponseEntity<>(salaService.findByCapienza(capienza), HttpStatus.OK);
	}
	
	//POST
	
	@PostMapping("/save")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> saveSale(@RequestBody SalaDto data) {
	    Sala s = new Sala(
	    		data.getCodiceIdentificativo(),
	    		TipoSala.getEnumByData(data.getTipoSala()),
	    		TecnologiaSala.getEnumByData(data.getTecnologiaSala()),
	            data.getCapienza());
	    return new ResponseEntity<>(salaService.saveSala(s), HttpStatus.CREATED);
	}
	
	@PostMapping("/saveCSV")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> saveSalaByCSV(@RequestParam("file") MultipartFile data) {
	    try {
	    	//salaService.deleteAll();
	    	salaService.uploadCSV(data.getInputStream());
	    	return new ResponseEntity<>("sale caricate", HttpStatus.OK);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
	    }
	    
	}
	
	//DELETE
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> delateSala(@PathVariable Long id) {
		return new ResponseEntity <String>(salaService.removeSala(id), HttpStatus.CREATED);
	}

}
