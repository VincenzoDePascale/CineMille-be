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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VincenzoDePascale.CineMille.auth.entity.User;
import com.VincenzoDePascale.CineMille.service.UserService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 360000, allowCredentials = "true")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//GET
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<User>>(userService.findAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByPartEmail(@PathVariable("email") String email) {
		return new ResponseEntity<>(userService.findByPartEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByPartUsername(@PathVariable("username") String username) {
		return new ResponseEntity<>(userService.findByPartUsername(username), HttpStatus.OK);
	}
	
	//DELETE
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> delateUser(@PathVariable Long id) {
		return new ResponseEntity <String>(userService.removeUser(id), HttpStatus.CREATED);
	}
	

}
