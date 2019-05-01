package mx.nube.uaifus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import mx.nube.uaifus.filtros.TokenFiltro;
import mx.nube.uaifus.repository.UsuarioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);
    @Autowired
    private UsuarioRepository usuarioRepository;

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().disable().authorizeRequests()
                .antMatchers("/user/login", "/user/signup", "/episode/view/{id}", "/episode/view/{id}/completo")
                .permitAll().anyRequest().authenticated().and()
                .addFilterBefore(new TokenFiltro(usuarioRepository), BasicAuthenticationFilter.class);
    }
}