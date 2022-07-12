package me.light.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import me.light.security.CustomLoginSuccessHandler;
import me.light.security.CustomNoopPasswordEncoder;
import me.light.security.CustomUserDetailService;
import me.light.security.LoginFailureHandler;

@Configuration
public class SecurityBean {
	
	@Autowired
	DataSource dataSource;

	//<bean id="BCryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"></bean>
	//<bean id="CustomUserDetailService" class="me.light.security.CustomUserDetailService" />
//	@Bean
//	public AuthenticationSuccessHandler loginSuccessHandler() {
//		return new CustomLoginSuccessHandler();
//	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new CustomUserDetailService();
//	}
//	
	@Bean
	public PasswordEncoder bcryptPwEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PasswordEncoder nooPencoder() {
		return new CustomNoopPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	
//	@Bean
//	public AuthenticationFailureHandler failureHandler() {
//		LoginFailureHandler lf = new LoginFailureHandler();
//		lf.setLoginId("loginId");
//		lf.setLoginPw("loginPw");
//		lf.setErrorMessage("errorMessage");
//		lf.setDefaultFailureUrl("/customLogin");
//		return lf;
}
