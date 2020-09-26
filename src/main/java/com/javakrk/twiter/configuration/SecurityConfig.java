package com.javakrk.twiter.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/",
                        "/newuser",
                        "/MainPage")
                .hasAnyRole("user", "administrator")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .headers()
                .frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .defaultSuccessUrl("/MainPage")
                .and()
                .logout()
                .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.jdbcAuthentication()
                .usersByUsernameQuery("SELECT users.login, users.password, 1 FROM users WHERE users.login=?")
                .authoritiesByUsernameQuery("SELECT users.login, roles.role FROM users JOIN roles ON users.role_id=roles.id WHERE users.login=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }
}
