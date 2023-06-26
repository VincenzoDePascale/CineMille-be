package com.VincenzoDePascale.CineMille.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.VincenzoDePascale.CineMille.auth.entity.User;

@Configuration
@PropertySource("classpath:application.properties")
public class UserConfiguration {
	
	@Bean
	@Scope("prototype")
	public User UserStandard(String email, String username, String password) {
		return User.builder()
				.email(email)
				.username(username)
				.password(password)
				.build();
	}

}
