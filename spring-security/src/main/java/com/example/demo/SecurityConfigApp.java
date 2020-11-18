package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfigApp extends WebSecurityConfigurerAdapter{
	
	// For Hard Coding userName/Password
	
	/*
	 * @Bean protected UserDetailsService userdetailService() {
	 * 
	 * List<UserDetails> listUserDetails = new ArrayList<>();
	 * listUserDetails.add(User.withDefaultPasswordEncoder().username("APS").
	 * password("system").roles("Admin").build()); return new
	 * InMemoryUserDetailsManager(listUserDetails); }
	 */
	
	//Fetching from database
	
	@Autowired
	private UserDetailsService userDetailService;
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService);
		authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return authProvider;
		/*
		 * Bcrypt password came into existence as attacker
		 * able to hack SHA 256 and SHA 512
		 * 
		 * based on Hashing so size is fix
		 * 
		 */
		//authProvider.setPasswordEncoder(new BCryptPasswordEncoder());//Plane text password will not work
		
		
	}

	
	/*
	 * Segment using for custome Login
	 * 
	 * 
	 */
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-success").permitAll();
		
	}
	
	
	

}
