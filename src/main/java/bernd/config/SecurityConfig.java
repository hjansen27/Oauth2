package bernd.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation") // For NoOpPasswordEncoder
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off
		//auth.inMemoryAuthentication()
		//	.withUser("habuma").password("password").authorities("ROLE_USER", "ROLE_ADMIN")
		//	.and()
		//	.withUser("izzy").password("password").authorities("ROLE_USER");
		auth.jdbcAuthentication()
        .passwordEncoder(new BCryptPasswordEncoder())
        .dataSource(dataSource);
		
//	    auth.jdbcAuthentication()
//	      .dataSource(dataSource)
//	      .withDefaultSchema()
//	      .withUser(User.withUsername("user")
//	        .password(passwordEncoder().encode("pass"))
//	        .roles("USER"));
		//@formatter:on
	}
	
	// Using NoOpPasswordEncoder for simplicity's sake
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}

}
