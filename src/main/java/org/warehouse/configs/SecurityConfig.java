package org.warehouse.configs;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.warehouse.models.user.LoginFailureHandler;
import org.warehouse.models.user.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.formLogin()
				.loginPage("/user/login")
				.usernameParameter("userId")
				.passwordParameter("userPw")
				.successHandler(new LoginSuccessHandler())
				.failureHandler(new LoginFailureHandler())
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
				.logoutSuccessUrl("/user/login");

		http.authorizeHttpRequests()
				.requestMatchers("/mypage/**").authenticated() // 회원 전용
				// .requestMatchers("/admin/**").hasAuthority("ADMIN") // 관리자 전용
				.anyRequest().permitAll(); // 그외 모든 페이지는 모든 회원이 접근 가능

		http.exceptionHandling()
				.authenticationEntryPoint((req, res, e) -> {
					String URI = req.getRequestURI();

					if (URI.indexOf("/admin") != -1) { // 관리자 페이지
						res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "NOT AUTHORIZED");
					} else { // 회원 전용 페이지
						String redirectURL = req.getContextPath() + "/user/login";
						res.sendRedirect(redirectURL);
					}
				});

		http.headers().frameOptions().sameOrigin();

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return w -> w.ignoring().requestMatchers("/css/**", "/js/**", "/images/**", "/errors/**", "/mybatis/**");
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
