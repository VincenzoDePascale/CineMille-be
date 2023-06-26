package com.VincenzoDePascale.CineMille.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.VincenzoDePascale.CineMille.Lists.Genere;
import com.VincenzoDePascale.CineMille.model.Film;

@Repository
public interface FilmRepository  extends CrudRepository<Film, Long>{
	
	boolean existsById(Long Id);
	
	Optional<Film> findByTitolo(String titolo);
	boolean existsByTitolo(String titolo);
	
	List<Film> findByAutore(String autore);
	boolean existsByAutore(String autore);
	
	Optional<Film> findByDescrizione(String descrizione);
	boolean existsByDescrizione(String descrizione);
	
	List<Film> findByDataUscita(LocalDate dataUscita);
	boolean existsByDataUscita(LocalDate dataUscita);
	
	List<Film> findByGenere(Genere genere);
	boolean existsByGenere(Genere genere);
	
	Optional<Film> findByImmagine(String immagine);
	boolean existsByImmagine(String immagine);
	
	List<Film> findByDataUscitaBetween(LocalDate dataUscita, LocalDate endDate);

}
