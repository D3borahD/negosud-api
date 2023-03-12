package fr.negosud.api.Config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration implements WebMvcConfigurer {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                //.requestMatchers("/api/v1/**").permitAll()
                //.requestMatchers("/api/v1/products/**").permitAll()
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/api/v1/shopping-carts/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/products/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/houses/**").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/families/**").permitAll()
                // ajouter shopping-cart ici
                .requestMatchers("api/v1/addresses/**", "api/v1/customer-orders").authenticated()
                .requestMatchers(HttpMethod.GET,"/api/v1/users/**" ).authenticated()
                .requestMatchers(HttpMethod.PUT,"/api/v1/users/**" ).authenticated()
                .requestMatchers(HttpMethod.DELETE,"/api/v1/users/**").authenticated()
                .requestMatchers("/api/v1/suppliers/**","api/v1/supplier-orders/**","api/v1/families/**","api/v1/houses/**", "api/v1/products/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/v1/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
