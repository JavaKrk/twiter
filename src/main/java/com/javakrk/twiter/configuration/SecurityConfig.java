package com.javakrk.twiter.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/",
                        "/login",
                        "/newuser")
                .hasAnyRole("USER", "ADMIN")
                .anyRequest().permitAll().and()
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
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception{
        authentication.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("pass"))
                .roles("USER");

        authentication.jdbcAuthentication()
                .usersByUsernameQuery("select users.login, users.password, 1 from users users where users.login=?")
                .authoritiesByUsernameQuery("select users.login, 'ROLE_USER' from users users where users.login=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);

    }
}
