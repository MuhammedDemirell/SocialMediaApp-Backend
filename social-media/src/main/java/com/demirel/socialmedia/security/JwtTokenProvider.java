package com.demirel.socialmedia.security;

import com.demirel.socialmedia.repository.UserRepository;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${social-media.app.secret}")
    private String APP_SECRET;
    @Value("${social-media.app.expiration}")
    private long EXPIRATION_TIME;

    private final UserRepository userRepository;

    public String generateToken(String userName){


        Date expiryDate = new Date(new Date().getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(Long.toString(userRepository.findByUserName(userName).getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, APP_SECRET)
                .compact();
    }

    Long getUserIdFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(APP_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }
    
    boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (SignatureException e) {
            return false;
        } catch (MalformedJwtException e) {
            return false;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (UnsupportedJwtException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
      Date expiryDate = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody().getExpiration();
        return expiryDate.before(new Date());
    }
}
