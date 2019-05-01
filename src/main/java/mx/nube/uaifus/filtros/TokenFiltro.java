package mx.nube.uaifus.filtros;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import mx.nube.uaifus.model.Usuario;;
import mx.nube.uaifus.repository.UsuarioRepository;;

public class TokenFiltro extends GenericFilterBean {
    final Logger LOG = LoggerFactory.getLogger(TokenFiltro.class);
    private final UsuarioRepository usuarioRepository;

    public TokenFiltro(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest servRequest = (HttpServletRequest) request;
        String token = servRequest.getHeader(HttpHeaders.AUTHORIZATION);

        List<Usuario> usuarioEncontrado = usuarioRepository.findByToken(token);

        if (usuarioEncontrado != null && token != null && token != "" && !token.isEmpty()
                && !usuarioEncontrado.isEmpty()) {

            Authentication auth = new UsernamePasswordAuthenticationToken(token, null, null);
            SecurityContextHolder.getContext().setAuthentication(auth);

            // Usuario UsuarioQueLlamo = (Usuario)
            // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("Entro al uwu filtro");
            // Importante

        }
        chain.doFilter(request, response);

    }

}