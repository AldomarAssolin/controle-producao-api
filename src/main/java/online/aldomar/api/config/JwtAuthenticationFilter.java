package online.aldomar.api.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final JwtTokenUtil tokenUtil;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      @org.springframework.lang.NonNull HttpServletRequest req,
      @org.springframework.lang.NonNull HttpServletResponse res,
      @org.springframework.lang.NonNull FilterChain chain) throws java.io.IOException, jakarta.servlet.ServletException {
    String authHeader = req.getHeader("Authorization");
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      String token = authHeader.substring(7);
      if (tokenUtil.validateToken(token)) {
        String username = tokenUtil.getUsername(token);
        UserDetails user = userDetailsService.loadUserByUsername(username);
        var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    }
    chain.doFilter(req, res);
  }
}