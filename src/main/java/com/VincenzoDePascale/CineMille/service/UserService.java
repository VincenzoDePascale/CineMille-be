package com.VincenzoDePascale.CineMille.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.VincenzoDePascale.CineMille.auth.entity.User;
import com.VincenzoDePascale.CineMille.auth.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// SAVE

	public User saveUser(User u) {
		if (userRepo.existsByEmail(u.getEmail()) || userRepo.existsByUsername(u.getUsername())) {
			throw new EntityExistsException("email o username già presente");
		}
		userRepo.save(u);
		return u;
	}

	// SEARCH standard

	public List<User> findAllUser() {
		return (List<User>) userRepo.findAll();
	}

	public Page<User> findAllUserPageable(Pageable pageable) {
		return (Page<User>) userRepo.findAll(pageable);
	}

	public User findById(Long id) {
		if (!userRepo.existsById(id)) {
			throw new EntityNotFoundException("Utente con ID non trovato: " + id);
		}
		return userRepo.findById(id).get();
	}

	// ricerca per parte dell'email
	public List<User> findByPartEmail(String email) {
		return (List<User>) userRepo.searchByPartEmail(email);
	}

	// ricerca per parte del nome
	public List<User> findByPartUsername(String username) {
		return (List<User>) userRepo.searchByPartUsername(username);
	}// UPDATE

	public User updateUser(User giocatore) {
		if (!userRepo.existsById(giocatore.getId())) {
			throw new EntityNotFoundException("Utente con ID non trovato: " + giocatore.getId());
		}
		userRepo.save(giocatore);
		return giocatore;
	}

	// DELETE

	public String removeUser(Long id) {
		if (!userRepo.existsById(id)) {
			throw new EntityNotFoundException("Utente con ID non trovato: " + id);
		}
		userRepo.deleteById(id);
		return "Utente eliminato";
	}

}
