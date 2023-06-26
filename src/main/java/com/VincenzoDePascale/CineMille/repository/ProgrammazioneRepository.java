package com.VincenzoDePascale.CineMille.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.VincenzoDePascale.CineMille.model.Film;
import com.VincenzoDePascale.CineMille.model.Programmazione;
import com.VincenzoDePascale.CineMille.model.Sala;

@Repository
public interface ProgrammazioneRepository extends CrudRepository<Programmazione, Long> {

	boolean existsById(Long Id);
	
	List<Programmazione> findByDataInizioProgrammazione(LocalDate dataInizioProgrammazione);
	boolean existsByDataInizioProgrammazione(LocalDate dataInizioProgrammazione);
	
	List<Programmazione> findByDataFineProgrammazione(LocalDate dataFineProgrammazione);
	boolean existsByDataFineProgrammazione(LocalDate dataFineProgrammazione);
	
	List<Programmazione> findBySala(Sala sala);
	
	List<Programmazione> findByFilm(Film film);
	
	List<Programmazione> findByDataInizioProgrammazioneBetween(LocalDate startDate, LocalDate endDate);
	
	List<Programmazione> findByDataFineProgrammazioneBetween(LocalDate startDate, LocalDate endDate);

	List<Programmazione> findByOrarioBetween(LocalTime startTime, LocalTime endTime);

}
