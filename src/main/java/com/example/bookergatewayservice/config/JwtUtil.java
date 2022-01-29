package com.example.bookergatewayservice.config;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtUtil {
	private JWTVerifier verifier;
	@Value("${jwt.secret}")
	private String secret;

	@PostConstruct
	public void init() {
		verifier = JWT.require(Algorithm.HMAC256(secret)).build();
	}

	public Map<String, Claim> getAllClaimsFromToken(String token) {
		DecodedJWT decodedJWT = verifier.verify(token);
		return decodedJWT.getClaims();
	}

	private boolean isTokenExpired(String token) {
		DecodedJWT decodedJWT = verifier.verify(token);
		return decodedJWT.getExpiresAt().before(new Date());
	}

	public boolean isInvalid(String token) {
		return this.isTokenExpired(token);
	}

}
