package za.ac.cput.groupx30.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password("admin")
                .roles(USER_ROLE, ADMIN_ROLE)
                .and()
                .withUser("user")
                .password("password")
                .roles(USER_ROLE)
                //You may add extra roles if you wish
                .and()
                .withUser("Shaheed")
                .password(encoder().encode("987654321"))
                .roles(USER_ROLE);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                //Route
                .antMatchers(HttpMethod.POST, "/route/create").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/route/read/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT, "/route/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/route/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/route/all").hasRole(USER_ROLE)
                //LocationRoute
                .antMatchers(HttpMethod.POST, "/locationRoute/create").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/locationRoute/read/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.DELETE, "/locationRoute/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/locationRoute/all").hasRole(USER_ROLE)
                //Location
                .antMatchers(HttpMethod.POST, "/location/create").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/location/read/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT, "/location/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/location/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/location/all").hasRole(USER_ROLE)

                /*-- Please add the rest of the classes below --*/
                //Passenger
                .antMatchers(HttpMethod.POST, "/passenger/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/passenger/read").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT, "/passenger/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/passenger/delete").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/passenger/getall").hasRole(USER_ROLE)
                //PassengerTicket
                .antMatchers(HttpMethod.POST, "/passengerTicket/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/passengerTicket/read").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT, "/passengerTicket/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/passengerTicket/delete").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/passengerTicket/getall").hasRole(USER_ROLE)



                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
