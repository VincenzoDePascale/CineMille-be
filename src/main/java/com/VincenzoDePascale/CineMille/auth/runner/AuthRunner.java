package com.VincenzoDePascale.CineMille.auth.runner;

import com.VincenzoDePascale.CineMille.auth.entity.ERole;
import com.VincenzoDePascale.CineMille.auth.entity.Role;
import com.VincenzoDePascale.CineMille.auth.entity.User;
import com.VincenzoDePascale.CineMille.auth.repository.RoleRepository;
import com.VincenzoDePascale.CineMille.auth.repository.UserRepository;
import com.VincenzoDePascale.CineMille.auth.service.AuthService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthRunner implements ApplicationRunner {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthService authService;

	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		System.out.println("AuthRunner run...START");

		System.out.println("AuthRunner run...END");
		
		if(roleRepository.findAll().size() == 0) {
            setRoleDefault();
        }
		
		if(userRepository.findAll().size() == 0) {
			User user = new User();
			user.setUsername("admin");
			user.setEmail("admin@ex.it");
			user.setPassword(passwordEncoder.encode("PW_admin"));
			Role admin = roleRepository.findById(1l).get();			
			user.getRoles().add(admin);
			userRepository.save(user);
		}

	}

	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);

		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);

		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);

		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);

		moderatorRole = new HashSet<Role>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);

		userRole = new HashSet<Role>();
		userRole.add(user);
	}

}
