package project.db.security;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import project.db.repos.EmployeeRepo;
import project.db.services.EmployeeService;


@RequiredArgsConstructor
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final EmployeeRepo employeeRepo;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable().cors();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new EmployeeSecurity(employeeRepo);
    }

}