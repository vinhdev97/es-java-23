package com.vinhdev97.es.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.DelegatingJwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {

  DelegatingJwtGrantedAuthoritiesConverter authoritiesConverter =
      // Using the delegating converter multiple converters can be combined
      new DelegatingJwtGrantedAuthoritiesConverter(
          // First add the default converter
          new JwtGrantedAuthoritiesConverter(),
          // Second add our custom Keycloak specific converter
          new RealmRoleConverter());

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET, "/api/**")
        .authenticated()
        .requestMatchers("/api/**")
        .authenticated()
        .anyRequest()
        .permitAll();
    http.cors().disable();
    http.oauth2Login(Customizer.withDefaults());
    http.oauth2ResourceServer()
        .jwt()
        .jwtAuthenticationConverter(
            jwt -> new JwtAuthenticationToken(jwt, authoritiesConverter.convert(jwt)));

    return http.build();
  }
}
