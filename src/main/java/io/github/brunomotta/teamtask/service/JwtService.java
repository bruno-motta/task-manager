package io.github.brunomotta.teamtask.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Value("${JWT_SECRET}")
    private String jwtSecret;

    @Value("${spring.jwt.expiration}")
    private Long jwtExpiration;





}
