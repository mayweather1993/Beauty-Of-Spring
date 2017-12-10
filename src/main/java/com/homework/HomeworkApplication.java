package com.homework;

import com.homework.dao.UserRepository;
import com.homework.models.AppUser;
import com.homework.models.Role;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@AllArgsConstructor
public class HomeworkApplication {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> userRepository.saveAndFlush(
				new AppUser(null, "admin@admin.com", passwordEncoder.encode("1234"), "admin", "admin", Role.ADMIN)
		);
	}

}
