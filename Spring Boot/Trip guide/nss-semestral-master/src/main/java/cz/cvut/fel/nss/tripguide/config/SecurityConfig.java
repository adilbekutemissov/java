package cz.cvut.fel.nss.tripguide.config;

import cz.cvut.fel.nss.tripguide.security.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * The type Security config.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * The Success handler.
     */
    @Autowired
    AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthProvider authProvider;

    /**
     * Gets encoder.
     *
     * @return the encoder
     */
    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Main configuration rules. Allow to access authorized members
     *
     * @param http the http
     * @throws Exception the exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/resources/**",
                        "/resources/**/**",
                        "/static/**",
                        "/static/**/**",
                        "/templates/**",
                        "templates/**/**",
                        "css/**",
                        "css/**/**",
                        "styles/**",
                        "styles/**/**",
                        "/",
                        "/login**",
                        "/registration",
                        "/h2-console/**",
                        "/api/**",
                        "/api/**/**")
                .permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/tourist/**").hasAuthority("TOURIST")
                .antMatchers("/delegate/**").hasAuthority("DELEGATE")
                .antMatchers("/guest/**").anonymous()
                .anyRequest().authenticated()
                .and().formLogin().successHandler(successHandler)
                .failureUrl("/login?error").permitAll()
                .and().logout().logoutSuccessUrl("/login").permitAll();

        http.headers().frameOptions().sameOrigin();

    }

    /**
     * Configure roles and passwords authentication.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("TOURIST")
                .and()
                .withUser("admin").password("{noop}password").roles("TOURIST", "DELEGATE", "ADMIN");

    }

}

