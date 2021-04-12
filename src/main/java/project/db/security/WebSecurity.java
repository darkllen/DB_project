package project.db.security;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.db.repos.EmployeeRepo;
import project.db.services.EmployeeService;


@RequiredArgsConstructor
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final EmployeeRepo employeeRepo;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authProvider())
                .authorizeRequests()
                .antMatchers("/*").authenticated()
                .antMatchers("/edit_check/*").authenticated()
                .antMatchers(
                        "/edit_customer_card/*",
                        "/*checks_by_curr_employee_between_time",
                        "/*check_by_check_number",
                        "/*customers_by_surname",
                        "/*customers_by_percent",
                        "/*products_by_category_sorted_name",
                        "/*all_products_name",
                        "/*promo_store_products_sorted_name_num",
                        "/*promo_store_products_sorted_num_name",
                        "/*not_promo_store_products_sorted_name_num",
                        "/*not_promo_store_products_sorted_nun_name",
                        "/*products_by_check_number",
                        "/*product_info_by_upc",
                        "/*current_employee",
                        "/check_kassir"
                ).hasAuthority("KASSIR")
                .antMatchers(
                        "/edit*/*",
                        "/add*",
                        "/remove*",
                        "/*all_categories_sorted_name",
                        "/*cassiers_sorted_surname",
                        "/*phone_address_by_empl_surname",
                        "/*products_by_category_sorted_name",
                        "/*all_products_sorted_name",
                        "/*all_products_by_category",
                        "/*all_products_in_store_by_product",
                        "/*product_by_upc",
                        "/*promo_store_products_sorted_name_num",
                        "/*promo_store_products_sorted_num_name",
                        "/*not_promo_store_products_sorted_name_num",
                        "/*not_promo_store_products_sorted_nun_name",
                        "/*checks_with_sales_by_employee_between_time",
                        "/*checks_with_sales_between_time",
                        "/*sum_recipes_by_employee_between_time",
                        "/*sum_all_recipes_between_time",
                        "/*num_product_saled_between_time",
                        "/*all_customers_contacts",
                        "/*customers_by_percent",
                        "/*product_info_by_upc",
                        "/*check_by_check_number",
                        "/*customers_by_surname",
                        "/*current_employee",
                        "/check"
                        ).hasAuthority("MANAGER")
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

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

}