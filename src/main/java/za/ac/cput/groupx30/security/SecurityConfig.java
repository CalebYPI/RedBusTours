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
                .roles(USER_ROLE);
                //You may add extra roles if you wish
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




                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
