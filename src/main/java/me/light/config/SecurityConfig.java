package me.light.config;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import ch.qos.logback.core.filter.Filter;

@Configuration
@EnableWebSecurity
@Import(value = {SecurityBean.class})
@ComponentScan("me.light.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	AuthenticationSuccessHandler loginSuccessHandler;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	AuthenticationFailureHandler failureHandler;
	
	@Autowired
	@Qualifier(value = "bcryptPwEncoder")
	PasswordEncoder passwordEncoder;
	
	@Autowired
	PersistentTokenRepository persistentTokenRepository;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("jeon").password("{noop}1234").roles("MEMBER");
//			auth.inMemoryAuthentication()
//			.withUser("admin").password("{noop}1234").roles("MEMBER","ADMIN");
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
				filter.setEncoding("utf-8");
				filter.setForceEncoding(true);
				http.addFilterBefore(filter, CsrfFilter.class);
		
		http.csrf()
			.ignoringAntMatchers("/uploadAjaxAction","/deleteFile",
					"/replies/**");
		http.authorizeRequests()
			.antMatchers("/security/all").permitAll()
			.antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/security/member").access("hasRole('ROLE_MEMBER')")
		.and()
			.formLogin()
			.usernameParameter("loginId")
			.passwordParameter("loginPw")
		    .loginPage("/customLogin")
		    .loginProcessingUrl("/login")
			.successHandler(loginSuccessHandler)
			.failureHandler(failureHandler);
		
		http.rememberMe().key("project")
			.tokenRepository(persistentTokenRepository)
			.tokenValiditySeconds(604800);
		
		http.logout()
			.logoutUrl("/customLogout")
			.invalidateHttpSession(true)
			.deleteCookies("remember-me","JSESSION_ID");
	}
	
}
