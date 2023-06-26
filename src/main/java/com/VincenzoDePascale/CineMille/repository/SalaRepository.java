package com.VincenzoDePascale.CineMille.repository;

import org.springframework.stereotype.Repository;

import com.VincenzoDePascale.CineMille.Lists.TecnologiaSala;
import com.VincenzoDePascale.CineMille.Lists.TipoSala;
import com.VincenzoDePascale.CineMille.model.Sala;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long>{

	boolean existsById(Long Id);
	
	Optional<Sala> findByCodiceIdentificativo(String codiceIdentificativo);
	boolean existsByCodiceIdentificativo(String codiceIdentificativo);
	
	List<Sala> findByTipoSala(TipoSala tipoSala);
	boolean existsByTipoSala(TipoSala tipoSala);
	
	List<Sala> findByTecnologiaSala(TecnologiaSala tecnologiaSala);
	boolean existsByTecnologiaSala(TecnologiaSala tecnologiaSala);
	
	List<Sala> findByCapienza(int capienza);
	boolean existsByCapienza(int capienza);
}
