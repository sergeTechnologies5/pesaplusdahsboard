package com.lanstar.pesaplusdashboard;

import com.lanstar.pesaplusdashboard.model.Role;
import com.lanstar.pesaplusdashboard.model.Users;
import com.lanstar.pesaplusdashboard.repository.RoleRepository;
import com.lanstar.pesaplusdashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}


	@Resource(name = "userService")
	private UserDetailsService userDetailsService;

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Bean
	CommandLineRunner init(){

		List<Role> roles = roleRepository.findAll();
		List<String> roless = new ArrayList<>();
		roless.add("LANSTAR_ADMIN");
		roless.add("LANSTAR_USER");
		roless.add("SUPER_ADMIN");
		roless.add("USER");
		roless.add("SACCO_ADMIN");
		roless.add("SACCO_USER");

		return args ->{
			if (roles.size()<=0){
				for (String role: roless) {
					roles.add(new Role(role));
				}
				roleRepository.save(roles);
			}else {

				try {
					UserDetails userDetails = userDetailsService.loadUserByUsername("njeru");
				}catch (UsernameNotFoundException EX){
					//Create BCryptPassword encoder
					PasswordEncoder encoder = new BCryptPasswordEncoder();
					Role role = roleRepository.findOne(2L);
					Users users = new Users();
					users.setPassword(encoder.encode("1234"));
					users.setUsername("njeru");
					users.setRoles(Collections.singletonList(role));
					userRepository.save(users);
				}


			}


		};
	}
}
