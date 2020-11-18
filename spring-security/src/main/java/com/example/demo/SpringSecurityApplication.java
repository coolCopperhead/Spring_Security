package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication(scanBasePackages={"com.example.demo","com.example.demo"})
@EnableJpaRepositories(basePackages = {"com.example.demo"})
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@GetMapping("/")
	public String homePage() {
		return "Home.jsp";
	}
	
	@GetMapping("/login")
	public String openLogin() {
		return "login.jsp";
	}
	
	@GetMapping("/logout")
	public String openLogOut() {
		return "logout.jsp";
	}
	
}
