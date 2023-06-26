package com.VincenzoDePascale.CineMille;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.VincenzoDePascale.CineMille.auth.controller.AuthController;
import com.VincenzoDePascale.CineMille.auth.entity.User;

@SpringBootApplication
public class CineMilleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineMilleApplication.class, args);
		System.out.println("CineMilleApplication run...START");
				
		System.out.println("CineMilleApplication run...END");
	}

}
