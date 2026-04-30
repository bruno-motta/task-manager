package io.github.brunomotta.teamtask.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${JWT_SECRET}")
    private String jwtSecret;

    @Value("${spring.jwt.expiration}")
    private Long jwtExpiration;

    //Classe absc ALGORITHM vem junto com a lib auht0, HMAC256, algoritimo padrão.
    private Algorithm getAlgorithm(){
        return Algorithm.HMAC256(jwtSecret);
    }

    public String generateToken(UserDetails userDetails){
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim("role", userDetails.getAuthorities().toString())
//                .withClaim("TokenVersion", tokenVersion) //TODO: implementar depois
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtExpiration))
                .sign(getAlgorithm());
    }


}
