package com.JGG.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

//388, 395, 406, 418, 435
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    //435 Add a reference to our security data source
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);

        /* Replaced in 435
        // Add our users for in memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        // 413 Adding more roles
        auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"));
        auth.inMemoryAuthentication().withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"));
        auth.inMemoryAuthentication().withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));*/
    }

    //395, 406, 418
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // Restrict access based on the HttpServletRequest
                // .anyRequest() replaced in 418
                // .authenticated() // replaced in 418 any request must be authenticated
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin() // customization formlogin
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and() // added in 406
                .logout()
                .permitAll()
                .and()
                .exceptionHandling() // added in 421
                .accessDeniedPage("/access-denied");
    }
}
