/**
 * SecurityConfig.java
 */
package group14.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import group14.app.service.MyUserDetailsService;

/**
 * @author Alex Daniel Popa
 * 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	/**
	 * Set up the users access within the app
	 * @param http
	 * @throws Exception 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	.antMatchers("/", "/home").permitAll()
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.and().formLogin()
		.and().exceptionHandling().accessDeniedPage("/access_denied");
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/resources/**");
    }
	
	/**
	 * Autowires the BCryptPasswordEncoder to be used in java classes
	 * @return 
	 */
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	/**
	 * Transform the plaintext password to a ciphertext to compare with the database
	 * @param builder
	 * @throws Exception 
	 */
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); // with encryption
	}
}
