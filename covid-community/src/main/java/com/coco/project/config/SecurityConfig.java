package com.coco.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthenticationFailureHandler loginFailureHandler;
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/scss/**", "/vendor/**", "/files/**");
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors().disable()
        .authorizeRequests()
	    	.antMatchers("/", "/review/list", "/review/detail/**", "/review/api/BoardList").permitAll()
	    	.antMatchers( "/review/api/boardDetail", "/review/api/boardViewCnt").permitAll()
	    	.antMatchers("/register/**", "/login/**", "/loginProc", "/forgotPw", "/resetPw", "/main/**").permitAll()
	    	.antMatchers("/comment/api/commentList", "/15077756/v1/vaccine-stat").permitAll()
	    	.antMatchers("/vaccinationStatus", "/defStatus").permitAll()
	    	.antMatchers("/review/update", "/comment/api/write", "/comment/api/update", "/comment/api/delete").hasAnyRole("USER", "ADMIN")
        	.antMatchers("/like/api/likeInsert", "/myPage/**", "/review/write").hasAnyRole("USER", "ADMIN")
        	.antMatchers("/admin/**", "/admin/api/**").hasRole("ADMIN")
            .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginPage("/login").permitAll()
            .loginProcessingUrl("/loginProc")
            .defaultSuccessUrl("/")
            .failureHandler(loginFailureHandler)
        .and()
            .logout()
            .logoutSuccessUrl("/")
        .and().csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
