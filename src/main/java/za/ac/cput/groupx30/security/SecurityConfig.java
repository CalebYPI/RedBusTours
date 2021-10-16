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
                .password(encoder().encode("MasterKey"))
                .roles(USER_ROLE, ADMIN_ROLE)
                .and()
                .withUser("user")
                .password(encoder().encode("password"))
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
                //WildCard for all classes
                .antMatchers(HttpMethod.POST, "**/create").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "**/read/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.PUT, "**/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "**/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "**/all").hasRole(USER_ROLE)

                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
